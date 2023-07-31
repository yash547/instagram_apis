package com.project.instagram_apis.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.instagram_apis.model.InstaFeed;
import com.project.instagram_apis.serviceInterface.InstaFeedServiceInterface;

@RestController
public class InstaFeedController {
/**
 * Zishan
 */
    @Autowired
    private InstaFeedServiceInterface instaFeedServiceInterface;

    @PostMapping("/CreateFeed")
    public Object createFeed(@RequestBody InstaFeed instaFeed) {

        return instaFeedServiceInterface.createFeed(instaFeed);
    }

    @GetMapping("/getInstaFeed")
    public Object getFeed() {

        return instaFeedServiceInterface.getFeed();
    }
    
    /**
     * PutMapping 
     *     When we update more one column of same row into the database
     * then we use putMapping.
     * @param instaFeed
     * @return
     */
    @PutMapping("/updateFeed")
    public Object updateFeed(@RequestBody InstaFeed instaFeed)
    {
        return instaFeedServiceInterface.updateFeed(instaFeed);
    }

    
    @GetMapping("/getFeedByUserId")
    public Object getFeedByUserId(@RequestBody InstaFeed instaFeed) {

        return this.instaFeedServiceInterface.getFeedByUserId(instaFeed);

    }



}
