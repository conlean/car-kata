package com.kata.car.domain;

import com.kata.car.domain.entities.Car;

import java.util.List;
import java.util.stream.Collectors;

public class CarFilter {

    private final String color;

    public CarFilter(String color) {
        this.color= color;
    }

    public List<Car> apply(List<Car> cars) {
        //Aca tambien estaba null porque car.getCarColor()
        return cars.stream().filter(car -> car.getColor().equals(color)).collect(Collectors.toList());
    }
}
