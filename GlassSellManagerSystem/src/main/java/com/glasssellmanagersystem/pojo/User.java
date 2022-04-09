package com.glasssellmanagersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private String birthday;
    private String address;
    private String username;
    private String password;
    private String position;
    private String email;
    private String permission;
    private char sex;
    private String phonenumber;
}
