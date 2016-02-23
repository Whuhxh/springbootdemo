package com.kuaizhan.huxinhui.springdemo.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by xinhui on 16/2/23.
 */
@Data
public class CreateCustomerRequest {

    @Length(max = 45)
    @NotEmpty
    String firstName;

    @NotEmpty
    @Length(max = 45)
    String lastName;
}
