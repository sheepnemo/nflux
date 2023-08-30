package project.todolist.service;

import org.springframework.stereotype.Service;
import project.todolist.domain.User;
import project.todolist.dto.UserDTO;
import project.todolist.repository.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //회원 가입
    public void join(UserDTO userDTO) {
        User user = userDTO.toEntity();
        if (validateDuplicateUser(user)) {
            if ((userDTO.getUserId() != null) && (userDTO.getUserPw()) != null) {
                userRepository.save(user);
            }
        }
    }

    //중복 회원 검증
    private boolean validateDuplicateUser(User user) {
        if (userRepository.findByUserId(user.getUserId()).isPresent()) {
            return false;
        }
        else return true;
    }

    //회원 검증
    private boolean validateUser(User user) {
        if (userRepository.findByUserId(user.getUserId()).isPresent()) {
            return true;
        }
        else return false;
    }

    //비밀번호 검증
    private boolean validateDuplicatePw(User user) {
        if (userRepository.findByUserPw(user.getUserPw()).isPresent()) {
            return true;
        }
        else return false;
    }

    //로그인
    public boolean login(UserDTO userDTO) {
        User user = userDTO.toEntity();
        if (validateUser(user)) {
            if (validateDuplicatePw(user)) {
                return true;
            }
            else return false;
        }
        else return false;
    }

    //로그인 아이디(고유값) 불러오기
    public Long searchPKId(String userId) {
        User user = userRepository.findByUserId(userId).get();
        return user.getId();
    }
}
