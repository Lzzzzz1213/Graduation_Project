package com.glasssellmanagersystem.service;

import com.glasssellmanagersystem.dao.OrderMapper;
import com.glasssellmanagersystem.pojo.Order;
import com.glasssellmanagersystem.pojo.PageInfo;
import com.glasssellmanagersystem.utils.DateFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImp implements OrderService{
    @Autowired
    OrderMapper orderMapper;


    @Override
    public int createOrder(Order order) {
        DateFormatUtil getDate = new DateFormatUtil();
        order.setOrder_oderState("未编辑");
        order.setOrder_createDate(getDate.getDate());
        return orderMapper.createOrder(order);
    }

    @Override
    public int findOrderByRegisterInfoId(Integer order_registerInfoId) {
        return orderMapper.findOrderByRegisterInfoId(order_registerInfoId);
    }

    @Override
    public PageInfo<Order> findPageInfo(Integer pageIndex, Integer pageSize) {
        PageInfo<Order> orderPageInfo = new PageInfo<Order>();
        orderPageInfo.setPageIndex(pageIndex);
        orderPageInfo.setPageSize(pageSize);
        Integer totalCount = orderMapper.totalCount();
        if (totalCount > 0){
            orderPageInfo.setTotalCount(totalCount);
            List<Order> orderList = orderMapper.getAllOrdersList((orderPageInfo.getPageIndex() - 1) * orderPageInfo.getPageSize(), orderPageInfo.getPageSize());
            orderPageInfo.setList(orderList);
        }
        return orderPageInfo;
    }

    @Override
    public int updateOrder(Order order) {
        long  timeNew =  System.currentTimeMillis()/1000;
        String order_number = String.valueOf(timeNew)+String.valueOf(order.getOrder_id());
        order.setOrder_number(order_number);
        order.setOrder_oderState("已编辑");
        order.setOrder_paymentState("未支付");
        order.setOrder_logisticsState("未发货");
        order.setOrder_logisticsName("暂无物流信息");
        return orderMapper.updateOrder(order);
    }

    @Override
    public int updatePaymentStateById(Integer order_id,String order_paymentState) {
        return orderMapper.updatePaymentStateById(order_id,order_paymentState);
    }

    @Override
    public int updateOrderLogisticsById(Integer order_id, String order_logisticsName,String order_logisticsState) {
        return orderMapper.updateOrderLogisticsById(order_id,order_logisticsName,order_logisticsState);
    }

    @Override
    public int updateOrderStateById(Integer order_id, String order_oderState) {
        return orderMapper.updateOrderStateById(order_id,order_oderState);
    }

    @Override
    public Order findOrderById(Integer order_id) {
        return orderMapper.findOrderById(order_id);
    }

    @Override
    public int deleteOrderById(Integer order_id) {
        return orderMapper.deleteOrderById(order_id);
    }

    @Override
    public int updateOrderSuccessDate(Integer order_id, String order_successDate) {
        return orderMapper.updateOrderSuccessDate(order_id,order_successDate);
    }

    @Override
    public int deleteOrderByCustomerId(Integer order_customerId) {
        return orderMapper.deleteOrderByCustomerId(order_customerId);
    }

}
