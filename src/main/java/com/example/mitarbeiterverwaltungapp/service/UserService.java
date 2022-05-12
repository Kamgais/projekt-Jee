package com.example.mitarbeiterverwaltungapp.service;



import com.example.mitarbeiterverwaltungapp.Entities.Mitarbeiter;
import com.example.mitarbeiterverwaltungapp.Entities.User;
import com.example.mitarbeiterverwaltungapp.repository.MitarbeiterRepository;
import com.example.mitarbeiterverwaltungapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor

public class UserService {

    private Long mId;
    private final UserRepository userRepository;
    private final MitarbeiterRepository mitarbeiterRepository;

    public boolean isAUser(User user) {

        List<Mitarbeiter> userList = new ArrayList<>();
        userList = (List<Mitarbeiter>) mitarbeiterRepository.findAll();


        for (Mitarbeiter element : userList
        ) {

            if (element.getNachname().equals(user.getUsername())) {

                mId = element.getId();
                System.out.println(element.getId());
                return true;
            }

            System.out.println(user.getUsername());
            System.out.println(user.getPassword());


        }


        return false;

    }


    public Long getMitarbeiter(User user) {
        List<Mitarbeiter> userList = new ArrayList<>();
        userList = (List<Mitarbeiter>) mitarbeiterRepository.findAll();


        for (Mitarbeiter element : userList
        ) {

            if (element.getNachname().equals(user.getUsername())) {

                mId = element.getId();


                return  mId;


            }


        }

        return -1L;

    }

}