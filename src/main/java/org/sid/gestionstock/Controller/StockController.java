package org.sid.gestionstock.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.sid.gestionstock.dao.ClientRepository;
import org.sid.gestionstock.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller

public class StockController {
	@Autowired
	private ClientRepository clientRepository;

	/// les methodes de table Client

	@GetMapping(path = "/client")
	public String client(Model model) {
		List<Client> clients = clientRepository.findAll();
		if (clients == null) {
			clients = new ArrayList<Client>();
		}
		model.addAttribute("clients", clients);
		return "client/client";
	}

	@GetMapping("/nouveauClient")
	public String ajouterClient(Model model) {
		Client client = new Client();
		model.addAttribute("client", client);

		return "client/AjouterClient";
	}

	@PostMapping("/nouveauClient")
	public String enregistrerClient(Model model, Client client, MultipartFile file) throws IOException {
		String photoUrl=null;
		if (file != null) {
			if(file.isEmpty()) {
				InputStream stream=file.getInputStream();
				//photoUrl=flick.savephoto(stream,client.getNom()); erreur
			}
		}
		clientRepository.save(client);
		
		return "redirect:/client/";
	}

}
