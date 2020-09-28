package org.sid.gestionstock.dao;

import org.sid.gestionstock.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource
@CrossOrigin("*")
public interface ClientRepository extends JpaRepository<Client, Long> {
    public Page<Client> findByNom(String mc, Pageable pageable);
}
