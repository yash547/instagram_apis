package com.project.instagram_apis.serviceInterface;

import java.util.List;
import java.util.Optional;

import com.project.instagram_apis.model.InstaFeed;

public interface InstaFeedServiceInterface {
    
   public Object createFeed(InstaFeed instaFeed);

   public Object getFeed(); // it is for to fetch the insta feed which were posted by the insta user.

   /**
    * It is used to update the insta feed.
    * @param instaFeed
    * @return
    */
   public Object updateFeed(InstaFeed instaFeed);

   public Object getFeedByUserId(InstaFeed instaFeed);

   public Object getReelByUserId(InstaFeed instaFeed);

}
