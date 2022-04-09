package com.glasssellmanagersystem.service;

import com.glasssellmanagersystem.pojo.Email;

public interface EmailService {

    int addEmailMessage(Email email);

    Email findEmailMessageByCustomer(Integer email_customerId,String email_message);

    int updateEmailMessage(Email email);
}
