package com.project.instagram_apis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.instagram_apis.model.InstaFeed;
import com.project.instagram_apis.serviceInterface.InstaFeedServiceInterface;

@RestController
public class InstaFeedController {

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


}
