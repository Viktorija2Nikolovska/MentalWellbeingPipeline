package com.ukim.finki.mentalwellbeing.service;

import com.ukim.finki.mentalwellbeing.model.Dates;
import com.ukim.finki.mentalwellbeing.model.Psychiatrists;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PsychiatristsService {

    Optional<Psychiatrists> findById(Long id);


    Optional<Psychiatrists>save(String name, String surname, String email, String bio, Integer price, Integer experience, MultipartFile profilePicture, String imageSource );


    Optional<Psychiatrists>edit(Long id,String name, String surname, String email, String bio, Integer price, Integer experience, MultipartFile profilePicture, String imageSource);

        List<Psychiatrists> listAll();

    void  deleteById(Long id);


}
