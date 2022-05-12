package com.example.mitarbeiterverwaltungapp.controller;


import com.example.mitarbeiterverwaltungapp.Entities.Mitarbeiter;
import com.example.mitarbeiterverwaltungapp.Entities.User;
import com.example.mitarbeiterverwaltungapp.repository.MitarbeiterRepository;
import com.example.mitarbeiterverwaltungapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class UserController {


    private final UserService userService;
    private final MitarbeiterRepository mitarbeiterRepository;

    @GetMapping("/loginpage")

    public String loginPage(Model model){

       User user = new User();
       model.addAttribute("user",user);
        return "loginPage";
    }




    @PostMapping("/result")

    public String submitForm(@ModelAttribute("user") User user,Model erepas){

             if(userService.getMitarbeiter(user) != null) {
                Optional <Mitarbeiter> mitarbeiter = mitarbeiterRepository.findById(userService.getMitarbeiter(user));
                 erepas.addAttribute("mitarbeiter", mitarbeiter);
             }
        if(!userService.isAUser(user)) {

            return "fehler";
        }
        else
        {

            return "sucess";
        }

    }






}
