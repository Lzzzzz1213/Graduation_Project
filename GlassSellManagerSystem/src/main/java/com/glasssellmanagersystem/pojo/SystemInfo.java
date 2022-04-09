package com.glasssellmanagersystem.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class SystemInfo {
    private MemInfoBean memInfo;
    private SysInfoBean sysInfo;
    private List<SysFileInfoBean> sysFileInfo;
    private JvmInfoBean jvmInfo;
    private CpuInfoBean cpuInfo;

    @NoArgsConstructor
    @Data
    public static class MemInfoBean {
        private String total;
        private String usageRate;
        private String used;
        private String free;
    }

    @NoArgsConstructor
    @Data
    public static class SysInfoBean {
        private String computerIp;
        private String computerName;
        private String osArch;
        private String userDir;
        private String osName;
    }

    @NoArgsConstructor
    @Data
    public static class JvmInfoBean {
        private String total;
        private String usageRate;
        private String max;
        private String jdkVersion;
        private String free;
        private String user;
        private String jdkHome;
    }

    @NoArgsConstructor
    @Data
    public static class CpuInfoBean {
        private String cSys;
        private String idle;
        private String iowait;
        private String user;
        private int cpuNum;
    }

    @NoArgsConstructor
    @Data
    public static class SysFileInfoBean {
        private String total;
        private String usage;
        private String typeName;
        private String sysTypeName;
        private String used;
        private String free;
        private String dirName;
    }

}
