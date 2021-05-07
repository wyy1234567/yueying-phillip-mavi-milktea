package com.ascent.restfulmilktea;

public enum Toppings {
    JELLY ("Jelly"),
    BOBA ("Boba"),
    CHEESE ("Cheese"),
    HERB_JELLY ("Herb Jelly"),
    OREO ("Oreo");

    private final String name;

    Toppings(String name){
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
}
