
package com.ukim.finki.mentalwellbeing.repository;


import com.ukim.finki.mentalwellbeing.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    Optional<User>findByUsernameAndPassword(String username,String password);

    Optional<User>findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
