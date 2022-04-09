package com.glasssellmanagersystem.service;

import com.glasssellmanagersystem.dao.WelcomeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WelcomeServiceImp implements WelcomeService{
    @Autowired
    WelcomeMapper welcomeMapper;

    @Override
    public int countCustomer() {
        return welcomeMapper.countCustomer();
    }

    @Override
    public int countVipCustomer() {
        return welcomeMapper.countVipCustomer();
    }

    @Override
    public int countOrder() {
        return welcomeMapper.countOrder();
    }

    @Override
    public int countProduct() {
        return welcomeMapper.countProduct();
    }

    @Override
    public int countProductPackage() {
        return welcomeMapper.countProductPackage();
    }

    @Override
    public int countSchool() {
        return welcomeMapper.countSchool();
    }

    @Override
    public int lastDayOrder() {
        return welcomeMapper.lastDayOrder();
    }

    @Override
    public int lastDayCustomer() {
        return welcomeMapper.lastDayOrder();
    }

    @Override
    public int nowDayOrder() {
        return welcomeMapper.nowDayOrder();
    }

    @Override
    public int nowDayCustomer() {
        return welcomeMapper.nowDayCustomer();
    }
}
