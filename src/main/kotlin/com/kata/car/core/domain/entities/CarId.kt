package com.kata.car.core.domain.entities

data class CarId(val value: Long) {
    init {
        require(value >= 0)
    }
}
