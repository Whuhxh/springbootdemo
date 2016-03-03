package com.kuaizhan.huxinhui.springdemo.models;

/**
 * Created by xinhui on 16/3/3.
 */
public class DeviceData {
    private String pushid;
    private String device;
    private String content;

    public DeviceData() {
    }

    public DeviceData(String pushid, String device, String content) {
        this.pushid = pushid;
        this.device = device;
        this.content = content;
    }

    public String getPushid() {
        return pushid;
    }

    public void setPushid(String pushid) {
        this.pushid = pushid;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "DeviceData{" +
                "pushid='" + pushid + '\'' +
                ", device='" + device + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
