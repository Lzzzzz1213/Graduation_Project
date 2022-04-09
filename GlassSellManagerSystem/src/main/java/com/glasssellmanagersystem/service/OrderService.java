package com.glasssellmanagersystem.service;

import com.glasssellmanagersystem.pojo.Customer;
import com.glasssellmanagersystem.pojo.Order;
import com.glasssellmanagersystem.pojo.PageInfo;

public interface OrderService {

    int createOrder(Order order);

    int findOrderByRegisterInfoId(Integer order_registerInfoId);

    PageInfo<Order> findPageInfo(Integer pageIndex, Integer pageSize);

    int updateOrder(Order order);

    int updatePaymentStateById(Integer order_id,String order_paymentState);

    int updateOrderLogisticsById(Integer order_id,String order_logisticsName,String order_logisticsState);

    int updateOrderStateById(Integer order_id,String order_oderState);

    Order findOrderById(Integer order_id);

    int deleteOrderById(Integer order_id);

    int updateOrderSuccessDate(Integer order_id,String order_successDate);

    int deleteOrderByCustomerId(Integer customer_id);

}
