package org.sid.gestionstock.dao;

import org.sid.gestionstock.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface ClientRepository extends JpaRepository<Client, Long> {
}
