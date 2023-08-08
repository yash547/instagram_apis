package com.project.instagram_apis.serviceInterface;

import com.project.instagram_apis.model.InstaReel;

public interface InstaReelServiceInerface  {
    public Object createReel(InstaReel instaReel);

    public Object getReel(InstaReel instareel);

    public Object UpdateReel(InstaReel instaReel);

    public Object getReels(InstaReel instaReel);

}
