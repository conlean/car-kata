package com.kata.car.core.actions

import com.kata.car.core.domain.repositories.CarRepository

class CountCars(val repository: CarRepository) {
    fun invoke(): Int {
        return repository.count()
    }
}