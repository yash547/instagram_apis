package com.project.instagram_apis.serviceLayer;

import java.util.Optional;

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

    /**
     * This method body is for changing or updation of email id, mobile no, full name
     * 
     */

    @Override
    public Object updateRegistrationData(Registration registration) {
      
        Optional<Registration> optionalReg = registrationRepository.findById(registration.getId());

        if(!optionalReg.isPresent())
        {
            return "No record found";
        }

        Registration p = optionalReg.get();

        p.setEmail_id(registration.getEmail_id());
        p.setFull_name(registration.getFull_name());
        p.setMobile_no(registration.getMobile_no());

        return registrationRepository.save(p);
    }

    /**
     * This method body is for forgot password
     * 
     */
    @Override
    public Object forgotPassword(Registration registration) {
        Optional<Registration> forgotPass = registrationRepository.findById(registration.getId());

        if(!forgotPass.isPresent())
        {
            return "No record found";
        }

        Registration f = forgotPass.get();

        f.setPassword(registration.getPassword());

        return registrationRepository.save(f);
    }

    @Override
    public Object uploadProfilePic(Registration registration) {
        
        return registrationRepository.save(registration);
    }
    
}
