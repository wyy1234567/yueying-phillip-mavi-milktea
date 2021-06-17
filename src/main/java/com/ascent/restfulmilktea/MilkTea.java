package com.ascent.restfulmilktea;


import java.util.ArrayList;

public class MilkTea {
    private Long id;
    private String name;
    private String price;
    private ArrayList<String> ingredients;
    private ArrayList<String> toppings;

    private String size;
    private boolean caffeinated;

    public boolean isCaffeinated() {
        return caffeinated;
    }

    public void setCaffeinated(boolean caffeinated) {
        this.caffeinated = caffeinated;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }


    public MilkTea(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public MilkTea() {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArrayList<String> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<String> toppings) {
        this.toppings = toppings;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
