package com.kata.car.core.actions

import com.kata.car.core.domain.entities.Car
import com.kata.car.core.domain.entities.CarId
import com.kata.car.core.domain.repositories.CarRepository

class FindCar(private val carRepository: CarRepository) {
    operator fun invoke(carId: Long): Car? {
        return carRepository.findById(CarId(carId))
    }
}