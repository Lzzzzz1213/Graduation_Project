package com.glasssellmanagersystem.controller;

import com.glasssellmanagersystem.pojo.Customer;
import com.glasssellmanagersystem.pojo.PageInfo;
import com.glasssellmanagersystem.pojo.School;
import com.glasssellmanagersystem.pojo.User;
import com.glasssellmanagersystem.service.*;
import com.glasssellmanagersystem.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    UserService userService;
    @Autowired
    SchoolService schoolService;
    @Autowired
    RegisterInfoService registerInfoService;
    @Autowired
    ReviewService reviewService;


    @RequestMapping("/user/customer/findCustomer")
    public String findCustomer(HttpSession session,Model model,Integer pageIndex,Integer pageSize){
        PageInfo<Customer> customerPageInfo = customerService.findPageInfo(pageIndex, pageSize);
        model.addAttribute("pages",customerPageInfo);
        model.addAttribute("user",session);
        return "customer-list";
    }

    @RequestMapping("/user/customer/openAddCustomerPage/{id}")
    public String openAddCustomerPage(@PathVariable(name = "id") Integer id, Model model){
        User user = userService.finUserById(id);
        List<School> schools = schoolService.findAllSchool();
        model.addAttribute("user",user);
        model.addAttribute("schools",schools);
        return "customer-add";
    }

    @RequestMapping("/user/customer/addCustomer")
    @ResponseBody
    public void addCustomer(Customer customer){
        int a = customerService.addCustomer(customer);
    }

    @RequestMapping("/user/customer/getCustomerAge/{id}")
    @ResponseBody
    public String getCustomerAge(@PathVariable(name = "id") Integer id){
        String age = customerService.getCustomerAge(id);
        return age;
    }

    @RequestMapping("/user/customer/openCustomerRegisterInfoPage/{id}")
    public String openCustomerRegisterInfoPage(@PathVariable(name = "id") Integer id,Model model){
        Customer customer = customerService.findCustomerById(id);
        String age = customerService.getCustomerAge(id);
        model.addAttribute("customer",customer);
        model.addAttribute("age",age);
        return "registerinfo-add";
    }

    @RequestMapping("/user/customer/vip/findVipCustomers")
    public String findVipCustomers(Model model,Integer pageIndex,Integer pageSize){
        PageInfo<Customer> customerPageInfo = customerService.findVipPageInfo(pageIndex, pageSize);
        model.addAttribute("pages",customerPageInfo);
        return "customer-vip-list";
    }

    @RequestMapping("/user/customer/vip/openCompleteInfoPage/{id}")
    public String openCompleteInfoPage(@PathVariable(name = "id") Integer customer_id,Model model){
        Customer customer = customerService.findCustomerById(customer_id);
        String age = customerService.getCustomerAge(customer_id);
        model.addAttribute("customer",customer);
        model.addAttribute("age",age);
        return "customer-message-edit";
    }

    @RequestMapping(value = "/user/customer/completeInfo",method = RequestMethod.POST)
    @ResponseBody
    public void completeInfo(Customer customer){
        customerService.completeInfo(customer);
    }

    @RequestMapping("/user/customer/openCustomerEditPage/{id}")
    public String openCustomerEditPage(@PathVariable(name = "id")Integer customer_id,Model model){
        Customer customer = customerService.findCustomerById(customer_id);
        List<School> schools = schoolService.findAllSchool();
        model.addAttribute("customer",customer);
        model.addAttribute("schools",schools);
        return "customer-edit";
    }

    @RequestMapping(value = "/user/customer/customerEdit",method = RequestMethod.POST)
    @ResponseBody
    public void customerEdit(Customer customer){
        customerService.customerInfoEdit(customer);
    }

    @RequestMapping("/user/customer/openCustomerDeletePage/{id}")
    public String openCustomerDeletePage(@PathVariable(name = "id") Integer customer_id,Model model){
        model.addAttribute("customer_id",customer_id);
        return "customer-delete";
    }

    @RequestMapping("/user/customer/customerDelete")
    @ResponseBody
    public void customerDelete(String password, Integer id, Integer customer_id, HttpServletResponse httpServletResponse){
        int a = userService.checkUserPassById(id, MD5Util.MD5EncodeUtf8(password));
        System.out.println(a);
        if (a == 0){
            try {
                httpServletResponse.sendError(403);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            customerService.deleteCustomerById(customer_id);
            registerInfoService.deleteRegisterByCustomerId(customer_id);
            reviewService.deleteReviewByCustomerId(customer_id);
        }
    }
}
