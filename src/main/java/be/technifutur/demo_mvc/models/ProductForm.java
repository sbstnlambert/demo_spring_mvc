package be.technifutur.demo_mvc.models;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Validated
public class ProductForm {

    // Utilisation des @NotBlank, @Size et @Min après avoir ajouté la spring validation dans les dépendances
    @NotBlank
    @Size(min = 2, max = 50)
    // Je souhaite juste la marque, du modèe et du prix
    // Je configurerai dans le service que
    // - l'id soit généré automatiquement
    // - le produit soit d'office disponible en vente
    private String brand;
    @NotBlank
    @Size(min = 2, max = 50)
    private String model;
    @NotNull(message = "STOP! Price is null.")
    @Min(0)
    private Double price;

}
