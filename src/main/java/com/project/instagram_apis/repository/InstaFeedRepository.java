package com.project.instagram_apis.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.instagram_apis.model.InstaFeed;
import com.project.instagram_apis.model.Registration;

public interface InstaFeedRepository extends JpaRepository<InstaFeed,Integer>{
        @Query(value ="SELECT * FROM instagram.insta_feed where insta_feed.user_id= :userId", nativeQuery = true)
    public List<InstaFeed> fetchInstaFeedByUserId(@Param("userId") String userId);

}
