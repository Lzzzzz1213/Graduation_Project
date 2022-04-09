package com.glasssellmanagersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailSend {
    private int emailSend_id;
    private String emailSend_to;
    private String emailSend_from;
    private String emailSend_subject;
    private String emailSend_text;
    private String emailSend_createDate;
}
