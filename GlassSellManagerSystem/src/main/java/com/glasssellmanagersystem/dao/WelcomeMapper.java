package com.glasssellmanagersystem.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface WelcomeMapper {

    int countCustomer();

    int countVipCustomer();

    int countOrder();

    int countProduct();

    int countProductPackage();

    int countSchool();

    int lastDayOrder();

    int lastDayCustomer();

    int nowDayOrder();

    int nowDayCustomer();


}
