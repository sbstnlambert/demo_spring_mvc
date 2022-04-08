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

    // ModelAttribute est à utiliser avec parcimonie
    // Surtout s'il concerne une requête très sollicitée
    @ModelAttribute("get_all")
    public List<Product> getAll() {
        return service.getAll();
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
    // Commente car ce code est remplacé par l'implémentation de la méthode getAll()
//    public String displayAll(Model model) {
//        List<Product> list = service.getAll();
//        model.addAttribute("product_list", list);
    public String displayAll() {
        return "displayAll";
    }

    @GetMapping("/by_brand")
    // Je passe "brand" à @ModelAttribute, mais c'est facultatif
    // car ma variable se nomme déjà brand
    public String displayBrand(@RequestParam @ModelAttribute("brand") String brand, Model model) {
        model.addAttribute("brand_list", service.getAllByBrand(brand));
//        model.addAttribute("brand", brand);
        return "displayByBrand";
    }

    @ExceptionHandler(NoSuchElementException.class)
    public String handle(NoSuchElementException e) {
        return "404";
    }

}
