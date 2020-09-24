package org.sid.gestionstock.dao;

import org.sid.gestionstock.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
}
