package org.sid.gestionstock.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommandeClient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String code;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateCommande;
	@ManyToOne
	private Client client;
	@OneToMany(mappedBy = "commandeClient")
	private List<LigneCommandeClient> ligneCommandeClients;
	
//	private double totalCommande;

//	public double getToTalCommande() {
//		totalCommande=0;
//		if (!ligneCommandeClients.isEmpty()) {
//			for (LigneCommandeClient ligneCommandeClient : ligneCommandeClients) {
//					double totalLigne=ligneCommandeClient.getQuantite()*ligneCommandeClient.getPrixUnitaire();
//					totalCommande=totalCommande+totalLigne;
//			}
//		}
//		return totalCommande;
//	}
}
