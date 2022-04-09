package com.glasssellmanagersystem.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
public class DateFormatUtil {
    private String date;
    private final String dataFormat = "yyyy-MM-dd";
    private final String exactFormat = "yyyy-MM-dd hh:mm:ss";
    private String exactDate;
    public DateFormatUtil(){
        Date time = new Date();
        this.date = (String) (new SimpleDateFormat(dataFormat)).format(time);
    }
    public String  exactTime(){
        Date date = new Date();
        this.exactDate = (new SimpleDateFormat(exactFormat)).format(date);
        return exactDate;
    }
}
