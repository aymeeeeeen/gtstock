package org.sid.gestionstock.Service;


import org.sid.gestionstock.dao.CommandeClientRepository;
import org.sid.gestionstock.dao.LigneCommandeClientRepository;
import org.sid.gestionstock.entities.CommandeClient;
import org.sid.gestionstock.entities.LigneCommandeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class CommandeServiceImpl implements ICommandeService {

    @Autowired
    private CommandeClientRepository commandeClientRepository;

    @Autowired
    private LigneCommandeClientRepository ligneCommandeClientRepository;


    @Override
    public String genererCodeCommandeClient() {
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }

//    @Override
//    public void initLigneCommande() {
//        commandeClientRepository.findAll().forEach(commandeClient -> {
//            LigneCommandeClient ligneCommandeClient1 = new LigneCommandeClient();
//            ligneCommandeClient1.setCommandeClient(commandeClient);
//        });
//    }
}
