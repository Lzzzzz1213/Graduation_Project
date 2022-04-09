package com.glasssellmanagersystem.controller;

import com.glasssellmanagersystem.pojo.EmailSend;
import com.glasssellmanagersystem.pojo.PageInfo;
import com.glasssellmanagersystem.service.EmailSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class EmailSendController {
    @Autowired
    EmailSendService emailSendService;
    @Autowired
    JavaMailSenderImpl javaMailSender;

    public void mailSender(Boolean html,String subject,String text,String to) throws MessagingException {
        final String from = "shilimei_glass@163.com";
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(text,html);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setFrom(from);
        javaMailSender.send(mimeMessage);
    }


    @RequestMapping("/user/email/openEmailSendPage")
    public String openEmailSendPage(){
        return "email-send";
    }

    @RequestMapping("/user/email/findEmailSend")
    public String findEmailSend(Model model, Integer pageIndex, Integer pageSize){
        PageInfo<EmailSend> emailSendPageInfo = emailSendService.getAllEmailSendList(pageIndex, pageSize);
        model.addAttribute("pages",emailSendPageInfo);
        return "email-list";
    }

    @RequestMapping("/user/email/deleteEmailSend")
    @ResponseBody
    public void deleteEmailSend(Integer emailSend_id){
        emailSendService.deleteEmailSend(emailSend_id);
    }

    @RequestMapping("/user/email/addEmailSend")
    @ResponseBody
    public void addEmailSend(EmailSend emailSend ,HttpServletResponse httpServletResponse) throws IOException {
        try {
            mailSender(true,emailSend.getEmailSend_subject(),emailSend.getEmailSend_text(),emailSend.getEmailSend_to());
            emailSendService.addEmailSend(emailSend);
        } catch (MessagingException e) {
            httpServletResponse.sendError(403);
            e.printStackTrace();
        }
    }
}
