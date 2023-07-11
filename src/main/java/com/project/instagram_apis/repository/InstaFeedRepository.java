package com.project.instagram_apis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.instagram_apis.model.InstaFeed;

public interface InstaFeedRepository extends JpaRepository<InstaFeed,Integer>{
    
}
