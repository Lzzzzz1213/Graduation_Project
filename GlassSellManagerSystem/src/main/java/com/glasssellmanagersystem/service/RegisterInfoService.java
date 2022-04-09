package com.glasssellmanagersystem.service;

import com.glasssellmanagersystem.pojo.PageInfo;
import com.glasssellmanagersystem.pojo.RegisterInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RegisterInfoService {

    int addRegisterInfo(RegisterInfo registerInfo);

    PageInfo<RegisterInfo> getAllRegisterForCustomerByCustomerId(Integer pageIndex, Integer pageSize, Integer registerInfo_customerId);

    RegisterInfo getRegisterInfoById(Integer registerInfo_id);

    int updateRegisterSupport(Integer registerInfo_id,String registerInfo_support);

    int deleteRegisterByCustomerId(Integer registerInfo_customerId);
}
