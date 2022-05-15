package com.example.mitarbeiterverwaltungapp.controller;


import com.example.mitarbeiterverwaltungapp.Entities.Mitarbeiter;
import com.example.mitarbeiterverwaltungapp.Entities.User;

import com.example.mitarbeiterverwaltungapp.service.UserService;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@AllArgsConstructor

public class UserController {


    private final UserService userService ;




    @GetMapping("/loginpage")

    public String loginPage(Model model){

       User user = new User();
       model.addAttribute("user",user);
        return "loginPage";
    }




    @PostMapping("/result")

    public String submitForm(@ModelAttribute("user") User user, Model model){

         String message = userService.isAUser(user);

        if(message.equals("mitarbeiteR")) {

            Mitarbeiter mitarbeiter = userService.getMitarbeiter(user);

            model.addAttribute("mitarbeiter",mitarbeiter);

            return "sucess";
        }
        else if(message.equals("personalw")){

            Mitarbeiter mitarbeiter = new Mitarbeiter();

            model.addAttribute("mitarbeiter",mitarbeiter);

            return "personal";
        }

         else {
             return "fehler";

        }
        }


       @PostMapping("/result2")

    public String saveWorker(@ModelAttribute("mitarbeiter") Mitarbeiter mitarbeiter){

      /*  userService.saveMitarbeiter(mitarbeiter);*/


        return "personal";
        }



    }







