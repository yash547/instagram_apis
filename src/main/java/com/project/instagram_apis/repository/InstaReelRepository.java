package com.project.instagram_apis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.instagram_apis.model.InstaReel;


public interface InstaReelRepository extends JpaRepository<InstaReel,Integer>{
    
   @Query(value ="SELECT * FROM instagram.insta_Reel where insta_Reel.user_id= :userId", nativeQuery = true)
    public List<InstaReel> fetchInstaReelByUserId(@Param("userId") String userId); 
}
