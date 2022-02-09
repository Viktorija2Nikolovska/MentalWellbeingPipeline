package com.ukim.finki.mentalwellbeing.service.implementation;


import com.ukim.finki.mentalwellbeing.model.Post;
import com.ukim.finki.mentalwellbeing.model.User;
import com.ukim.finki.mentalwellbeing.service.PostService;
import com.ukim.finki.mentalwellbeing.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Post> searcPosts(String search) {
        return null;
    }

    @Override
    public List<Post> listPosts() {

        return this.postRepository.findAll();
    }

    @Override
    public Optional<Post> save(String title, String description, User userName, MultipartFile profilePicture, String imageSource) {
        return Optional.of(this.postRepository.save(new Post(title,description,userName,imageSource)));
    }

    @Override
    public Optional<Post> edit(Long id, String title, String description, User userName, MultipartFile profilePicture, String imageSource) {
       Post post=this.postRepository.findById(id).orElseThrow(()->new IllegalArgumentException());

       post.setTitle(title);
       post.setDescription(description);
       post.setUserName(userName);

        if (!profilePicture.isEmpty()) post.setImageSource(imageSource);

        return Optional.of(this.postRepository.save(post));
    }

    @Override
    public Optional<Post> findById(Long id) {
        return this.findById(id);
    }

    @Override
    public Optional<Post> getPost(String username) {
        return Optional.empty();

    }
}




