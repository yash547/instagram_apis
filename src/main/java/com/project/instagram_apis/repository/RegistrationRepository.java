package com.project.instagram_apis.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.project.instagram_apis.model.Registration;

import jakarta.persistence.Tuple;

public interface RegistrationRepository extends JpaRepository<Registration, Integer> {

    /**
     * 
     * @param email_id
     * @param password
     * @return
     * 
     *   Abstract Method declare and it is connected with the SQL query.
     * and it will be called from the Service Layer packages 
     * of RegistrationServiceLayer.java file.
     * of getLogin Method inside it will be called.
     * 
     * 
     */
    @Query(value = "SELECT * FROM instagram.registration where registration.email_id= :email_id and registration.password= :password", nativeQuery = true)
    public Optional<Registration> fetchLogin(@Param("email_id") String email_id,@Param("password") String password);

   /**
 * @param userId
 * @return
 */
@Query(value ="SELECT registration.profile_pic FROM instagram.registration where registration.id= :userId", nativeQuery = true)
    public List<Tuple> fetchProfilePicByUserId(@Param("userId") int userId);
       
}
