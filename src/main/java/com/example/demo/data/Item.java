package com.example.demo.data;

import java.io.Serializable;

public class Item implements Serializable {
    public static final Long seriaUID = 789L;
    private int id;
    private String item_name;
    private double item_price;
    private String item_description;
    private int item_nummber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public double getItem_price() {
        return item_price;
    }

    public void setItem_price(double item_price) {
        this.item_price = item_price;
    }

    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    public int getItem_nummber() {
        return item_nummber;
    }

    public void setItem_nummber(int item_nummber) {
        this.item_nummber = item_nummber;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", item_name='" + item_name + '\'' +
                ", item_price=" + item_price +
                ", item_description='" + item_description + '\'' +
                ", item_nummber=" + item_nummber +
                '}';
    }
}
