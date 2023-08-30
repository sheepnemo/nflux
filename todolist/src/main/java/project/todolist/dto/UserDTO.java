package project.todolist.dto;

import lombok.Getter;
import project.todolist.domain.DataList;
import project.todolist.domain.User;

import java.util.List;

@Getter
public class UserDTO {

    private Long id;

    private String userName;

    private String userId;

    private String userPw;

    private List<DataList> dataLists;

    public UserDTO() {}

    public UserDTO(String userId, String userPw) {
        this.userId = userId;
        this.userPw = userPw;
    }

    public UserDTO(String userName, String userId, String userPw) {
        this.userName = userName;
        this.userId = userId;
        this.userPw = userPw;
    }

    public User toEntity() { return new User(userName, userId, userPw); }
}
