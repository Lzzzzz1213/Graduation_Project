package com.glasssellmanagersystem.dao;

import com.glasssellmanagersystem.pojo.RegisterInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RegisterInfoMapper {

    int addRegisterInfo(RegisterInfo registerInfo);

    Integer regeisterForCustomerTotalCount(Integer registerInfo_customerId);

    List<RegisterInfo> getAllRegisterForCustomerByCustomerId(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize,
                                                             @Param("registerInfo_customerId") Integer registerInfo_customerId);
    RegisterInfo getRegisterInfoById(Integer registerInfo_id);

    int updateRegisterSupport(Integer registerInfo_id,String registerInfo_support);

    int deleteRegisterByCustomerId(Integer registerInfo_customerId);
}
