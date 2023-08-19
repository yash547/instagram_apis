package com.project.instagram_apis.serviceInterface;

public interface FollowerUnfollowerServiceInterface {

    public boolean followRegistration(Integer followerId, Integer followedId);
    public boolean unfollowRegistration(Integer followerId, Integer followedId);    
}
