package com.ukim.finki.mentalwellbeing.repository;


import com.ukim.finki.mentalwellbeing.model.Psychiatrists;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PsychiatristRepository extends JpaRepository<Psychiatrists,Long> {

    void deleteById(Long id);

    Psychiatrists findByName(String name);


}
