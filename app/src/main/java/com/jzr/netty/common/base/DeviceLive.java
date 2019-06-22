package com.jzr.netty.common.base;


import java.io.Serializable;
import java.util.Date;


public class DeviceLive implements Serializable {
    private static final long serialVersionUID = 1L;
    private String deviceIp;
    private String deviceNo;
    private Integer deviceType;
    private String nurseboardIp;
    private String appVersion;
    private String deviceMac;
    private String registerBed;
    private Date lastUpTime;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getDeviceIp() {
        return deviceIp;
    }

    public void setDeviceIp(String deviceIp) {
        this.deviceIp = deviceIp;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public String getNurseboardIp() {
        return nurseboardIp;
    }

    public void setNurseboardIp(String nurseboardIp) {
        this.nurseboardIp = nurseboardIp;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getDeviceMac() {
        return deviceMac;
    }

    public void setDeviceMac(String deviceMac) {
        this.deviceMac = deviceMac;
    }

    public String getRegisterBed() {
        return registerBed;
    }

    public void setRegisterBed(String registerBed) {
        this.registerBed = registerBed;
    }

    public Date getLastUpTime() {
        return lastUpTime;
    }

    public void setLastUpTime(Date lastUpTime) {
        this.lastUpTime = lastUpTime;
    }
}
