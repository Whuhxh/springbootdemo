package com.kuaizhan.huxinhui.springdemo.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * Created by xinhui on 16/2/23.
 */
@Data
public class CreateCustomerRequest {

    @Length(max = 45)
    @NotNull
    String firstName = "";

    @NotNull
    @Length(max = 45)
    String lastName = "";
}
