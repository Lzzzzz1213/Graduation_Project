package com.glasssellmanagersystem.service;

import com.glasssellmanagersystem.dao.EmailMapper;
import com.glasssellmanagersystem.pojo.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmailServiceImp implements EmailService{
    @Autowired
    EmailMapper emailMapper;

    @Override
    public int addEmailMessage(Email email) {
        return emailMapper.addEmailMessage(email);
    }

    @Override
    public Email findEmailMessageByCustomer(Integer email_customerId,String email_message) {
        return emailMapper.findEmailMessageByCustomer(email_customerId, email_message);
    }

    @Override
    public int updateEmailMessage(Email email) {
        return emailMapper.updateEmailMessage(email);
    }
}
