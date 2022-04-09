package com.glasssellmanagersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Email {
    private int email_id;
    private int email_customerID;
    private String email_customerName;
    private int email_userId;
    private String email_userName;
    private String email_message;
    private String email_createDate;
}
