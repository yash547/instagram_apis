package com.project.instagram_apis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.instagram_apis.model.Registration;
import com.project.instagram_apis.serviceInterface.RegistrationServiceInterface;

@RestController
public class RegistrationController {
    
    @Autowired
    private RegistrationServiceInterface registrationServiceInterface;  // object created of what interface.

    @PostMapping("/createInstaAccount")
 public Object createUserAccount(@RequestBody  Registration registration)
 {
    return this.registrationServiceInterface.createUserAccount(registration);
 }


 @GetMapping("/Login")
 public Object getLoginDetails(@RequestParam String email_id,@RequestParam String password)
 {
   return this.registrationServiceInterface.getLogin(email_id, password);
 }
 /**
  *   Create a put  api to update the emaild ,full name , mobileno 
  by id 
  *
  */

}
