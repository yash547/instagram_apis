package com.project.instagram_apis.serviceLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.instagram_apis.model.Registration;
import com.project.instagram_apis.repository.RegistrationRepository;
import com.project.instagram_apis.serviceInterface.RegistrationServiceInterface;

@Service
public class RegistrationServiceLayer implements RegistrationServiceInterface {

    @Autowired
private RegistrationRepository registrationRepository; //  here the object will be created.
    /**
     * Method defined
     */
    @Override
    public Object createUserAccount(Registration registration) {
       
        return registrationRepository.save(registration); // .save() is used to store the data into the database.
    }

    /**
     * 
     * The Below method defined for the login api
     */
    @Override
    public Object getLogin(String email_id, String password) {

        
        /**
         * The fetchlogin method is called from the RegistrationRepository interface from the Repository packages
         * with the help of interface object using @Autowired annotation. 
         *
         */
        return this.registrationRepository.fetchLogin(email_id, password);
    }
    
}
