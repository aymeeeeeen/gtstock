package org.sid.gestionstock.Service;

import org.sid.gestionstock.entities.CommandeClient;
import org.springframework.beans.factory.annotation.Autowired;


public interface ICommandeService {

    public String genererCodeCommandeClient();
    //public void initLigneCommande();
}
