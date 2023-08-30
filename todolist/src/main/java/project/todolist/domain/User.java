package project.todolist.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity(name = "TDL_USER")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "U_NAME")
    private String userName = null;

    @Column(name = "U_ID")
    private String userId = null;

    @Column(name = "U_PW")
    private String userPw = null;

    @OneToMany
    @JoinColumn(name = "USER_ID")
    private List<DataList> dataLists = new ArrayList<>();

    public User() {}

    public User(String userName, String userId, String userPw) {
        this.userName = userName;
        this.userId = userId;
        this.userPw = userPw;
    }
}
