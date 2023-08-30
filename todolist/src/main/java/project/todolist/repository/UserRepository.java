package project.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.todolist.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User save(User user);

    Optional<User> findByUserId(String userId);

    Optional<User> findByUserPw(String userPw);
}
