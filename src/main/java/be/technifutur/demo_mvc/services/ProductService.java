package be.technifutur.demo_mvc.services;

import be.technifutur.demo_mvc.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// Service Mock pour simuler l'idée qu'il y a une DB derrière, ce qui n'est pas le cas
@Service
public class ProductService {

    private List<Product> products;

    public ProductService() {
        products = new ArrayList<>();
        products.add(
                Product.builder()
                        .id(1)
                        .brand("brand1")
                        .model("model1")
                        .price(10)
                        .onSale(true)
                        .build()
        );

        products.add(
                Product.builder()
                        .id(2)
                        .brand("brand2")
                        .model("model2")
                        .price(20)
                        .onSale(true)
                        .build()
        );

        products.add(
                Product.builder()
                        .id(3)
                        .brand("brand3")
                        .model("model3")
                        .price(30)
                        .onSale(false)
                        .build()
        );

        products.add(
                Product.builder()
                        .id(4)
                        .brand("brand4")
                        .model("model4")
                        .price(40)
                        .onSale(true)
                        .build()
        );
    }

    public Product getOne(int id) {
        return products.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(); // Exception de base : NoSuchElementException
    }

    public List<Product> getAll() {
        return new ArrayList<>(products); // Renvoie une copie de ma liste pour protéger l'originale
    }

}
