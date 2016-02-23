package com.kuaizhan.huxinhui.springdemo.web;

import com.kuaizhan.huxinhui.springdemo.models.CustomerEntity;
import com.kuaizhan.huxinhui.springdemo.repository.CustomerRepository;
import com.kuaizhan.huxinhui.springdemo.request.CreateCustomerRequest;
import com.kuaizhan.huxinhui.springdemo.request.DeleteCustomerRequest;
import com.kuaizhan.huxinhui.springdemo.request.UpdateCustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/create", method = {RequestMethod.POST, RequestMethod.PUT})
    public String addCustomer(@RequestBody CreateCustomerRequest request){
        CustomerEntity customerEntity;
        try {
            customerEntity = customerRepository.findByFirstNameAndLastName(request.getFirstName(), request.getLastName());
            if (customerEntity == null) {
                customerEntity = new CustomerEntity();
                customerEntity.setFirstName(request.getFirstName());
                customerEntity.setLastName(request.getLastName());
                customerRepository.save(customerEntity);
            } else {
                return "Customer is already exist.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error creating the Customer:" + e.getMessage().toString();
        }
        return "Customer successfully created (id=" + customerEntity.getId() + ")";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String delCustomer(@RequestBody DeleteCustomerRequest request){
        CustomerEntity customerEntity;
        try {
            long id = request.getId();
            customerEntity = customerRepository.findById(id);
            System.out.println(customerEntity);
            if (customerEntity != null) {
                customerRepository.delete(customerEntity);
            } else {
                return "invalidate id, delete failed !";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error deleting the Customer by id :" + request.getId();
        }
        return "Deleting Customer successfully (id=" + request.getId() + ")";
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    private String updateCustomer(@RequestBody UpdateCustomerRequest request){
        CustomerEntity customerEntity;
        try {
            long id = request.getId();
            customerEntity = customerRepository.findById(id);
            System.out.println(customerEntity);
            if (customerEntity != null) {
                customerEntity.setLastName(request.getLastName());
                customerEntity.setFirstName(request.getFirstName());
                System.out.println(customerEntity);
                customerRepository.modifyFirstNameAndLastNameById(id);
            } else {
                return "Update failed!";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error updating";
        }
        return "Updating Customer successfully (id" + request.getId() + ")";
    }
}
