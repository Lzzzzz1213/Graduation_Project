package com.glasssellmanagersystem.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeDiff {
    public int timeResult(String input) throws ParseException{
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        /*天数差*/
        Date now = new Date();
        Date fromDate1 = simpleFormat.parse(input);
        Date toDate1 = simpleFormat.parse(simpleFormat.format(now));
        long from1 = fromDate1.getTime();
        long to1 = toDate1.getTime();
        int days = (int) ((to1 - from1) / (1000 * 60 * 60 * 24));
        return days;
    }
}

