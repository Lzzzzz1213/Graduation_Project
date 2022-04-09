package com.glasssellmanagersystem.dao;

import com.glasssellmanagersystem.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderMapper {

    int createOrder(Order order);

    int findOrderByRegisterInfoId(Integer order_registerInfoId);

    List<Order> getAllOrdersList(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    Integer totalCount();

    int updateOrder(Order order);

    int updatePaymentStateById(Integer order_id,String order_paymentState);

    int updateOrderLogisticsById(Integer order_id,String order_logisticsName,String order_logisticsState);

    int updateOrderStateById(Integer order_id,String order_oderState);

    Order findOrderById(Integer order_id);

    int deleteOrderById(Integer order_id);

    int updateOrderSuccessDate(Integer order_id,String order_successDate);

    int deleteOrderByCustomerId(Integer order_customerId);
}
