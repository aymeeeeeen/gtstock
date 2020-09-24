package org.sid.gestionstock.dao;

import org.sid.gestionstock.entities.CommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface CommandeFournisseurRepository extends JpaRepository<CommandeFournisseur, Long> {
}
