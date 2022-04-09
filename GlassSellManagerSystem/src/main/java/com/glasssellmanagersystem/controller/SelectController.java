package com.glasssellmanagersystem.controller;

import com.glasssellmanagersystem.pojo.*;
import com.glasssellmanagersystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SelectController {
    @Autowired
    SelectService selectService;

    @RequestMapping("/user/findUserByName")
    public String findUserByName(Model model,String name,Integer pageIndex,Integer pageSize){
        PageInfo<User> userPageInfo = selectService.findUserByName(pageIndex, pageSize, name);
        model.addAttribute("pages",userPageInfo);
        return "member-list";
    }
    @RequestMapping("/user/findCustomerByName")
    public String findCustomerByName(Model model,String customer_name,Integer pageIndex,Integer pageSize){
        PageInfo<Customer> customerPageInfo = selectService.findCustomerByName(pageIndex, pageSize, customer_name);
        model.addAttribute("pages",customerPageInfo);
        return "customer-list";
    }
    @RequestMapping("/user/findVipCustomerByName")
    public String findVipCustomerByName(Model model,String customer_name,Integer pageIndex,Integer pageSize){
        PageInfo<Customer> customerPageInfo = selectService.findVipCustomerByName(pageIndex, pageSize, customer_name);
        model.addAttribute("pages",customerPageInfo);
        return "customer-vip-list";
    }
    @RequestMapping("/user/findOrderByName")
    public String findOrderByName(Model model,String order_customerName,Integer pageIndex,Integer pageSize){
        PageInfo<Order> orderPageInfo = selectService.findOrderByName(pageIndex, pageSize, order_customerName);
        model.addAttribute("pages",orderPageInfo);
        return "order-list";
    }
    @RequestMapping("/user/findProductByName")
    public String findProductByName(Model model,String product_name,Integer pageIndex,Integer pageSize){
        PageInfo<Product> productPageInfo = selectService.findProductByName(pageIndex, pageSize, product_name);
        model.addAttribute("pages",productPageInfo);
        return "product-list";
    }
    @RequestMapping("/user/findProductPackageByName")
    public String findProductPackageByName(Model model,String productPackage_name,Integer pageIndex,Integer pageSize){
        PageInfo<ProductPackage> productPackagePageInfo = selectService.findProductPackageByName(pageIndex, pageSize, productPackage_name);
        model.addAttribute("pages",productPackagePageInfo);
        return "productPackage-list";
    }
    @RequestMapping("/user/findSchoolByName")
    public String findSchoolByName(Model model,String school_name,Integer pageIndex,Integer pageSize){
        PageInfo<School> schoolPageInfo = selectService.findSchoolByName(pageIndex, pageSize, school_name);
        model.addAttribute("pages",schoolPageInfo);
        return "school-list";
    }
    @RequestMapping("/user/findEmailSendByName")
    public String findEmailSendByName(Model model,String emailSend_from,Integer pageIndex,Integer pageSize){
        PageInfo<EmailSend> emailSendPageInfo = selectService.findEmailSendByName(pageIndex, pageSize, emailSend_from);
        model.addAttribute("pages",emailSendPageInfo);
        return "email-list";
    }
}
