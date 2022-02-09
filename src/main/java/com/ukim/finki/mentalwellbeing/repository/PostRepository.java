package com.ukim.finki.mentalwellbeing.repository;

import java.util.Optional;
import com.ukim.finki.mentalwellbeing.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    void deleteById(Long id);

    Optional<Post>findByUserName(String user);

    boolean existsById(Long id);
}
