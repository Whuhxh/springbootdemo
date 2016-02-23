package com.kuaizhan.huxinhui.springdemo.repository;

import com.kuaizhan.huxinhui.springdemo.models.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by xinhui on 16/2/19.
 */
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>{
    List<CustomerEntity> findByLastName(String lastName);
}
