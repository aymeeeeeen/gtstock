package org.sid.gestionstock.web;

import org.sid.gestionstock.dao.ArticleRepository;
import org.sid.gestionstock.dao.ClientRepository;
import org.sid.gestionstock.dao.FournisseurRepository;
import org.sid.gestionstock.entities.Article;
import org.sid.gestionstock.entities.Client;
import org.sid.gestionstock.entities.Fournisseur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StockController {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private FournisseurRepository fournisseurRepository;

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
                           @RequestParam(name = "size", defaultValue = "25")int size,
                           @RequestParam(name = "key", defaultValue = "")String mc) {
        Page<Client> pageClient=clientRepository.findByNom(mc, PageRequest.of(page, size));
        model.addAttribute("clients", pageClient.getContent());
        model.addAttribute("pages", new int[pageClient.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("size", size);
        model.addAttribute("key", mc);
        return "ltClient";
    }

    @GetMapping(path = "/addClient")
    public String addClient(){
        return "addClient";
    }

    /// les methodes de table Article

    @GetMapping(path = "/ltArticle")
    public String ltArticle(Model model,
                           @RequestParam(name = "page", defaultValue = "0")int page,
                           @RequestParam(name = "size", defaultValue = "25")int size,
                           @RequestParam(name = "key", defaultValue = "")String mc) {
        Page<Article> pageArticle=articleRepository.findByCodeArticle(mc, PageRequest.of(page, size));
        model.addAttribute("articles", pageArticle.getContent());
        model.addAttribute("pages", new int[pageArticle.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("size", size);
        model.addAttribute("key", mc);
        return "ltArticle";
    }

    @GetMapping(path = "/addArticle")
    public String addArticle(){
        return "addArticle";
    }

    /// les methodes de table Fournisseur

    @GetMapping(path = "/ltFournisseur")
    public String ltFournisseur(Model model,
                           @RequestParam(name = "page", defaultValue = "0")int page,
                           @RequestParam(name = "size", defaultValue = "25")int size,
                           @RequestParam(name = "key", defaultValue = "")String mc) {
        Page<Fournisseur> pageFournisseur=fournisseurRepository.findByNom(mc, PageRequest.of(page, size));
        model.addAttribute("fournisseurs", pageFournisseur.getContent());
        model.addAttribute("pages", new int[pageFournisseur.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("size", size);
        model.addAttribute("key", mc);
        return "ltFournisseur";
    }

    @GetMapping(path = "/addFournisseur")
    public String addFournisseur(){
        return "addFournisseur";
    }

}
