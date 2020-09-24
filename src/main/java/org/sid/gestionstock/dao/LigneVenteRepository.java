package org.sid.gestionstock.dao;

import org.sid.gestionstock.entities.LigneVente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface LigneVenteRepository extends JpaRepository<LigneVente, Long> {
}
