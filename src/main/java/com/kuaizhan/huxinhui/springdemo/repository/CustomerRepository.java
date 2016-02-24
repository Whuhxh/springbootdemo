package com.kuaizhan.huxinhui.springdemo.repository;

import com.kuaizhan.huxinhui.springdemo.models.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xinhui on 16/2/19.
 */
@Transactional
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>{
    List<CustomerEntity> findByLastName(String lastName);

    CustomerEntity findById(Long id);

    CustomerEntity findByFirstNameAndLastName(String firstName, String lastName);

    @Modifying
    @Query("update CustomerEntity c set c.firstName=:firstName, c.lastName=:lastName where c.id=:id")
    void modifyFirstNameAndLastNameById(@Param(value = "id") long id,
                                        @Param(value = "firstName") String firstName,
                                        @Param(value = "lastName") String lastName);
}
