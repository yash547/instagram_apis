package com.project.instagram_apis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.instagram_apis.model.InstaReel;
import com.project.instagram_apis.serviceInterface.InstaReelServiceInerface;

@RestController
public class InstaReelCntroller {

   @Autowired 
   private InstaReelServiceInerface instaReelServiceInerface;

   @PostMapping("/CreatReel")
   public Object creatReel(@RequestBody InstaReel instareel) {

    return this.instaReelServiceInerface.createReel(instareel);
   }
    
   @GetMapping("/getInstaReel")
   public Object getReel() {
    
    return this.instaReelServiceInerface.getReel(null);
    
   }

   @PutMapping("/updateReel")
   public Object updateReel(@RequestBody InstaReel instaReel) {

    return instaReelServiceInerface.UpdateReel(instaReel);
   }
}
