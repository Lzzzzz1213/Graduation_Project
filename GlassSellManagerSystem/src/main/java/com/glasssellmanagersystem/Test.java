package com.glasssellmanagersystem;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.glasssellmanagersystem.pojo.SystemInfo;
import com.glasssellmanagersystem.utils.SystemInfoUtils;

import java.net.UnknownHostException;

public class Test {
    public static void main(String[] args) throws UnknownHostException {
//        MD5Util md5Util = new MD5Util();
//        String password;
//        password = "admin";
//        String MD5Pssword = md5Util.MD5EncodeUtf8(password);
//        System.out.println(MD5Pssword);
//        SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date time = new Date();
//        System.out.println(sFormat.format(time));
//        DateFormatUtil dateFormatUtil = new DateFormatUtil();
//        System.out.println(dateFormatUtil.getDate());
//        TimeDiff timeDiff = new TimeDiff();
//        try {
//            System.out.println(timeDiff.timeResult("2018-03-01 12:00:00"));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        DateFormatUtil dateFormatUtil = new DateFormatUtil();
//        System.out.println(dateFormatUtil.exactTime());
        SystemInfoUtils systemInfoUtils = new SystemInfoUtils();
        SystemInfo systemInfo = JSONObject.toJavaObject(systemInfoUtils.getInfo(),SystemInfo.class);
        System.out.println(systemInfo.toString());
//        System.out.println(systemInfoUtils.getInfo());
//        System.out.println(systemInfoUtils.getJvmInfo());
    }
}
