package com.kuaizhan.huxinhui.springdemo;


import com.kuaizhan.huxinhui.springdemo.models.DeviceData;
import com.kuaizhan.huxinhui.springdemo.models.DeviceJsonData;
import com.kuaizhan.huxinhui.springdemo.models.Quote;
import com.kuaizhan.huxinhui.springdemo.task.JsonDataTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

/**
 * Created by xinhui on 16/1/30.
 */
@SpringBootApplication
@EnableScheduling
@Slf4j
public class springDemoApplication implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(springDemoApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        log.info("quote ==========>" + quote.toString());

        JsonDataTask jsonDataTask = new JsonDataTask();
        DeviceJsonData deviceJsonData = new DeviceJsonData();
        String json = "{\"pfurl\":\"http://pic.kuaizhan.com/g2/M01/73/38/CgpQVFbXoXWASuk6AAAMZWmql-4426.p12\",\"data\":[" +
                "{\"pushid\":\"3503\",\"device\":\"75f8af9e6ff88181c24f83036fd35ce5f48c7f49d7cc538c61c95a14bb90657b\",\"content\":\"zhe ci lai shi shi|http://danaodong.t1.com/11/97/p1234258476e1fa\"}," +
                "{\"pushid\":\"3503\",\"device\":\"8e1da5718626e29d930eb1a78a48aaca9e5e4de4e1c17f61882113d7a951d979\",\"content\":\"zhe ci lai shi shi|http://danaodong.t1.com/11/97/p1234258476e1fa\"}]}";
        jsonDataTask.JsonToBean(json, deviceJsonData);
        System.out.println("deviceJsonData ======>" + deviceJsonData);

        DeviceData deviceData = new DeviceData();
    }
}
