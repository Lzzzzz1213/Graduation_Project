package com.glasssellmanagersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private int order_id;
    private float order_amount; //总金额
    private float order_payAmount;//实际金额
    private String order_oderState;//订单状态
    private String order_paymentState;//支付状态
    private String order_logisticsState;//物流状态
    private String order_paymentWay;//支付方式
    private String order_logisticsName;//物流名称
    private String order_createDate;//订单生成时间
    private String order_productDescribe;//订单产品描述
    private String order_number;
    private String order_customerDegreeInfo;
    private String order_successDate;
    //登记人员
    private int order_userId;
    private String order_userName;
    //客户信息
    private int order_customerId;
    private String order_customerName;
    //登记表
    private int order_registerInfoId;

}
