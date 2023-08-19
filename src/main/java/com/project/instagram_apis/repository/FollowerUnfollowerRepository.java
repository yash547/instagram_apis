package com.project.instagram_apis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.instagram_apis.model.FollowerUnfollower;
import com.project.instagram_apis.model.Registration;

public interface FollowerUnfollowerRepository extends JpaRepository <FollowerUnfollower,Integer> {
    List<FollowerUnfollower> findByFollowerAndFollowed(Registration follower, Registration followed);
    
}
