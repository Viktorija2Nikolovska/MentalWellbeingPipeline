package com.ukim.finki.mentalwellbeing.web.controller.PostControllers;

import com.ukim.finki.mentalwellbeing.model.Post;
import com.ukim.finki.mentalwellbeing.model.Psychiatrists;
import com.ukim.finki.mentalwellbeing.model.User;
import com.ukim.finki.mentalwellbeing.repository.PostRepository;
import com.ukim.finki.mentalwellbeing.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/connect")
public class PostListController {

    public static final String targetFolderImagePPPath = "C:\\Users\\PC\\Desktop\\MentallWellbeingApp\\mentalwellbeing\\src\\main\\resources\\static\\images";

    private final PostService postService;



    @GetMapping
    public String getPostPage(Model model){
        List<Post> posts=this.postService.listPosts();
        model.addAttribute("posts",posts);
        model.addAttribute("bodyContent","PostList");
        return "master-template";
    }

    @DeleteMapping("/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        Post post=this.postService.findById(id).get();

        this.postService.deleteById(id);

        return "redirect:/connect";
    }

    @GetMapping("/add-post")
    public String addPsychiatristsPage(Model model) {

        model.addAttribute("bodyContent", "addPost");
        return "master-template";
    }


    @PostMapping("/add")
    public String saveP(
            HttpServletRequest request,
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam User user,

            @RequestParam("image") MultipartFile profilePicture) throws IOException {
        String username=request.getRemoteUser();


        if (!profilePicture.isEmpty()) {
            File picture_target = new File(profilePicture.getOriginalFilename());

            if (picture_target.exists()) {
                picture_target.delete();

            }
            profilePicture.transferTo(picture_target);
            this.postService.save( title,description,user,  profilePicture, "../images/" + picture_target.getName());


        }

        else {
            this.postService.save( title,description,user,  profilePicture, "../images/");


        }
        return "redirect:/connect";

    }
}
