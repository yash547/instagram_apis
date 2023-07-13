package com.project.instagram_apis.serviceLayer;

import java.util.List;
import java.util.Optional;

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

    /**
     * it is for to fetch the insta feed which were posted by the insta user.
     */
    @Override
    public Object getFeed() {
        /**
         * .findAll()
         * it is used to fetch the entire data from the database
         * of their respective tables.
         * and the alternative of this below method(.finalAll()) in SQL
         * is---> SELECT * FROM instagram.insta_feed;
         */

        return instaFeedRepository.findAll();
    }

    @Override
    public Object updateFeed(InstaFeed instaFeed) {

        Optional<InstaFeed> optionalInsta = instaFeedRepository.findById(instaFeed.getId());

        if (!optionalInsta.isPresent()) {
            return "no record found";
        }

        InstaFeed p = optionalInsta.get();

        return p;

    }

}
