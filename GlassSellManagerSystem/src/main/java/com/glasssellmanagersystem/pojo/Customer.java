package com.glasssellmanagersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    //个人基本信息
    private int customer_id;
    private String customer_name;
    private char customer_sex;
    private String customer_birthday;
    private String customer_schoolName;
    private String customer_address;
    private String customer_qqNumber;
    private String customer_phoneNumber;
    private String customer_email;
    private String customer_parentMomPhoneNumber;
    private String customer_parentDadPhoneNumber;
    private String customer_height;
    private String customer_weight;
    //建议方案与其他备注
    private String customer_physicalTherapyAdvice;
    private String customer_remarks;

    //后续完善信息
    private String customer_history;//戴镜史
    private String customer_PDRight;//右眼瞳距
    private String customer_PDLeft;//左眼瞳距
    private String customer_glassesDegree;//眼镜度数
    private String customer_createOrderDate;//配镜日期
    private String customer_getOrderDate;//取镜日期
    private String customer_glassesType;//镜片型号
    private String customer_framesType;//镜架型号

    //创建日期
    private String customer_createDate;
    private String customer_lastDate;
    //登记人
    private int customer_userId;
    private String customer_userName;
    //生成订单后成为vip
    private String customer_vip;
    private String customer_visionRight;
    private String customer_visionLeft;
}
