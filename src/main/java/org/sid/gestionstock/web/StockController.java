package org.sid.gestionstock.web;

import org.sid.gestionstock.Service.ICommandeService;
import org.sid.gestionstock.dao.*;
import org.sid.gestionstock.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;


@Controller
public class StockController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private FournisseurRepository fournisseurRepository;

    @Autowired
    private CommandeClientRepository commandeClientRepository;

    @Autowired
    private LigneCommandeClientRepository ligneCommandeClientRepository;

    @Autowired
    private ICommandeService iCommandeService;

    @GetMapping(path = "/index")
    public String index(){
        return "index";
    }

    @GetMapping(path = "/dashboard")
    public String dashboard(){
        return "dashboard";
    }

    /// les methodes de table Client

    @GetMapping(path = "/ltClient")
    public String ltClient(Model model,
                           @RequestParam(name = "page", defaultValue = "0")int page,
                           @RequestParam(name = "size", defaultValue = "10")int size,
                           @RequestParam(name = "key", defaultValue = "")String mc) {
        Page<Client> pageClient=clientRepository.findByNomContains(mc, PageRequest.of(page, size));
        model.addAttribute("clients", pageClient.getContent());
        model.addAttribute("pages", new int[pageClient.getTotalPages()]);
        model.addAttribute("totalItems", pageClient.getTotalElements());
        model.addAttribute("totalpages", pageClient.getTotalPages());
        model.addAttribute("currentPage", page);
        model.addAttribute("size", size);
        model.addAttribute("key", mc);
        return "ltClient";
    }

    @GetMapping(path = "/addClient")
    public String addClient(Model  model){
        model.addAttribute("client" , new Client());
        return "addClient";
    }

    @PostMapping("/saveClient")
    public String saveClient(Client client){
        clientRepository.save(client);
        return "redirect:/ltClient";
    }

    @GetMapping(path = "/deleteClient")
    public String deleteClient(Long id, String key, int page, int size) {
        clientRepository.deleteById(id);
        return "redirect:/ltClient?page"+page+"&size"+size+"&key"+key;
    }

    @GetMapping(path = "/editClient")
    public String editClient(Model model, Long id) {
        Client client = clientRepository.findById(id).get();
        model.addAttribute("client", client);
        return "addClient";
    }

    /// les methodes de table Article

    @GetMapping(path = "/ltArticle")
    public String ltArticle(Model model,
                           @RequestParam(name = "page", defaultValue = "0")int page,
                           @RequestParam(name = "size", defaultValue = "10")int size,
                           @RequestParam(name = "key", defaultValue = "")String mc) {
        Page<Article> pageArticle=articleRepository.findByCodeArticleContains(mc, PageRequest.of(page, size));
        model.addAttribute("articles", pageArticle.getContent());
        model.addAttribute("pages", new int[pageArticle.getTotalPages()]);
        model.addAttribute("totalpages", pageArticle.getTotalPages());
        model.addAttribute("totalItems", pageArticle.getTotalElements());
        model.addAttribute("currentPage", page);
        model.addAttribute("size", size);
        model.addAttribute("key", mc);
        return "ltArticle";
    }

    @GetMapping(path = "/addArticle")
    public String addArticle(Model model){
        model.addAttribute("article" , new Article());
        return "addArticle";
    }

    @PostMapping("/saveArticle")
    public String saveArticle(Article article){
        articleRepository.save(article);
        return "redirect:/ltArticle";
    }

    @GetMapping(path = "/deleteArticle")
    public String deleteArticle(Long id, String key, int page, int size) {
        articleRepository.deleteById(id);
        return "redirect:/ltArticle?page"+page+"&size"+size+"&key"+key;
    }

    @GetMapping(path = "/editArticle")
    public String editArticle(Model model, Long id) {
        Article article = articleRepository.findById(id).get();
        model.addAttribute("article", article);
        return "addArticle";
    }


    /// les methodes de table Fournisseur

    @GetMapping(path = "/ltFournisseur")
    public String ltFournisseur(Model model,
                           @RequestParam(name = "page", defaultValue = "0")int page,
                           @RequestParam(name = "size", defaultValue = "10")int size,
                           @RequestParam(name = "key", defaultValue = "")String mc) {
        Page<Fournisseur> pageFournisseur=fournisseurRepository.findByNomContains(mc, PageRequest.of(page, size));
        model.addAttribute("fournisseurs", pageFournisseur.getContent());
        model.addAttribute("pages", new int[pageFournisseur.getTotalPages()]);
        model.addAttribute("totalpages", pageFournisseur.getTotalPages());
        model.addAttribute("totalItems", pageFournisseur.getTotalElements());
        model.addAttribute("currentPage", page);
        model.addAttribute("size", size);
        model.addAttribute("key", mc);
        return "ltFournisseur";
    }

    @GetMapping(path = "/addFournisseur")
    public String addFournisseur(Model model){
        model.addAttribute("fournisseur" , new Fournisseur());
        return "addFournisseur";
    }

    @PostMapping("/saveFournisseur")
    public String saveFournisseur(Fournisseur fournisseur){
        fournisseurRepository.save(fournisseur);
        return "redirect:/ltFournisseur";
    }

    @GetMapping(path = "/deleteFournisseur")
    public String deleteFournisseur(Long id, String key, int page, int size) {
        fournisseurRepository.deleteById(id);
        return "redirect:/ltFournisseur?page"+page+"&size"+size+"&key"+key;
    }

    @GetMapping(path = "/editFournisseur")
    public String editFournisseur(Model model, Long id) {
        Fournisseur fournisseur = fournisseurRepository.findById(id).get();
        model.addAttribute("fournisseur", fournisseur);
        return "addFournisseur";
    }

    /// les methodes de table Commande Client

    @GetMapping(path = "/ltCommandeClient")
    public String ltCommandeClient(Model model,
                                @RequestParam(name = "page", defaultValue = "0")int page,
                                @RequestParam(name = "size", defaultValue = "10")int size,
                                @RequestParam(name = "key", defaultValue = "")String mc) {
        Page<CommandeClient> pageCommandeClient=commandeClientRepository.findByCodeContains(mc, PageRequest.of(page, size));
        model.addAttribute("CommandeClient", pageCommandeClient.getContent());
        model.addAttribute("pages", new int[pageCommandeClient.getTotalPages()]);
        model.addAttribute("totalpages", pageCommandeClient.getTotalPages());
        model.addAttribute("totalItems", pageCommandeClient.getTotalElements());
        model.addAttribute("currentPage", page);
        model.addAttribute("size", size);
        model.addAttribute("key", mc);
        return "ltCommandeClient";
    }

    @GetMapping(path = "/addCommandeClient")
    public String addCommandeClient(Model model){


        model.addAttribute("codeCmd", iCommandeService.genererCodeCommandeClient());
        model.addAttribute("client", clientRepository.findAll());
        model.addAttribute("articles", articleRepository.findAll());
        model.addAttribute("LigneCommandeClients", new LigneCommandeClient());
        model.addAttribute("CommandeClient" , new CommandeClient());
        return "addCommandeClient";
    }

    @PostMapping("/saveCommandeClient")
    public String saveCommandeClient(CommandeClient commandeClient,
                                     LigneCommandeClient lcmd,
                                     @RequestParam (name="cmdclt")Long id){
        commandeClientRepository.save(commandeClient);

//        commandeClientRepository.findAll().forEach(cmdclient -> {
//            LigneCommandeClient ligneCommandeClient = new LigneCommandeClient();
//            ligneCommandeClient.setCommandeClient(cmdclient);
//            ligneCommandeClientRepository.save(ligneCommandeClient);
//        });
//        ligneCommandeClientRepository.save(lcmd);
        CommandeClient cmdclt = commandeClientRepository.findById(id).get();
        lcmd.setCommandeClient(cmdclt);
        ligneCommandeClientRepository.save(lcmd);
        return "redirect:/ltCommandeClient";
    }

    @GetMapping(path = "/deleteCommandeClient")
    public String deleteCommandeClient(Long id, String key, int page, int size) {
        commandeClientRepository.deleteById(id);
        return "redirect:/ltCommandeClient?page"+page+"&size"+size+"&key"+key;
    }

    @GetMapping(path = "/editCommandeClient")
    public String editCommandeClient(Model model, Long id) {
        CommandeClient commandeClient = commandeClientRepository.findById(id).get();
        model.addAttribute("CommandeClient", commandeClient);
        return "addCommandeClient";
    }

    /// les methodes de table Commande Client

//    @GetMapping(path = "/addLigneCommandeClient")
//    public String addLigneCommandeClient(Model model){
//        return "addCommandeClient";
//    }
//
//    @PostMapping("/saveLigneCommandeClient")
//    public String saveLigneCommandeClient(LigneCommandeClient ligneCommandeClient,
//                                          @RequestParam (name="cmdclt")Long id){
//        CommandeClient cmdclt = commandeClientRepository.findById(id).get();
//        ligneCommandeClient.setCommandeClient(cmdclt);
//        ligneCommandeClientRepository.save(ligneCommandeClient);
//        return "redirect:/ltCommandeClient";
//    }
}
