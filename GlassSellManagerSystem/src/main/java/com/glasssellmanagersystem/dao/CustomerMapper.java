package com.glasssellmanagersystem.dao;

import com.glasssellmanagersystem.pojo.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CustomerMapper {

    int addCustomer(Customer customer);

    List<Customer> getAllCustomersList(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    Integer totalCount();

    String getCustomerAge(Integer id);

    Customer findCustomerById(Integer id);

    int upCheckTime(String customer_lastDate,Integer customer_id);

    int completeCustomerInformation(Customer customer);

    int updateCustomerGlassAndFrame(Customer customer);

    int updateCustomerVipById(Integer customer_id);

    int updateCustomerCreateOrderDate(Customer customer);

    int updateCustomerGetGlassDate(Integer customer_id,String customer_getOrderDate);

    List<Customer> getAllVipCustomersList(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    Integer vipTotalCount();

    int completeInfo(Customer customer);

    int customerInfoEdit(Customer customer);

    int deleteCustomerById(Integer customer_id);
}
