package com.ukim.finki.mentalwellbeing.web.controller.SupportControllers;


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


@AllArgsConstructor
@Controller
@RequestMapping("/psychiatrist-profile")
public class PsychiatristsProfileController {

    private  final PsychiatristsService psychiatristsService;


    @GetMapping("/{id}")
    public String getPsychiatristsProfilePage(@PathVariable Long id, Model model) {
        if (this.psychiatristsService.findById(id).isPresent()) {
           Psychiatrists psychiatrists = this.psychiatristsService.findById(id).get();
            model.addAttribute("psychiatrists", psychiatrists);

            model.addAttribute("bodyContent", "psychiatristsProfile");


        }
        return "master-template";



    }




    @GetMapping("/edit/{id}")
    public String editPsyProfilePage (@PathVariable Long id, Model model){
        if (this.psychiatristsService.findById(id).isPresent()) {
            Psychiatrists psychiatrists = this.psychiatristsService.findById(id).get();
            model.addAttribute("psychiatrists", psychiatrists);
            model.addAttribute("bodyContent", "addEditPsychiatrists");
            return "master-template";
        }
        return "redirect/:suport?error=PsychiatristNotFound";
    }

    @PostMapping("/add/{id}")
    public String saveEditedP (

            @PathVariable Long id,
            HttpServletRequest request,
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String bio,
            @RequestParam String email,
            @RequestParam Integer experience,
            @RequestParam Integer price,
            @RequestParam("image") MultipartFile profilePicture) throws IOException {

        String user=request.getRemoteUser();

        if (!profilePicture.isEmpty()) {
            File picture_target = new File(profilePicture.getOriginalFilename());
            if (picture_target.exists()) {
                picture_target.delete();

            }

            profilePicture.transferTo(picture_target);
            this.psychiatristsService.edit(id, name,  surname,  email,  bio,  price, experience,  profilePicture, "../images/" + picture_target.getName());

            return "redirect:/psychiatrists-profile/{id}";


        }
        this.psychiatristsService.edit(id, name,  surname,  email,  bio,  price, experience,  profilePicture, "../images/");

        return "redirect:/psychiatrists-profile/{id}";


    }


}
