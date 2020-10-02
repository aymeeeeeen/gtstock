package org.sid.gestionstock.web;

import org.sid.gestionstock.dao.ClientRepository;
import org.sid.gestionstock.dao.CommandeClientRepository;
import org.sid.gestionstock.entities.CommandeClient;
import org.sid.gestionstock.entities.Fournisseur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class commandeClient {

	@Autowired
	CommandeClientRepository commandeClientRepository;
	@Autowired
	ClientRepository clientRepository;
	
    @GetMapping(path = "/ltcommandeClient")
    public String ltcommandeClient(Model model,
                           @RequestParam(name = "page", defaultValue = "0")int page,
                           @RequestParam(name = "size", defaultValue = "10")int size,
                           @RequestParam(name = "key", defaultValue = "")String mc) {
        Page<CommandeClient> pagecommandeClient=commandeClientRepository.findBycodeContains(mc, PageRequest.of(page, size));
        model.addAttribute("commandeClient", pagecommandeClient.getContent());
        model.addAttribute("pages", new int[pagecommandeClient.getTotalPages()]);
        model.addAttribute("totalpages", pagecommandeClient.getTotalPages());
        model.addAttribute("totalItems", pagecommandeClient.getTotalElements());
        model.addAttribute("currentPage", page);
        model.addAttribute("size", size);
        model.addAttribute("key", mc);
        return "ltcommandeClient";
    }

    @GetMapping(path = "/addcommandeClient")
    public String addcommandeClient(Model model){
    	model.addAttribute("ltClient", clientRepository.findAll());
        model.addAttribute("commandeClient" , new CommandeClient());
        return "addcommandeClient";
    }

    @PostMapping("/savecommandeClient")
    public String savecommandeClient(CommandeClient commandeClient){
        commandeClientRepository.save(commandeClient);
        return "redirect:/ltcommandeClient";
    }

    @GetMapping(path = "/deletecommandeClient")
    public String deletecommandeClient(Long id, String key, int page, int size) {
        commandeClientRepository.deleteById(id);
        return "redirect:/ltcommandeClient?page"+page+"&size"+size+"&key"+key;
    }

    @GetMapping(path = "/editcommandeClient")
    public String editcommandeClient(Model model, Long id) {
        CommandeClient commandeClient = commandeClientRepository.findById(id).get();
        model.addAttribute("commandeClient", commandeClient);
        return "addcommandeClient";
    }
}
