package com.example.sample.Domain;

public class Foods {
    private int categoryId;
    private String description;
    private boolean wholeLechon;
    private int id;
    private double price;
    private String title;
    private int numberInCart;

    public Foods(String title, double price){
        this.title = title;
        this.price = price;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isWholeLechon() {
        return wholeLechon;
    }

    public void setWholeLechon(boolean wholeLechon) {
        this.wholeLechon = wholeLechon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }

    @Override
    public String toString() {
        return title;
    }
}
