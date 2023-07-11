package com.project.instagram_apis.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "Registration")  // --> Entity -->Annotation---> It is used to create table in database(mysql,oracle,etc)
public class Registration {

    @Id // Id----> Annotation --- >Pramary Key---> Value will be unique
    @Column(name = "ID")
     @GeneratedValue(strategy = GenerationType.SEQUENCE) // annotation---> Value 1,2,3,4,5,etc
    private int id; // --> Unique Data--> Integer ---> 1,2,3,4,5 etc
     @Column(name = "username")
    private String username;
      @Column(name = "email_id")
    private String email_id;
      @Column(name = "password")
    private String password;
      @Column(name = "full_name")
    private String full_name;
      @Column(name = "mobile_no")
    private String mobile_no;

    // default constructor

    public Registration() {
    }

    // parametrize constructor

    public Registration(int id, String username, String email_id, String password, String full_name, String mobile_no) {
        this.id = id;
        this.username = username;
        this.email_id = email_id;
        this.password = password;
        this.full_name = full_name;
        this.mobile_no = mobile_no;
    }

    // setter and getter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

}
