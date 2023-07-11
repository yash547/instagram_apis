package com.project.instagram_apis.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data // by default constructor ,parametrize constructor,setter ,getter.
@Entity(name = "InstaFeed")
public class InstaFeed {

    @Id // Id----> Annotation --- >Pramary Key---> Value will be unique
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // annotation---> Value 1,2,3,4,5,etc
    private int id;
    @Column(name = "userId")
    private String userId;
    @Column(name = "description")
    private String description;
    @Column(name = "imageUrl")
    private String imageUrl;
    @Column(name = "location")
    private String location;

}
