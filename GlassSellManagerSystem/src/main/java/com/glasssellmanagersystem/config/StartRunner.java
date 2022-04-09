package com.glasssellmanagersystem.config;

import com.alibaba.fastjson.JSONObject;
import com.glasssellmanagersystem.pojo.SystemInfo;
import com.glasssellmanagersystem.utils.SystemInfoUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 1)
public class StartRunner implements CommandLineRunner {
    SystemInfo systemInfo = null;
    @Override
    public void run(String... args) throws Exception {
        SystemInfoUtils systemInfoUtils = new SystemInfoUtils();
        systemInfo = JSONObject.toJavaObject(systemInfoUtils.getInfo(),SystemInfo.class);
    }

    public SystemInfo getSystemInfo() {
        return systemInfo;
    }

    public void setSystemInfo(SystemInfo systemInfo) {
        this.systemInfo = systemInfo;
    }
}
