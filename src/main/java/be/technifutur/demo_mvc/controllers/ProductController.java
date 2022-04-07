package be.technifutur.demo_mvc.controllers;

import be.technifutur.demo_mvc.models.Product;
import be.technifutur.demo_mvc.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.NoSuchElementException;

// NB : Ce n'est pas un Controller d'API (un @RestController)
@Controller
public class ProductController {
    // Avec MVC, on a du GET et du POST
    // C'est avec REST qu'on a accès aux autres (PUT, PATCH, etc.)

    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("product/{id}")
    // Je renvoie le nom du fichier qui se trouve dans mon dossier templates (package resources.templates)
    // Très souvent, renvoie un String
    // Model (from org.springframework.ui) sert à lier mon Controller à la Vue
    public String displayOne(@PathVariable int id, Model model) {
        Product p = service.getOne(id);
        model.addAttribute("product", p);

        // Renvoie le fichier displayOne.html dans resources.templates
        return "displayOne";
    }

    @ExceptionHandler(NoSuchElementException.class)
    public String handle(NoSuchElementException e) {
        return "404";
    }

}
