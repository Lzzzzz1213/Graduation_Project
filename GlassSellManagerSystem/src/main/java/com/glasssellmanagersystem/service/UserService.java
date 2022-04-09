package com.glasssellmanagersystem.service;

import com.glasssellmanagersystem.pojo.PageInfo;
import com.glasssellmanagersystem.pojo.User;

import java.util.List;

public interface UserService {

    User findUser(User user);

    List<User> finAllUsers();

    User findUserByUsername(String username);

    PageInfo<User> findPageInfo(Integer pageIndex, Integer pageSize);

    int addUser(User user);

    int upDataUser(User user);

    User finUserById(Integer id);

    int deleteUser(Integer id);

    int changeUserPass(User user);

    int checkUserPassById(Integer id,String password);


}
