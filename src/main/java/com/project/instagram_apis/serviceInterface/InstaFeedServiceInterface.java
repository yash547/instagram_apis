package com.project.instagram_apis.serviceInterface;

import com.project.instagram_apis.model.InstaFeed;

public interface InstaFeedServiceInterface {
    
   public Object createFeed(InstaFeed instaFeed);

   public Object getFeed(); // it is for to fetch the insta feed which were posted by the insta user.

}
