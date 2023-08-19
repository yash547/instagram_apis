package com.project.instagram_apis.model;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Data
@Entity(name = "folllowerUnfollower")
public class FollowerUnfollower {

    @Id
    @JoinColumn(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int Id;

    @JoinColumn(name = "UserId")
    private int UserId;

    @ManyToOne
    @JoinColumn(name = "followers")
    private Registration follower;

    @ManyToOne
    @JoinColumn(name = "followed")
    private Registration followed;

    
}
