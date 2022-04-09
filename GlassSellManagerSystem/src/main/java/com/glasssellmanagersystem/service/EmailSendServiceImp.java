package com.glasssellmanagersystem.service;

import com.glasssellmanagersystem.dao.EmailSendMapper;
import com.glasssellmanagersystem.pojo.EmailSend;
import com.glasssellmanagersystem.pojo.PageInfo;
import com.glasssellmanagersystem.utils.DateFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmailSendServiceImp implements EmailSendService{
    @Autowired
    EmailSendMapper emailSendMapper;
    @Override
    public int addEmailSend(EmailSend emailSend) {
        DateFormatUtil getDate = new DateFormatUtil();
        emailSend.setEmailSend_createDate(getDate.getDate());
        return emailSendMapper.addEmailSend(emailSend);
    }

    @Override
    public PageInfo<EmailSend> getAllEmailSendList(Integer pageIndex, Integer pageSize) {
        PageInfo<EmailSend> emailSendPageInfo = new PageInfo<EmailSend>();
        emailSendPageInfo.setPageIndex(pageIndex);
        emailSendPageInfo.setPageSize(pageSize);
        int count = emailSendMapper.countEmailSend();
        if (count >0){
            emailSendPageInfo.setTotalCount(count);
            List<EmailSend> emailSendList = emailSendMapper.getAllEmailSendList((emailSendPageInfo.getPageIndex() - 1) * emailSendPageInfo.getPageSize(), emailSendPageInfo.getPageSize());
            emailSendPageInfo.setList(emailSendList);
        }
        return emailSendPageInfo;
    }

    @Override
    public int deleteEmailSend(Integer emailSend_id) {
        return emailSendMapper.deleteEmailSend(emailSend_id);
    }
}
