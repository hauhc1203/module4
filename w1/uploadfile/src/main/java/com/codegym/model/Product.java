package com.codegym.model;

public class Product {
    private int id;
    private int price;
    private String name;
    private String img;
    private boolean status;
    private Category category;

    public Product() {
    }

    public Product(int id, int price, String name, String img, boolean status, Category category) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.img = img;
        this.status = status;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

