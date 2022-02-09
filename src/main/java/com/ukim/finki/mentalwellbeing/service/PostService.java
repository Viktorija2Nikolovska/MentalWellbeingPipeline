package com.ukim.finki.mentalwellbeing.service;

import com.ukim.finki.mentalwellbeing.model.Post;
import com.ukim.finki.mentalwellbeing.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;
import java.util.*;

public interface PostService {

    void deleteById(Long id);

    List<Post>searcPosts(String search);

    List<Post>listPosts();
    Optional<Post>save(String title, String description,  User userName, MultipartFile profilePicture, String imageSource);

    Optional<Post>edit(Long id,String title, String description, User userName, MultipartFile profilePicture, String imageSource);

        Optional<Post>findById(Long id);
    Optional<Post>getPost(String username);


}
