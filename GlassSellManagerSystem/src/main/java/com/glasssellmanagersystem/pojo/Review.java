package com.glasssellmanagersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    //客户名称
    private int review_customerId;
    private String review_customerName;
    //登记人员
    private int review_userId;
    private String review_userName;
    //复查信息
    private int review_id;
    private String review_createDate;
    private String review_UCVARight;//裸眼视力
    private String review_UCVALeft;
    private String review_CVARight;//矫正视力
    private String review_CVALeft;
    private String review_Right;//右眼参数
    private String review_Left;//左眼参数
    private String review_positionOfEye;//眼位
    private String review_ACA;//AC/A
    private String review_suggest;//建议


}
