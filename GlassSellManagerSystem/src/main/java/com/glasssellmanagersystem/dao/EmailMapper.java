package com.glasssellmanagersystem.dao;

import com.glasssellmanagersystem.pojo.Email;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface EmailMapper {

    int addEmailMessage(Email email);

    Email findEmailMessageByCustomer(Integer email_customerId,String email_message);

    int updateEmailMessage(Email email);
}
