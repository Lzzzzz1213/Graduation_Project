package com.glasssellmanagersystem.dao;


import com.glasssellmanagersystem.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SelectMapper {

    List<User> findUserByName(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize, @Param("name") String name);
    int countUserByName(String name);

    List<Customer> findCustomerByName(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize, @Param("customer_name") String customer_name);
    int countCustomerByName(String customer_name);

    List<Customer> findVipCustomerByName(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize, @Param("customer_name") String customer_name);
    int countVipCustomerByName(String customer_name);

    List<Order> findOrderByName(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize, @Param("order_customerName") String order_customerName);
    int countOrderByname(String order_customerName);

    List<Product> findProductByName(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize, @Param("product_name") String product_name);
    int countProductByName(String product_name);

    List<ProductPackage> findProductPackageByName(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize, @Param("productPackage_name") String productPackage_name);
    int countProductPackageByName(String productPackage_name);

    List<School> findSchoolByName(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize, @Param("school_name") String school_name);
    int countSchoolByName(String school_name);

    List<EmailSend> findEmailSendByName(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize, @Param("emailSend_from") String emailSend_from);
    int countEmailSendByName(String emailSend_name);
}
