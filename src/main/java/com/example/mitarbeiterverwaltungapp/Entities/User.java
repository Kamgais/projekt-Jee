package com.example.mitarbeiterverwaltungapp.Entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="user")
public class User {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id ;
    private String username;
    private String password;
}
