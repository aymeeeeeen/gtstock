package org.sid.gestionstock.dao;

import org.sid.gestionstock.entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@RepositoryRestResource
@CrossOrigin("*")
public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {
}
