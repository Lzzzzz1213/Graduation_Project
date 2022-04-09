package com.glasssellmanagersystem.service;

import com.glasssellmanagersystem.pojo.*;

public interface SelectService {

    PageInfo<User> findUserByName(Integer pageIndex, Integer pageSize, String name);

    PageInfo<Customer> findCustomerByName(Integer pageIndex, Integer pageSize, String customer_name);

    PageInfo<Customer> findVipCustomerByName(Integer pageIndex, Integer pageSize, String customer_name);

    PageInfo<Order> findOrderByName(Integer pageIndex, Integer pageSize, String order_customerName);

    PageInfo<Product> findProductByName(Integer pageIndex, Integer pageSize, String product_name);

    PageInfo<ProductPackage> findProductPackageByName(Integer pageIndex, Integer pageSize, String productPackage_name);

    PageInfo<School> findSchoolByName(Integer pageIndex, Integer pageSize, String school_name);

    PageInfo<EmailSend> findEmailSendByName(Integer pageIndex, Integer pageSize, String emailSend_from);
}
