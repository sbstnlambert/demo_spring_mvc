package be.technifutur.demo_mvc.services;

import be.technifutur.demo_mvc.models.Product;
import be.technifutur.demo_mvc.models.ProductForm;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// Service Mock pour simuler l'idée qu'il y a une DB derrière, ce qui n'est pas le cas
@Service
public class ProductService {

    private List<Product> products;
    private int nextId = 8;

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

        products.add(
                Product.builder()
                        .id(5)
                        .brand("brand2")
                        .model("model3")
                        .price(230)
                        .onSale(true)
                        .build()
        );products.add(
                Product.builder()
                        .id(6)
                        .brand("brand2")
                        .model("model4")
                        .price(240)
                        .onSale(true)
                        .build()
        );

        products.add(
                Product.builder()
                        .id(7)
                        .brand("brand4")
                        .model("model5")
                        .price(450)
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

    public List<Product> getAllByBrand(String brand) {
        return new ArrayList<>(products).stream()
                .filter(product -> product.getBrand().equalsIgnoreCase(brand))
                .toList();
    }

    public Product insert(ProductForm form) {
        Product p = Product.builder()
                .id(nextId++)
                .brand(form.getBrand())
                .model(form.getModel())
                .price(form.getPrice())
                .onSale(true)
                .build();
        products.add(p);
        return p;
    }

}
