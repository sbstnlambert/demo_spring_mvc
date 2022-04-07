package be.technifutur.demo_mvc.controllers;

import be.technifutur.demo_mvc.models.Product;
import be.technifutur.demo_mvc.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

// NB : Ce n'est pas un Controller d'API (un @RestController)
@Controller
@RequestMapping("/product")
public class ProductController {
    // Avec MVC, on a du GET et du POST
    // C'est avec REST qu'on a accès aux autres (PUT, PATCH, etc.)

    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    // Je renvoie le nom du fichier qui se trouve dans mon dossier templates (package resources.templates)
    // Très souvent, renvoie un String
    // Model (from org.springframework.ui) sert à lier mon Controller à la Vue
    public String displayOne(@PathVariable int id, Model model) {
        Product p = service.getOne(id);
        model.addAttribute("product", p);

        // Renvoie le fichier displayOne.html dans resources.templates
        return "displayOne";
    }

    @GetMapping
    public String displayAll(Model model) {
        List<Product> list = service.getAll();
        model.addAttribute("product_list", list);
        return "displayAll";
    }

    @GetMapping("/brand")
    public String displayBrand(@RequestParam String brand, Model model) {
        List<Product> brandList = service.getAllByBrand(brand);
        model.addAttribute("brand_list", brandList);
        model.addAttribute("brand", brand);
        return "displayByBrand";
    }

    @ExceptionHandler(NoSuchElementException.class)
    public String handle(NoSuchElementException e) {
        return "404";
    }

}
