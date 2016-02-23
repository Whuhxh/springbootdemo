package com.kuaizhan.huxinhui.springdemo.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by xinhui on 16/2/23.
 */
@Data
public class DeleteCustomerRequest {

    @NotNull
    long id = 0;
}
