package com.glasssellmanagersystem.dao;

import org.apache.ibatis.annotations.Mapper;
import com.glasssellmanagersystem.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    User findUser(User user);

    List<User> finAllUsers();

    User findUserByUsername(String username);

    List<User> getAllUserList(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    Integer totalCount();

    int addUser(User user);

    int upDataUser(User user);

    User finUserById(Integer id);

    int deleteUser(Integer id);

    int changeUserPass(User user);

    int checkUserPassById(Integer id,String password);
}
