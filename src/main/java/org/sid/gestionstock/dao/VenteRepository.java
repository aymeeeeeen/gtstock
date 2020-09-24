package org.sid.gestionstock.dao;

import org.sid.gestionstock.entities.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface VenteRepository extends JpaRepository<Vente, Long> {
}
