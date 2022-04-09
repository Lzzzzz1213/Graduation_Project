package com.glasssellmanagersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterInfo {
    private int registerInfo_id;
    //客户名称
    private int registerInfo_customerId;
    private String registerInfo_customerName;
    //登记人员
    private int registerInfo_userId;
    private String registerInfo_userName;
    private String registerInfo_createDate;
    //视力
    private String registerInfo_visionRight;//右眼视力
    private String registerInfo_visionLeft;//左眼视力
    private String registerInfo_history;//配镜史
    private String registerInfo_support;//镜架
    private String registerInfo_PDRight;//右眼瞳距
    private String registerInfo_PDLeft;//左眼瞳距
    //远
    private String registerInfo_loinMiroirDeBouleRight;//右眼球镜
    private String registerInfo_loinMiroirDeColonneRight;//右眼柱镜
    private String registerInfo_loinAxeRight;//右眼轴度
    private String registerInfo_loinCorrectionRight;//右眼矫正视力
    private String registerInfo_loinMiroirDeBouleLeft;//左眼球镜
    private String registerInfo_loinMiroirDeColonneLeft;//左眼柱镜
    private String registerInfo_loinAxeLeft;//左眼轴度
    private String registerInfo_loinCorrectionLeft;//左眼矫正视力
    //近
    private String registerInfo_procheMiroirDeBouleRight;//右眼球镜
    private String registerInfo_procheMiroirDeColonneRight;//右眼柱镜
    private String registerInfo_procheAxeRight;//右眼轴度
    private String registerInfo_procheCorrectionRight;//右眼矫正视力
    private String registerInfo_procheMiroirDeBouleLeft;//左眼球镜
    private String registerInfo_procheMiroirDeColonneLeft;//左眼柱镜
    private String registerInfo_procheAxeLeft;//左眼轴度
    private String registerInfo_procheCorrectionLeft;//左眼矫正视力
}
