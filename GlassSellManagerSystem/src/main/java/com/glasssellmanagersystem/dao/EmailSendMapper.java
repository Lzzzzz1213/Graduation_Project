package com.glasssellmanagersystem.dao;

import com.glasssellmanagersystem.pojo.EmailSend;
import com.glasssellmanagersystem.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface EmailSendMapper {

    int addEmailSend(EmailSend emailSend);

    List<EmailSend> getAllEmailSendList(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);
    int countEmailSend();

    int deleteEmailSend(Integer emailSend_id);
}
