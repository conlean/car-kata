package com.kata.car.core.domain;

import com.kata.car.core.domain.entities.Car;

import java.util.List;
import java.util.stream.Collectors;

public class CarFilter {

    private final String color;

    public CarFilter(String color) {
        this.color = color;
    }

    public List<Car> apply(List<Car> cars) {
        return cars.stream().filter(car -> car.getColor().equals(color)).collect(Collectors.toList());
    }
}
