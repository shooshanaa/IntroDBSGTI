package com.company.books;

public class Books {
    private int id;
    private String name;
    private float price;

    public Books(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }
}
