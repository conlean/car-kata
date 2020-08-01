package com.kata.car.domain.actions

import com.kata.car.domain.entities.Car
import com.kata.car.domain.repositories.CarRepository

class CreateCar(private val carRepository: CarRepository) {
    fun invoke(car: Car) {

    }
}