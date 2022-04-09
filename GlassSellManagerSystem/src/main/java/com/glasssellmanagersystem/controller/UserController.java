package com.glasssellmanagersystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.glasssellmanagersystem.config.StartRunner;
import com.glasssellmanagersystem.dao.UserMapper;
import com.glasssellmanagersystem.pojo.PageInfo;
import com.glasssellmanagersystem.pojo.SystemInfo;
import com.glasssellmanagersystem.pojo.User;
import com.glasssellmanagersystem.service.UserService;
import com.glasssellmanagersystem.service.UserServiceImp;
import com.glasssellmanagersystem.service.WelcomeService;
import com.glasssellmanagersystem.utils.MD5Util;
import com.glasssellmanagersystem.utils.SystemInfoUtils;
import jdk.dynalink.SecureLookupSupplier;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.UnknownHostException;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    WelcomeService welcomeService;
    @Autowired
    StartRunner startRunner;

    @RequestMapping("/user/login")
    public String login(User user, Model model, HttpSession session, HttpServletRequest request){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), MD5Util.MD5EncodeUtf8(user.getPassword()));
        try {
            //进入shiro匹配数据库
            subject.login(token);
            //真返回数据库信息保存在subject中，作强制转化到User，model使用同SSM
            User currentUser = (User) subject.getPrincipal();
//            model.addAttribute("user",currentUser);
            session.setAttribute("user",currentUser);
            return "index";
        }catch (UnknownAccountException e){
            model.addAttribute("msg","用户名错误");
            return "login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            return "login";
        }
    }
    @RequestMapping("/user/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }
    @RequestMapping("/user/welcome")
    public String welcome(Model model,HttpSession session) throws UnknownHostException {
        SystemInfo systemInfo = startRunner.getSystemInfo();
        model.addAttribute("systemInfo",systemInfo);
        int countCustomer = welcomeService.countCustomer();
        int countVipCustomer = welcomeService.countVipCustomer();
        int countOrder = welcomeService.countOrder();
        int countProduct = welcomeService.countProduct();
        int countProductPackage = welcomeService.countProductPackage();
        int countSchool = welcomeService.countSchool();
        int lastDayOrder = welcomeService.lastDayOrder();
        int lastDayCustomer = welcomeService.lastDayCustomer();
        int nowDayOrder = welcomeService.nowDayOrder();
        int nowDayCustomer = welcomeService.nowDayCustomer();
        model.addAttribute("countCustomer",countCustomer);
        model.addAttribute("countVipCustomer",countVipCustomer);
        model.addAttribute("countOrder",countOrder);
        model.addAttribute("countProduct",countProduct);
        model.addAttribute("countProductPackage",countProductPackage);
        model.addAttribute("countSchool",countSchool);
        model.addAttribute("lastDayOrder",lastDayOrder);
        model.addAttribute("lastDayCustomer",lastDayCustomer);
        model.addAttribute("nowDayOrder",nowDayOrder);
        model.addAttribute("nowDayCustomer",nowDayCustomer);
        model.addAttribute("user",session);
        return "welcome";
    }
    @RequestMapping("/user/findUsers")
    public String findAllUsers(Integer pageIndex, Integer pageSize, Model model){
        PageInfo<User> userPageInfo = userService.findPageInfo(pageIndex, pageSize);
        model.addAttribute("pages",userPageInfo);
        return "member-list";
    }

//    @RequestMapping("/user/findUsers")
//    public String finUsers(Integer pageIndex, Integer pageSize, Model model){
//        PageInfo<User> userPageInfo = userService.findPageInfo(pageIndex, pageSize);
//        model.addAttribute("pages", userPageInfo);
//        return "member-list-test";
//    }


    @RequestMapping(value = "/user/updataUser" , method = RequestMethod.POST)
    @ResponseBody
    public String upDataUser(User user){
        int a = userService.upDataUser(user);
        return "member-list";
    }
    @RequestMapping("/user/findUserById/{id}")
    public String findUserById(@PathVariable(name = "id") Integer id,HttpSession session){
        User user = userService.finUserById(id);
        session.setAttribute("user",user);
        return "member-edit";
    }

    @RequestMapping("/user/deleteUser")
    @ResponseBody
    public String deleteUser(Integer id){
        int a = userService.deleteUser(id);
        return "member-list";
    }
    @RequestMapping("/user/addUser")
    @ResponseBody
    public void addUser(User user){
        int a = userService.addUser(user);
    }

    @RequestMapping("/user/openAddUserPage")
    public String openAddUserPage(){
        return "member-add";
    }

    @RequestMapping("/user/openChangeUserPass/{id}")
    public String openChangePassPage(@PathVariable(name = "id") Integer id,Model model){
        User user = userService.finUserById(id);
        model.addAttribute("user",user);
        return "member-password";
    }
    @RequestMapping("/user/changeUserPass")
    @ResponseBody
    public String changeUserPass(User user){
        int a = userService.changeUserPass(user);
        return "member-lis";
    }
    }
