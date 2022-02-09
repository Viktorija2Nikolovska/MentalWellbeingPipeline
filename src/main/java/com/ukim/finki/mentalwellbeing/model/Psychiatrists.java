package com.ukim.finki.mentalwellbeing.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Psychiatrists {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String email;
    private String bio;
    private Integer price;
    private Integer experience;
    private String imageSource;

    @OneToMany(mappedBy = "psychiatristsId")
    private List<Dates> avaliableDates;

    public Psychiatrists() {
    }

    public Psychiatrists(String name, String surname, String email, String bio, Integer price, Integer experience, String imageSource) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.bio = bio;
        this.price = price;
        this.experience = experience;
        this.imageSource = imageSource;
      
    }
}
