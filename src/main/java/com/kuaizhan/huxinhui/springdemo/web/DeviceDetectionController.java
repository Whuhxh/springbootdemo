package com.kuaizhan.huxinhui.springdemo.web;

import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xinhui on 16/2/2.
 */
@Controller
@RequestMapping(value =  "/test/v1")
public class DeviceDetectionController {

    @RequestMapping(value = "/device-detect")
    public @ResponseBody String deviceDetect(Device device){
        String deviceType = "unknow";
        if (device.isMobile()){
            deviceType = "moblie";
        }
        if (device.isNormal()){
            deviceType = "normal";
        }
        if (device.isTablet()){
            deviceType = "tablet";
        }
        return "the device tpye is " + deviceType;
    }
}
