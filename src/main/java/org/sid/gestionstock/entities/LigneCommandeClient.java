package org.sid.gestionstock.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import javax.persistence.*;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class LigneCommandeClient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Article article;
    @ManyToOne
    private CommandeClient commandeClient;
    private double quantite;
    private double prixUnitaire;
}
