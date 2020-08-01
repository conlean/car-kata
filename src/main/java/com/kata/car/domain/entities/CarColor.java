package com.kata.car.domain.entities;

public class CarColor {

    private final String color;

    public CarColor(String color) {
        if (color.equals("")) {
            throw new RuntimeException("Color cannot be empty");
        }
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
