package com.glasssellmanagersystem.controller;

import com.glasssellmanagersystem.pojo.Customer;
import com.glasssellmanagersystem.pojo.PageInfo;
import com.glasssellmanagersystem.pojo.RegisterInfo;
import com.glasssellmanagersystem.service.CustomerService;
import com.glasssellmanagersystem.service.RegisterInfoService;
import com.glasssellmanagersystem.utils.DateFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RegisterInfoController {
    @Autowired
    RegisterInfoService registerInfoService;
    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/user/registerInfo/addRegisterInfo",method = RequestMethod.POST)
    @ResponseBody
    public void addRegisterInfo(RegisterInfo registerInfo){
        DateFormatUtil getDate = new DateFormatUtil();
        Customer customer = new Customer();
        customer.setCustomer_PDLeft(registerInfo.getRegisterInfo_PDLeft());
        customer.setCustomer_PDRight(registerInfo.getRegisterInfo_PDRight());
        customer.setCustomer_history(registerInfo.getRegisterInfo_history());
        customer.setCustomer_visionLeft(registerInfo.getRegisterInfo_visionLeft());
        customer.setCustomer_visionRight(registerInfo.getRegisterInfo_visionRight());
        customer.setCustomer_id(registerInfo.getRegisterInfo_customerId());
        customerService.completeCustomerInformation(customer);
        registerInfo.setRegisterInfo_createDate(getDate.getDate());
        customerService.upCheckTime(getDate.getDate(),registerInfo.getRegisterInfo_customerId());
        registerInfoService.addRegisterInfo(registerInfo);
    }

    @RequestMapping(value = "/user/registerInfo/findCustomerRegisterInfoById/{id}")
    public String findCustomerRegisterInfoById(@PathVariable(name = "id") Integer id, Integer pageIndex, Integer pageSize ,Model model){
        PageInfo<RegisterInfo> registerInfoPageInfo = registerInfoService.getAllRegisterForCustomerByCustomerId(pageIndex,1,id);
        System.out.println(registerInfoPageInfo);
        Customer customer = customerService.findCustomerById(id);
        String age = customerService.getCustomerAge(id);
        model.addAttribute("pages",registerInfoPageInfo);
        model.addAttribute("customer",customer);
        model.addAttribute("age",age);
        return "customer_registerinfo";
    }
}
