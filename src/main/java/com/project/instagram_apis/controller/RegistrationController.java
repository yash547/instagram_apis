package com.project.instagram_apis.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
  @PutMapping("/updateRegistrationData")
  public Object updateRegistrationData(@RequestBody Registration registration)
  {
    return registrationServiceInterface.updateRegistrationData(registration);
  }

  @PatchMapping("/forgotPassword")
  public Object forgotPassword(@RequestBody Registration registration)
  {
    return registrationServiceInterface.forgotPassword(registration);
  }

  @PostMapping("/uploadProfilePic")
  public String uploadProfilePic(@RequestParam("file") MultipartFile file, @RequestParam("userId") int userId) throws IOException
  {
    return registrationServiceInterface.uploadProfilePic(file, userId);
  }

  @GetMapping("/getProfilePicbyUserId")
  public Object getProfilePicbyUserId(@RequestParam("id") String id)
  {
    return this.registrationServiceInterface.getProfilePicbyUserId(Integer.parseInt(id));
  }

}
