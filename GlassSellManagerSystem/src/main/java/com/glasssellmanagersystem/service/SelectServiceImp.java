package com.glasssellmanagersystem.service;

import com.glasssellmanagersystem.dao.SelectMapper;
import com.glasssellmanagersystem.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SelectServiceImp implements SelectService{
    @Autowired
    SelectMapper selectMapper;
    @Override
    public PageInfo<User> findUserByName(Integer pageIndex, Integer pageSize,String name) {
        PageInfo<User> userPageInfo = new PageInfo<User>();
        userPageInfo.setPageIndex(pageIndex);
        userPageInfo.setPageSize(pageSize);
        int totalCount = selectMapper.countUserByName(name);
        if (totalCount > 0){
            userPageInfo.setTotalCount(totalCount);
            List<User> userList = selectMapper.findUserByName((userPageInfo.getPageIndex() - 1) * userPageInfo.getPageSize(), userPageInfo.getPageSize(),name);
            userPageInfo.setList(userList);
        }
        return userPageInfo;
    }

    @Override
    public PageInfo<Customer> findCustomerByName(Integer pageIndex, Integer pageSize, String customer_name) {
        PageInfo<Customer> customerPageInfo = new PageInfo<Customer>();
        customerPageInfo.setPageIndex(pageIndex);
        customerPageInfo.setPageSize(pageSize);
        int totalCount = selectMapper.countCustomerByName(customer_name);
        if (totalCount > 0){
            customerPageInfo.setTotalCount(totalCount);
            List<Customer> customerList = selectMapper.findCustomerByName((customerPageInfo.getPageIndex()-1) * customerPageInfo.getPageSize(),customerPageInfo.getPageSize(),customer_name);
            customerPageInfo.setList(customerList);
        }
        return customerPageInfo;
    }

    @Override
    public PageInfo<Customer> findVipCustomerByName(Integer pageIndex, Integer pageSize, String customer_name) {
        PageInfo<Customer> customerPageInfo = new PageInfo<Customer>();
        customerPageInfo.setPageIndex(pageIndex);
        customerPageInfo.setPageSize(pageSize);
        int totalCount = selectMapper.countVipCustomerByName(customer_name);
        if (totalCount > 0){
            customerPageInfo.setTotalCount(totalCount);
            List<Customer> customerList = selectMapper.findVipCustomerByName((customerPageInfo.getPageIndex()-1) * customerPageInfo.getPageSize(),customerPageInfo.getPageSize(),customer_name);
            customerPageInfo.setList(customerList);
        }
        return customerPageInfo;
    }

    @Override
    public PageInfo<Order> findOrderByName(Integer pageIndex, Integer pageSize, String order_customerName) {
        PageInfo<Order> orderPageInfo = new PageInfo<Order>();
        orderPageInfo.setPageIndex(pageIndex);
        orderPageInfo.setPageSize(pageSize);
        int totalCount = selectMapper.countOrderByname(order_customerName);
        if (totalCount > 0){
            orderPageInfo.setTotalCount(totalCount);
            List<Order> orderList = selectMapper.findOrderByName((orderPageInfo.getPageIndex()-1) * orderPageInfo.getPageSize(),orderPageInfo.getPageSize(),order_customerName);
            orderPageInfo.setList(orderList);
        }
        return orderPageInfo;
    }

    @Override
    public PageInfo<Product> findProductByName(Integer pageIndex, Integer pageSize, String product_name) {
        PageInfo<Product> productPageInfo = new PageInfo<Product>();
        productPageInfo.setPageIndex(pageIndex);
        productPageInfo.setPageSize(pageSize);
        int totalCount = selectMapper.countProductByName(product_name);
        if (totalCount > 0 ){
            productPageInfo.setTotalCount(totalCount);
            List<Product> productList = selectMapper.findProductByName((productPageInfo.getPageIndex()-1) * productPageInfo.getPageSize(),productPageInfo.getPageSize(),product_name);
            productPageInfo.setList(productList);
        }
        return productPageInfo;
    }

    @Override
    public PageInfo<ProductPackage> findProductPackageByName(Integer pageIndex, Integer pageSize, String productPackage_name) {
        PageInfo<ProductPackage> productPackagePageInfo = new PageInfo<ProductPackage>();
        productPackagePageInfo.setPageIndex(pageIndex);
        productPackagePageInfo.setPageSize(pageSize);
        int totalCount = selectMapper.countProductPackageByName(productPackage_name);
        if (totalCount > 0 ){
            productPackagePageInfo.setTotalCount(totalCount);
            List<ProductPackage> productPackageList = selectMapper.findProductPackageByName((productPackagePageInfo.getPageIndex()-1) * productPackagePageInfo.getPageSize(),productPackagePageInfo.getPageSize(),productPackage_name);
            productPackagePageInfo.setList(productPackageList);
        }
        return productPackagePageInfo;
    }

    @Override
    public PageInfo<School> findSchoolByName(Integer pageIndex, Integer pageSize, String school_name) {
        PageInfo<School> schoolPageInfo = new PageInfo<School>();
        schoolPageInfo.setPageIndex(pageIndex);
        schoolPageInfo.setPageSize(pageSize);
        int totalCount = selectMapper.countSchoolByName(school_name);
        if (totalCount > 0 ){
            schoolPageInfo.setTotalCount(totalCount);
            List<School> schoolList = selectMapper.findSchoolByName((schoolPageInfo.getPageIndex()-1) * schoolPageInfo.getPageSize(),schoolPageInfo.getPageSize(),school_name);
            schoolPageInfo.setList(schoolList);
        }
        return schoolPageInfo;
    }

    @Override
    public PageInfo<EmailSend> findEmailSendByName(Integer pageIndex, Integer pageSize, String emailSend_from) {
        PageInfo<EmailSend> emailSendPageInfo = new PageInfo<EmailSend>();
        emailSendPageInfo.setPageIndex(pageIndex);
        emailSendPageInfo.setPageSize(pageSize);
        int totalCount = selectMapper.countEmailSendByName(emailSend_from);
        if (totalCount > 0 ){
            emailSendPageInfo.setTotalCount(totalCount);
            List<EmailSend> emailSendList = selectMapper.findEmailSendByName((emailSendPageInfo.getPageIndex()-1) * emailSendPageInfo.getPageSize(),emailSendPageInfo.getPageSize(),emailSend_from);
            emailSendPageInfo.setList(emailSendList);
        }
        return emailSendPageInfo;
    }
}
