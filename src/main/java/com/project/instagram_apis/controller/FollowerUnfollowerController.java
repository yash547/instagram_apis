package com.project.instagram_apis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.instagram_apis.serviceInterface.FollowerUnfollowerServiceInterface;

@RestController
@RequestMapping("/followerUnfollower")
public class FollowerUnfollowerController {

    @Autowired
    private FollowerUnfollowerServiceInterface followerUnfollowerServiceInterface;

    @PostMapping("/follow")
    public ResponseEntity<String> followRegistration(@RequestParam Integer followerId, @RequestParam Integer followedId){
        boolean success = followerUnfollowerServiceInterface.followRegistration(followerId, followedId);

        if(success){
            return ResponseEntity.ok("User followed successfully");
        }

            return ResponseEntity.badRequest().body("User is already followed");
    }

    @PostMapping("/unfollow")
    public ResponseEntity<String> unfollowerRegistration(@RequestParam Integer followerId, @RequestParam Integer followedId){
        boolean success = followerUnfollowerServiceInterface.unfollowRegistration(followerId, followedId);

        if(success){
            return ResponseEntity.ok("User unfollowed successfully");
        }

            return ResponseEntity.badRequest().body("User is not followed");
    }

    
}
