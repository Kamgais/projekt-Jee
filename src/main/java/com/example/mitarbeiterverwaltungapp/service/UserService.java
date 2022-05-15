package com.example.mitarbeiterverwaltungapp.service;
import com.example.mitarbeiterverwaltungapp.Entities.Mitarbeiter;
import com.example.mitarbeiterverwaltungapp.Entities.User;
import com.example.mitarbeiterverwaltungapp.repository.MitarbeiterRepository;
import com.example.mitarbeiterverwaltungapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class UserService {


    private final UserRepository userRepository;
    private final MitarbeiterRepository mitarbeiterRepository;

    public String isAUser(User user) {

        List<User> userList = new ArrayList<>();
        userList = (List<User>) userRepository.findAll();


        if(user.getUsername().equals("HugoBak") && user.getPassword().equals("5000"))
        {
            return "personalw";
        }


        for (User element : userList
        ) {
            if (element.getUsername().equals(user.getUsername()) && element.getPassword().equals(user.getPassword())) {
                return "mitarbeiteR";
            }


        }

        return "fail";

    }


    public Mitarbeiter getMitarbeiter(User user) {

        List<User> userList = new ArrayList<>();
        userList = (List<User>) userRepository.findAll();


        for (User element : userList
        ) {
            if (element.getUsername().equals(user.getUsername()) && element.getPassword().equals(user.getPassword())) {


              /*   List<Mitarbeiter> mitarbeiterList = (List<Mitarbeiter>) mitarbeiterRepository.findAll();
                Integer ID = Math.toIntExact(element.getMitarbeiter().getId()) - 1;
                Mitarbeiter mitarbeiter = mitarbeiterList.get(ID);

                */

                Optional <Mitarbeiter> mitarbeiter =  mitarbeiterRepository.findById(element.getMitarbeiter().getId());

                return mitarbeiter.get();
            }


        }

        return null;
    }


    public void saveMitarbeiter(Mitarbeiter mitarbeiter) {

        System.out.println("yo bro");

        mitarbeiterRepository.save(mitarbeiter);

    }


}









