package com.ukim.finki.mentalwellbeing.service.implementation;


import com.ukim.finki.mentalwellbeing.model.Dates;
import com.ukim.finki.mentalwellbeing.model.Psychiatrists;
import com.ukim.finki.mentalwellbeing.repository.PsychiatristRepository;
import com.ukim.finki.mentalwellbeing.service.PsychiatristsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ukim.finki.mentalwellbeing.model.exceptions.PsychiatristsNotFoundException;


import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PsychiatristsServiceImpl  implements PsychiatristsService {
    
    private final PsychiatristRepository psychiatristRepository;

    @Override
    public Optional<Psychiatrists> findById(Long id) {

        return this.psychiatristRepository.findById(id);
    }

    @Override
    public Optional<Psychiatrists> save(String name, String surname, String email, String bio, Integer price, Integer experience, MultipartFile profilePicture, String imageSource) {
        return Optional.of(this.psychiatristRepository.save(new Psychiatrists(name,surname,email,bio,price,experience,imageSource)));
    }

    @Override
    public Optional<Psychiatrists> edit(Long id, String name, String surname, String email, String bio, Integer price, Integer experience, MultipartFile profilePicture, String imageSource) {
       Psychiatrists psychiatrists=this.psychiatristRepository.findById(id).orElseThrow(()-> new PsychiatristsNotFoundException(id));

        psychiatrists.setName(name);
        psychiatrists.setSurname(surname);
        psychiatrists.setEmail(email);
        psychiatrists.setBio(bio);
        psychiatrists.setExperience(experience);

        psychiatrists.setPrice(price);
        if (!profilePicture.isEmpty()) psychiatrists.setImageSource(imageSource);


        return Optional.of(this.psychiatristRepository.save(psychiatrists));
    }

    @Override
    public List<Psychiatrists> listAll() {
        return this.psychiatristRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        
        this.psychiatristRepository.deleteById(id);

    }
}
