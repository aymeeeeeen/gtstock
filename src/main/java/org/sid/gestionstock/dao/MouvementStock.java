package org.sid.gestionstock.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class MouvementStock {
    public static final int ENTREE = 1;
    public static final int SORTIE = 2;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateMouvement;
    private BigDecimal quantite;
    private int typeMouvement;
    @ManyToOne
    private Article article;
}
