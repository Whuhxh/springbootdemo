package com.kuaizhan.huxinhui.springdemo.web;

import java.util.concurrent.atomic.AtomicLong;

import com.kuaizhan.huxinhui.springdemo.models.Greeting;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xinhui on 16/1/30.
 */
@RestController
@RequestMapping(value = "/test/v1")
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public @ResponseBody Greeting greeting(@RequestParam(value="name", defaultValue="World", required = false) String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}
