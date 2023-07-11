package com.project.instagram_apis.serviceLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.instagram_apis.model.InstaFeed;
import com.project.instagram_apis.repository.InstaFeedRepository;
import com.project.instagram_apis.serviceInterface.InstaFeedServiceInterface;

@Service
public class InstaFeedServiceLayer implements InstaFeedServiceInterface {

    @Autowired
    private InstaFeedRepository instaFeedRepository;
    
    @Override
    public Object createFeed(InstaFeed instaFeed) {
       
        return instaFeedRepository.save(instaFeed); // it is used to store the post into the InstaFeed table.
    }
    
}
