package com.ascent.restfulmilktea;

public enum Size {
    SMALL ("Small"),
    MEDIUM ("Medium"),
    LARGE ("Large");

    private final String name;

    Size(String name){
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

}
