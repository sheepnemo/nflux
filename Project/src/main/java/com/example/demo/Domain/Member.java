package com.example.demo.Domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class Member {
	
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String userName;

    private String userId;

    private String userPassword;

    public void saveMemberInfo(String userName, String userId, String userPassword){
        this.userName = userName;
        this.userId = userId;
        this.userPassword = userPassword;
    }

}
