package com.glasssellmanagersystem.service;

import com.glasssellmanagersystem.pojo.Customer;
import com.glasssellmanagersystem.pojo.PageInfo;

public interface CustomerService {

    int addCustomer(Customer customer);

    PageInfo<Customer> findPageInfo(Integer pageIndex, Integer pageSize);

    String getCustomerAge(Integer id);

    Customer findCustomerById(Integer id);

    int upCheckTime(String customer_lastDate,Integer customer_id);

    int completeCustomerInformation(Customer customer);

    int updateCustomerGlassAndFrame(Customer customer);

    int updateCustomerVipById(Integer customer_id);

    int updateCustomerCreateOrderDate(Customer customer);

    int updateCustomerGetGlassDate(Integer customer_id,String customer_getOrderDate);

    PageInfo<Customer> findVipPageInfo(Integer pageIndex, Integer pageSize);

    int completeInfo(Customer customer);

    int customerInfoEdit(Customer customer);

    int deleteCustomerById(Integer customer_id);

}
