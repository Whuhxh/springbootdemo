package com.kuaizhan.huxinhui.springdemo.models;

import java.util.List;

/**
 * Created by xinhui on 16/3/3.
 */
public class DeviceJsonData {
    private String pfurl;
    private List<DeviceData> data;

    public DeviceJsonData() {
    }

    public DeviceJsonData(String pfurl, List<DeviceData> data) {
        this.pfurl = pfurl;
        this.data = data;
    }

    public String getPfurl() {
        return pfurl;
    }

    public void setPfurl(String pfurl) {
        this.pfurl = pfurl;
    }

    public List<DeviceData> getData() {
        return data;
    }

    public void setData(List<DeviceData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DeviceJsonData{" +
                "pfurl='" + pfurl + '\'' +
                ", data=" + data +
                '}';
    }
}
