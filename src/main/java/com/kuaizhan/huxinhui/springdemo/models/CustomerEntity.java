package com.kuaizhan.huxinhui.springdemo.models;

import javax.persistence.*;

/**
 * Created by xinhui on 16/2/17.
 */
@Entity
@Table(name = "customer", schema = "xinhui_schema")
public class CustomerEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Basic
    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;

    @Basic
    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;

    public CustomerEntity() {}

    public long getId(){
        return id;
    }

    public CustomerEntity(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public CustomerEntity(long id, String firstName, String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString(){
        return String.format(
                "CustomerEntity{id=%d, firstName='%s', lastName='%s'}", id, firstName, lastName);
    }
}
