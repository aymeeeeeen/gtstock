package org.sid.gestionstock.dao;

import org.sid.gestionstock.entities.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface CommandeClientRepository extends JpaRepository<CommandeClient, Long> {
}
