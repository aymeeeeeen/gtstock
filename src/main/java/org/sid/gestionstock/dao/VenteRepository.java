package org.sid.gestionstock.dao;

import org.sid.gestionstock.entities.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource
@CrossOrigin("*")
public interface VenteRepository extends JpaRepository<Vente, Long> {
}
