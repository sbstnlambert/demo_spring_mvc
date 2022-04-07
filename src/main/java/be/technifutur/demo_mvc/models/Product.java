package be.technifutur.demo_mvc.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {

    private int id;
    private String brand;
    private String model;
    private double price;
    private boolean onSale;

}
