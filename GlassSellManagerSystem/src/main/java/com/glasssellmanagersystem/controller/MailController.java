package com.glasssellmanagersystem.controller;

import com.glasssellmanagersystem.pojo.Customer;
import com.glasssellmanagersystem.pojo.Email;
import com.glasssellmanagersystem.pojo.User;
import com.glasssellmanagersystem.service.CustomerService;
import com.glasssellmanagersystem.service.EmailService;
import com.glasssellmanagersystem.service.UserService;
import com.glasssellmanagersystem.utils.DateFormatUtil;
import com.glasssellmanagersystem.utils.TimeDiff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

@Controller
public class MailController {
    @Autowired
    JavaMailSenderImpl javaMailSender;
    @Autowired
    CustomerService customerService;
    @Autowired
    EmailService emailService;
    @Autowired
    UserService userService;

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
    @RequestMapping(value = "/user/customer/tipCustomerGetOrder",method = RequestMethod.POST)
    @ResponseBody
    public void tipCustomerGetOrder(Integer customer_id, HttpServletResponse httpServletResponse) throws MessagingException, ParseException {
        Customer customer = customerService.findCustomerById(customer_id);
        String subject = "尊敬的视力美客户"+customer.getCustomer_name()+"您好！";
        String text = "我是您的验光师"+customer.getCustomer_userName()+"，现在由我通知您，您定制的视力美眼镜已经到达我们的店铺，请您及时来领取。地址：都江堰XXXXXXXXXXX";
        String to = customer.getCustomer_email();
        DateFormatUtil getDate = new DateFormatUtil();
        String message = "tipCustomerGetOrder";
        Email email = emailService.findEmailMessageByCustomer(customer_id,message);
        if(email == null){
            Email email1 = new Email();
            email1.setEmail_message(message);
            email1.setEmail_customerID(customer_id);
            email1.setEmail_customerName(customer.getCustomer_name());
            email1.setEmail_userId(customer.getCustomer_userId());
            email1.setEmail_userName(customer.getCustomer_userName());
            email1.setEmail_createDate(getDate.exactTime());
            emailService.addEmailMessage(email1);
            mailSender(true,subject,text,to);
        }else {
            String time = email.getEmail_createDate();
            TimeDiff timeDiff = new TimeDiff();
            int day = timeDiff.timeResult(time);
            if (day <= 1){
                try {
                    httpServletResponse.sendError(403);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                email.setEmail_createDate(getDate.exactTime());
                emailService.updateEmailMessage(email);
                mailSender(true,subject,text,to);
            }
        }

    }
    @RequestMapping(value = "/user/customer/tipCustomerReview/",method = RequestMethod.POST)
    @ResponseBody
    public void tipCustomerReview(Integer customer_id, HttpServletResponse httpServletResponse) throws MessagingException, ParseException {
        Customer customer = customerService.findCustomerById(customer_id);
        String subject = "尊敬的视力美客户"+customer.getCustomer_name()+"您好！";
        String text = "我是您的验光师"+customer.getCustomer_userName()+"，现在由我通知您，您已经超过1个月没有来复查视力，为了您的视力健康，请您尽快到我店铺进行复查，地址：都江堰XXXXXXXXXXXXXXX";
        String to = customer.getCustomer_email();
        DateFormatUtil getDate = new DateFormatUtil();
        String message = "tipCustomerReview";
        Email email = emailService.findEmailMessageByCustomer(customer_id,message);
        if(email == null){
            Email email1 = new Email();
            email1.setEmail_message(message);
            email1.setEmail_customerID(customer_id);
            email1.setEmail_customerName(customer.getCustomer_name());
            email1.setEmail_userId(customer.getCustomer_userId());
            email1.setEmail_userName(customer.getCustomer_userName());
            email1.setEmail_createDate(getDate.exactTime());
            emailService.addEmailMessage(email1);
            mailSender(true,subject,text,to);
        }else {
            String time = email.getEmail_createDate();
            TimeDiff timeDiff = new TimeDiff();
            int day = timeDiff.timeResult(time);
            if (day <= 1){
                try {
                    httpServletResponse.sendError(403);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                email.setEmail_createDate(getDate.exactTime());
                emailService.updateEmailMessage(email);
                mailSender(true,subject,text,to);
            }
        }
    }
}
