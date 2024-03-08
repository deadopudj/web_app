package org.example;

public class Product {
    private int productId;
    private String name;
    private double price;
    private String description;
    private int quantityAvailable;

    public Product(int id, String name, double price) {
        this.productId = id;
        this.name = name;
        this.price = price;
    }

    public Product(String name, double price, String description, int quantityAvailable) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantityAvailable = quantityAvailable;
    }

    public Product(int productId, String name, double price, String description, int quantityAvailable) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantityAvailable = quantityAvailable;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }


}


