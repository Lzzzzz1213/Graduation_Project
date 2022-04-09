package com.glasssellmanagersystem.service;

import com.glasssellmanagersystem.dao.RegisterInfoMapper;
import com.glasssellmanagersystem.pojo.Customer;
import com.glasssellmanagersystem.pojo.PageInfo;
import com.glasssellmanagersystem.pojo.RegisterInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RegisterInfoServiceImp implements RegisterInfoService{
    @Autowired
    RegisterInfoMapper registerInfoMapper;

    @Override
    public int addRegisterInfo(RegisterInfo registerInfo) {
        return registerInfoMapper.addRegisterInfo(registerInfo);
    }

    @Override
    public PageInfo<RegisterInfo> getAllRegisterForCustomerByCustomerId(Integer pageIndex, Integer pageSize, Integer registerInfo_customerId) {
        PageInfo<RegisterInfo> registerInfoPageInfo = new PageInfo<RegisterInfo>();
        registerInfoPageInfo.setPageIndex(pageIndex);
        registerInfoPageInfo.setPageSize(pageSize);
        Integer totalCount = registerInfoMapper.regeisterForCustomerTotalCount(registerInfo_customerId);
        if (totalCount > 0){
            registerInfoPageInfo.setTotalCount(totalCount);
            List<RegisterInfo> customerList = registerInfoMapper.getAllRegisterForCustomerByCustomerId((registerInfoPageInfo.getPageIndex() - 1) * registerInfoPageInfo.getPageSize(), registerInfoPageInfo.getPageSize(),registerInfo_customerId);
            registerInfoPageInfo.setList(customerList);
        }
        return registerInfoPageInfo;
    }

    @Override
    public RegisterInfo getRegisterInfoById(Integer registerInfo_id) {
        return registerInfoMapper.getRegisterInfoById(registerInfo_id);
    }

    @Override
    public int updateRegisterSupport(Integer registerInfo_id, String registerInfo_support) {
        return registerInfoMapper.updateRegisterSupport(registerInfo_id, registerInfo_support);
    }

    @Override
    public int deleteRegisterByCustomerId(Integer registerInfo_customerId) {
        return registerInfoMapper.deleteRegisterByCustomerId(registerInfo_customerId);
    }
}
