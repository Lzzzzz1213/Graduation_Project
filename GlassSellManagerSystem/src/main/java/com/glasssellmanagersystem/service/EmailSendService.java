package com.glasssellmanagersystem.service;

import com.glasssellmanagersystem.pojo.EmailSend;
import com.glasssellmanagersystem.pojo.PageInfo;
import org.apache.ibatis.annotations.Param;

public interface EmailSendService {

    int addEmailSend(EmailSend emailSend);

    PageInfo<EmailSend> getAllEmailSendList(Integer pageIndex,Integer pageSize);

    int deleteEmailSend(Integer emailSend_id);
}
