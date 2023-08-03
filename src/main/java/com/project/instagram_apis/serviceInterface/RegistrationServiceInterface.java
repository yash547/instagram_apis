package com.project.instagram_apis.serviceInterface;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.project.instagram_apis.model.Registration;

public interface RegistrationServiceInterface {
    
 public Object createUserAccount(Registration registration); // abstract method declare.

 public Object getLogin(String email_id,String password);

 public Object updateRegistrationData(Registration registration);

 public Object forgotPassword(Registration registration);

 String uploadProfilePic(MultipartFile file, int userId) throws IOException;

}
