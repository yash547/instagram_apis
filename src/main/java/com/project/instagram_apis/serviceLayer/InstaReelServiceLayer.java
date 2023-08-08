package com.project.instagram_apis.serviceLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.instagram_apis.model.InstaReel;
import com.project.instagram_apis.repository.InstaReelRepository;
import com.project.instagram_apis.serviceInterface.InstaReelServiceInerface;


@Service
public class InstaReelServiceLayer implements InstaReelServiceInerface {

    @Autowired
    private InstaReelRepository instaReelRepository;

    @Override
    public Object createReel(InstaReel instaReel) {
        
        return this.instaReelRepository.save(instaReel);
    }
    @Override
    public Object getReel(InstaReel instaReel) {

        return instaReelRepository.findAll();
    }

    @Override
    public Object UpdateReel(InstaReel instaReel) {
        
        return this.instaReelRepository.save(instaReel);
    }

    
    @Override
    public Object getReels(InstaReel instareel) {
        // TODO Auto-generated method stub
        
        
        return this.instaReelRepository.fetchInstaReelByUserId(instareel.getUserId());
    }

    

}