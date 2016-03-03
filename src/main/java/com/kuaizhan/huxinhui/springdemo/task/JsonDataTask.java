package com.kuaizhan.huxinhui.springdemo.task;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by xinhui on 16/3/3.
 */
public class JsonDataTask {

    //Json转换为Java对象
    public void JsonToBean(String json, Object o) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        o = objectMapper.readValue(json, Object.class);
        System.out.println(o);
    }

    //Java Bean转Json
    public void BeanToJson(Object o){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(o);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
