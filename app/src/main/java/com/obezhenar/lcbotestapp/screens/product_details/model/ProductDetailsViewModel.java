package com.obezhenar.lcbotestapp.screens.product_details.model;

public class ProductDetailsViewModel {
    private long id;
    private String name;
    private String price;
    private String alcoholContent;
    private String description;
    private String imagePath;

    public ProductDetailsViewModel(
            long id,
            String name,
            String price,
            String alcoholContent,
            String description,
            String imagePath) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.alcoholContent = alcoholContent;
        this.description = description;
        this.imagePath = imagePath;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAlcoholContent() {
        return alcoholContent;
    }

    public void setAlcoholContent(String alcoholContent) {
        this.alcoholContent = alcoholContent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
