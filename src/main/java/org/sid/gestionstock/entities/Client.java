package org.sid.gestionstock.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String ville;
    private String adresse;
    private String mail;
    private String tel;
    @OneToMany(mappedBy = "client")
    private List<CommandeClient> commandeClients;
}
