package com.example.glasssellmanagersystem;

import com.glasssellmanagersystem.pojo.Customer;
import com.glasssellmanagersystem.pojo.RegisterInfo;
import com.glasssellmanagersystem.pojo.School;
import com.glasssellmanagersystem.pojo.User;
import com.glasssellmanagersystem.service.*;
import com.glasssellmanagersystem.utils.DateFormatUtil;
import com.glasssellmanagersystem.utils.MD5Util;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.sql.DataSource;
import java.io.File;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
class GlassSellManagerSystemApplicationTests {
    @Autowired
    DataSource dataSource;

    @Autowired
    UserService userService;

    @Autowired
    CustomerService customerService;

    @Autowired
    SchoolService schoolService;

    @Autowired
    RegisterInfoService registerInfoService;

    @Autowired
    OrderService orderService;

    @Autowired
    JavaMailSenderImpl javaMailSender;

    @Test
    public void litleMailTest(){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("通知");
        mailMessage.setText("你好！");
        mailMessage.setTo("qq498684205qq@gmail.com");
        mailMessage.setFrom("shilimei_glass@163.com");
        javaMailSender.send(mailMessage);
    }
    @Test
    public void miniMailTest(){
//        SimpleMailMessage mailMessage = new SimpleMailMessage();
//        mailMessage.setSubject("通知");
//        mailMessage.setText("你好！");
//        mailMessage.setTo("qq498684205qq@gmail.com");
//        mailMessage.setFrom("shilimei_glass@163.com");
//        javaMailSender.send(mailMessage);
        //一个复杂的邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            //组装
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
            mimeMessageHelper.setSubject("通知：");
            mimeMessageHelper.setText("<p style='color:red'>你好！</p>",true);
            //附件
//            mimeMessageHelper.addAttachment("1.jpg",new File("C:\\Users\\Administrator\\Desktop\\1.jpg"));

            mimeMessageHelper.setTo("qq498684205qq@gmail.com");
            mimeMessageHelper.setFrom("shilimei_glass@163.com");
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void findOrderByRegisterInfoId(){
        int a = orderService.findOrderByRegisterInfoId(1);
        System.out.println(a);
    }
    @Test
    public void findRegisterInfoByIdTest(){
        int id = 1;
        RegisterInfo registerInfo = registerInfoService.getRegisterInfoById(id);
        System.out.println(registerInfo);
    }
    @Test
    public void upCheckTimeTest(){
        DateFormatUtil dateFormatUtil = new DateFormatUtil();
        int id = 3;
        customerService.upCheckTime(dateFormatUtil.getDate(),id);
    }

    @Test
    public void getCustomerAgeTest(){
        String age = customerService.getCustomerAge(4);
        System.out.println(age);
    }
    @Test
    public void findSchoolsTest(){
        List<School> schools = schoolService.findAllSchool();
        for (School school:schools){
            System.out.println(school);
        }
    }
    @Test
    public void findUserTest(){
        List<User> users = userService.finAllUsers();
        for (User user : users){
            System.out.println(user);
        }
    }

    @Test
    public void findUserByNameTest(){
        String username = "admin";
        User user = userService.findUserByUsername(username);
        System.out.println(user);
    }

    @Test
    public void addUserTest(){
        String name = "测试";
        SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date time = new Date();
        String birthday = sFormat.format(time);
        String address = "四川省成都市";
        String username = "10000";
        MD5Util md5Util = new MD5Util();
        String password = md5Util.MD5EncodeUtf8("admin");
        String position = "员工";
        String email = "@qq.com";
        String permission = "user:staff";
        char sex = '男';
        String phonenumber = "19900000";
        User user =  new User();
        for (int i = 1;i<=9;i++){
            user.setName(name + i);
            user.setBirthday(birthday);
            user.setAddress(address + i);
            user.setUsername(username + i);
            user.setPassword(password);
            user.setPosition(position + i);
            user.setEmail(i + email);
            user.setPermission(permission);
            user.setSex(sex);
            user.setPhonenumber(phonenumber + i);
            userService.addUser(user);
        }


    }
    @Test
    void contextLoads() {
        System.out.println(dataSource.getClass());
        try {
            System.out.println(dataSource.getConnection());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Test
    public void addCustomerTest(){
        String customer_address = "北京省市辖区(区/县)东城区1221";
        String customer_birthday = "2021-05-21";
        String customer_email = "1@qq.com";
        String customer_height = "112";
        String customer_name = "21";
        String customer_phoneNumber = "12111111111";
        String customer_schoolName = "学校1";
        char customer_sex = '男';
        String customer_weight = "21";
        Customer customer = new Customer();
        customer.setCustomer_address(customer_address);
        customer.setCustomer_birthday(customer_birthday);
        customer.setCustomer_email(customer_email);
        customer.setCustomer_height(customer_height);
        customer.setCustomer_name(customer_name);
        customer.setCustomer_phoneNumber(customer_phoneNumber);
        customer.setCustomer_schoolName(customer_schoolName);
        customer.setCustomer_sex(customer_sex);
        customer.setCustomer_weight(customer_weight);
        customerService.addCustomer(customer);

    }

}
