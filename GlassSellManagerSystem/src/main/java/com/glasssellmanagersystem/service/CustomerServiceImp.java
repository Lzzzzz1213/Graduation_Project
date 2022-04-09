package com.glasssellmanagersystem.service;

import com.glasssellmanagersystem.dao.CustomerMapper;
import com.glasssellmanagersystem.pojo.Customer;
import com.glasssellmanagersystem.pojo.PageInfo;
import com.glasssellmanagersystem.utils.DateFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImp implements CustomerService{
    @Autowired
    CustomerMapper customerMapper;

    @Override
    public int addCustomer(Customer customer) {
        DateFormatUtil upTime =  new DateFormatUtil();
        customer.setCustomer_createDate(upTime.getDate());
        return customerMapper.addCustomer(customer);
    }

    @Override
    public PageInfo<Customer> findPageInfo(Integer pageIndex, Integer pageSize) {
        PageInfo<Customer> customerPageInfo = new PageInfo<Customer>();
        customerPageInfo.setPageIndex(pageIndex);
        customerPageInfo.setPageSize(pageSize);
        Integer totalCount = customerMapper.totalCount();
        if (totalCount > 0){
            customerPageInfo.setTotalCount(totalCount);
            List<Customer> customerList = customerMapper.getAllCustomersList((customerPageInfo.getPageIndex() - 1) * customerPageInfo.getPageSize(), customerPageInfo.getPageSize());
            customerPageInfo.setList(customerList);
        }
        return customerPageInfo;
    }

    @Override
    public String getCustomerAge(Integer id) {
        return customerMapper.getCustomerAge(id);
    }

    @Override
    public Customer findCustomerById(Integer id) {
        return customerMapper.findCustomerById(id);
    }

    @Override
    public int upCheckTime(String customer_lastDate,Integer customer_id) {
        return customerMapper.upCheckTime(customer_lastDate,customer_id);
    }

    @Override
    public int completeCustomerInformation(Customer customer) {
        return customerMapper.completeCustomerInformation(customer);
    }

    @Override
    public int updateCustomerGlassAndFrame(Customer customer) {
        return customerMapper.updateCustomerGlassAndFrame(customer);
    }

    @Override
    public int updateCustomerVipById(Integer customer_id) {
        return customerMapper.updateCustomerVipById(customer_id);
    }

    @Override
    public int updateCustomerCreateOrderDate(Customer customer) {
        return customerMapper.updateCustomerCreateOrderDate(customer);
    }

    @Override
    public int updateCustomerGetGlassDate(Integer customer_id, String customer_getOrderDate) {
        return customerMapper.updateCustomerGetGlassDate(customer_id, customer_getOrderDate);
    }

    @Override
    public PageInfo<Customer> findVipPageInfo(Integer pageIndex, Integer pageSize) {
        PageInfo<Customer> customerPageInfo = new PageInfo<Customer>();
        customerPageInfo.setPageIndex(pageIndex);
        customerPageInfo.setPageSize(pageSize);
        Integer vipTotalCount = customerMapper.vipTotalCount();
        if (vipTotalCount > 0){
            customerPageInfo.setTotalCount(vipTotalCount);
            List<Customer> customerList = customerMapper.getAllVipCustomersList((customerPageInfo.getPageIndex() - 1) * customerPageInfo.getPageSize(), customerPageInfo.getPageSize());
            customerPageInfo.setList(customerList);
        }

        return customerPageInfo;
    }

    @Override
    public int completeInfo(Customer customer) {
        return customerMapper.completeInfo(customer);
    }

    @Override
    public int customerInfoEdit(Customer customer) {
        return customerMapper.customerInfoEdit(customer);
    }

    @Override
    public int deleteCustomerById(Integer customer_id) {
        return customerMapper.deleteCustomerById(customer_id);
    }


}
