package com.example.mitarbeiterverwaltungapp.Entities;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;





@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mitarbeiter")
public class Mitarbeiter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;


    private String nachname;

    private String vorname;
    private float gehalt;
    private String adresse;
    private Long telefonnummer;
    private String abteilung;
    private int arbeitzeit;
    private String geschlecht;
    private int alter;

    @OneToOne
    private User user;


}
