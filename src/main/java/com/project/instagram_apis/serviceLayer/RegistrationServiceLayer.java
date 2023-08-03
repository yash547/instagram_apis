package com.project.instagram_apis.serviceLayer;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import javax.imageio.IIOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.instagram_apis.model.Registration;
import com.project.instagram_apis.repository.RegistrationRepository;
import com.project.instagram_apis.serviceInterface.RegistrationServiceInterface;

@Service
public class RegistrationServiceLayer implements RegistrationServiceInterface {

    @Autowired
private RegistrationRepository registrationRepository; //  here the object will be created.
    private String uploadPath;
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
    public String uploadProfilePic(MultipartFile file, int userId) throws IOException {
        try{
            //Save the profile picture to the server
            String uploadPath = "d://ProfilePic";
            String fileName = System.currentTimeMillis()+"_"+file.getOriginalFilename();
            
            File dest = new File(uploadPath + File.separator + fileName);
            file.transferTo(dest);
            
            //Generate Image URL
            String imageUrl = "http://your_server_url/uploads/" + fileName;

            //Update the registration table with the image URL for the respective user 
            Optional<Registration> reg = registrationRepository.findById(userId);
            Registration registration = reg.get();

            if (reg.isPresent())
            {
                registration.setprofile_pic(imageUrl);
                registrationRepository.save(registration);
                return imageUrl;
            }
            else
            {
                throw new IllegalArgumentException("User not found with Id: " + userId);
            }
        }

        catch(IOException e){
            throw new IOException("Failed to upload the Profile Picture.", e);

        }
        
    }

    
}
