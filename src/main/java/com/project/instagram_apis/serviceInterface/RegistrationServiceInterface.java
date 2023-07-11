package com.project.instagram_apis.serviceInterface;

import com.project.instagram_apis.model.Registration;

public interface RegistrationServiceInterface {
    
 public Object createUserAccount(Registration registration); // abstract method declare.

 public Object getLogin(String email_id,String password);

}
