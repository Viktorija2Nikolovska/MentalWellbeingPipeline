package com.ukim.finki.mentalwellbeing.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String imageSource;




    @ManyToOne
    private User userName;

    public Post() {
    }

    public Post(String title, String description,  User userName ,String imageSource) {
        this.title = title;
        this.description = description;


        this.userName = userName;
        this.imageSource = imageSource;
    }
}
