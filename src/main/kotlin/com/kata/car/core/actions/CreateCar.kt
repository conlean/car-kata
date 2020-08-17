package com.kata.car.core.actions

import com.kata.car.core.domain.entities.Car
import com.kata.car.core.domain.repositories.CarRepository

class CreateCar(private val carRepository: CarRepository) {
    fun invoke(car: Car) {
        carRepository.save(car)
    }
}