package be.technifutur.demo_mvc.models;

import lombok.Data;

@Data
public class ProductForm {

    // Je souhaite juste la marque, du modèe et du prix
    // Je configurerai dans le service que
    // - l'id soit généré automatiquement
    // - le produit soit d'office disponible en vente
    private String brand;
    private String model;
    private double price;

}
