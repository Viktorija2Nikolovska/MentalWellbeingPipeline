package com.ukim.finki.mentalwellbeing.web.controller.SupportControllers;

import com.ukim.finki.mentalwellbeing.model.Dates;
import com.ukim.finki.mentalwellbeing.model.Psychiatrists;
import com.ukim.finki.mentalwellbeing.service.PsychiatristsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;


@Controller
@AllArgsConstructor
@RequestMapping("/support")
public class PsychiatristsController {

    public static final String targetFolderImagePPPath = "C:\\Users\\PC\\Desktop\\MentallWellbeingApp\\mentalwellbeing\\src\\main\\resources\\static\\images";


    private final PsychiatristsService psychiatristsService;

    @GetMapping
    public String getPsychiatristsPage(Model model){
        List<Psychiatrists> psychiatristsList=this.psychiatristsService.listAll();
        model.addAttribute("psychiatrists",psychiatristsList);
        model.addAttribute("bodyContent","psychiatrists");
        return "master-template";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteP(@PathVariable Long id) {
       Psychiatrists psychiatrists=this.psychiatristsService.findById(id).get();

        this.psychiatristsService.deleteById(id);

        return "redirect:/support";
    }

    @GetMapping("/add-psychiatrists")
    public String addPsychiatristsPage(Model model) {

        model.addAttribute("bodyContent", "addPsychiatrists");
        return "master-template";
    }


    @PostMapping("/add")
    public String saveP(
            HttpServletRequest request,
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String bio,
            @RequestParam String email,
            @RequestParam Integer experience,
            @RequestParam Integer price,
            @RequestParam("image") MultipartFile profilePicture) throws IOException {
        String username=request.getRemoteUser();


        if (!profilePicture.isEmpty()) {
            File picture_target = new File(profilePicture.getOriginalFilename());

            if (picture_target.exists()) {
                picture_target.delete();

            }
            profilePicture.transferTo(picture_target);
            this.psychiatristsService.save( name,  surname,  email,  bio,  price, experience,  profilePicture, "../images/" + picture_target.getName());


        }

        else {
            this.psychiatristsService.save( name,  surname,  email,  bio,  price, experience,  profilePicture, "../images/");


        }
        return "redirect:/support";

    }





}
