package com.kuaizhan.huxinhui.springdemo.models;

/**
 * Created by xinhui on 16/1/30.
 */
public class Greeting {
    private long id;
    private String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Greeting(String content){
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
