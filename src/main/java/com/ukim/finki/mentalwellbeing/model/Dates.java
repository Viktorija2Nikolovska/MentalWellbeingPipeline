package com.ukim.finki.mentalwellbeing.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
public class Dates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

 
    private LocalDate date;


   
    private LocalTime localTime;

    @ManyToOne
    private Psychiatrists psychiatristsId;

}
