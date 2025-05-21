package com.zoo.model;

public class Ticket {
    private int id;
    private String visitorName;
    private double price;
    private String purchaseDate;

    public Ticket(String visitorName, double price) {
        this.visitorName = visitorName;
        this.price = price;
    }

    public Ticket(int id, String visitorName, double price, String purchaseDate) {
        this.id = id;
        this.visitorName = visitorName;
        this.price = price;
        this.purchaseDate = purchaseDate;
    }

    // Геттеры и сеттеры
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getVisitorName() { return visitorName; }
    public void setVisitorName(String visitorName) { this.visitorName = visitorName; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getPurchaseDate() { return purchaseDate; }
    public void setPurchaseDate(String purchaseDate) { this.purchaseDate = purchaseDate; }
}
