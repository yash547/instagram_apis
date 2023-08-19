package com.project.instagram_apis.serviceLayer;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.instagram_apis.model.FollowerUnfollower;
import com.project.instagram_apis.model.Registration;
import com.project.instagram_apis.repository.FollowerUnfollowerRepository;
import com.project.instagram_apis.repository.RegistrationRepository;
import com.project.instagram_apis.serviceInterface.FollowerUnfollowerServiceInterface;

@Service
public class FollowerUnfollowerServiceLayer implements FollowerUnfollowerServiceInterface {

    private final RegistrationRepository registrationRepository;
    private final FollowerUnfollowerRepository followerUnfollowerRepository;

    @Autowired
    public FollowerUnfollowerServiceLayer(RegistrationRepository registrationRepository, FollowerUnfollowerRepository followerUnfollowerRepository){
        this.registrationRepository = registrationRepository;
        this.followerUnfollowerRepository = followerUnfollowerRepository;
    }

    @Override
    public boolean followRegistration(Integer followerId, Integer followedId) {
        
        //Find the follower and the followed user
        Registration follower = registrationRepository.findById(followerId)
            .orElseThrow(() -> new RuntimeException("Follower not  found"));

        Registration followed = registrationRepository.findById(followedId)
            .orElseThrow(() -> new RuntimeException("Followed user not found"));    
        
            //Check if the follower is already following the follower the followed user
            if(followerUnfollowerRepository.findByFollowerAndFollowed(follower, followed).isEmpty()){

                //create a new FollowerUnfollower relationaship
                FollowerUnfollower followerUnfollower = new FollowerUnfollower();
                followerUnfollower.setFollower(follower);
                followerUnfollower.setFollowed(followed);
                followerUnfollowerRepository.save(followerUnfollower);
                return true;        //Successfully followed
            }

            return false;  //Already following
    }

    @Override
    public boolean unfollowRegistration(Integer followerId, Integer followedId) {
        
        Registration follower = registrationRepository.findById(followerId)
            .orElseThrow(() -> new RuntimeException("Follower not  found"));

        Registration followed = registrationRepository.findById(followedId)
            .orElseThrow(() -> new RuntimeException("Followed user not found"));

        List<FollowerUnfollower> followerUnfollowers = followerUnfollowerRepository.findByFollowerAndFollowed(follower, followed);
        if(!followerUnfollowers.isEmpty()){
            followerUnfollowerRepository.deleteAll(followerUnfollowers);
            return true;        
        }

        return false;
    }
    
}
