package com.glasssellmanagersystem.service;

public interface WelcomeService {

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
