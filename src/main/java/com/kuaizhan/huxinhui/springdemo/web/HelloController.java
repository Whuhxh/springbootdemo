package com.kuaizhan.huxinhui.springdemo.web;

import com.kuaizhan.huxinhui.springdemo.models.CustomerEntity;
import com.kuaizhan.huxinhui.springdemo.repository.CustomerRepository;
import com.kuaizhan.huxinhui.springdemo.request.CreateCustomerRequest;
import com.kuaizhan.huxinhui.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xinhui on 16/2/22.
 */
@RequestMapping(value = "test/v1")
@RestController
public class HelloController {

    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping("/hello")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String addCustomer(CreateCustomerRequest request){
        CustomerEntity customerEntity = null;
        try {
            customerEntity = new CustomerEntity();
            customerEntity.setFirstName(request.getFirstName());
            customerEntity.setLastName(request.getLastName());
            customerRepository.save(customerEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error creating the Customer:" + e.getMessage().toString();
        }
        return "Customer successfully created (id=" + customerEntity.getId() + ")";
    }
}
