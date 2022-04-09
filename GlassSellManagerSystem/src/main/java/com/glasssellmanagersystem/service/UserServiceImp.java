package com.glasssellmanagersystem.service;

import com.glasssellmanagersystem.dao.UserMapper;
import com.glasssellmanagersystem.pojo.PageInfo;
import com.glasssellmanagersystem.pojo.User;
import com.glasssellmanagersystem.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService{
    @Autowired
    UserMapper userMapper;

    @Override
    public User findUser(User user) {
        return userMapper.findUser(user);
    }

    @Override
    public List<User> finAllUsers() {
        return userMapper.finAllUsers();
    }

    @Override
    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

    //分页查询
    @Override
    public PageInfo<User> findPageInfo(Integer pageIndex, Integer pageSize) {
        PageInfo<User> userPageInfo = new PageInfo<User>();
        userPageInfo.setPageIndex(pageIndex);
        userPageInfo.setPageSize(pageSize);
        //获取总数
        Integer totalCount = userMapper.totalCount();
        if (totalCount > 0){
            userPageInfo.setTotalCount(totalCount);
            List<User> userList = userMapper.getAllUserList((userPageInfo.getPageIndex() - 1) * userPageInfo.getPageSize(), userPageInfo.getPageSize());
            userPageInfo.setList(userList);
        }
        return userPageInfo;
    }

    @Override
    public int addUser(User user) {
        user.setUsername(user.getPhonenumber());
        user.setPassword(MD5Util.MD5EncodeUtf8(user.getPhonenumber()));
        if (user.getPosition().equals("员工")){
            user.setPermission("user:staff");
        }else if (user.getPosition().equals("主管")){
            user.setPermission("user:staff");
        }else if (user.getPosition().equals("老板")){
            user.setPermission("user:boss");
        }
        return userMapper.addUser(user);
    }

    @Override
    public int upDataUser(User user) {
        if (user.getPosition().equals("员工")){
            user.setPermission("user:staff");
        }else if (user.getPosition().equals("老板")){
            user.setPermission("user:boss");
        }else if(user.getPosition().equals("管理员")){
            user.setPermission("user:admin");
        }
        return userMapper.upDataUser(user);
    }

    @Override
    public User finUserById(Integer id) {
        return userMapper.finUserById(id);
    }

    @Override
    public int deleteUser(Integer id) {
        return userMapper.deleteUser(id );
    }

    @Override
    public int changeUserPass(User user) {
        user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));
        return userMapper.changeUserPass(user);
    }

    @Override
    public int checkUserPassById(Integer id, String password) {
        return userMapper.checkUserPassById(id,password);
    }




}
