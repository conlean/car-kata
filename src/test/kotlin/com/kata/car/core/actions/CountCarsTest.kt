package com.kata.car.core.actions

import com.kata.car.core.domain.entities.Car
import com.kata.car.core.domain.entities.CarColor
import com.kata.car.core.domain.entities.CarId
import com.kata.car.core.domain.repositories.CarRepository
import com.kata.car.infra.repositories.InMemoryCarRepository
import org.junit.Test

class CountCarsTest {

    @Test
    fun `count empty cars`() {
        //given
        val action = CountCars(InMemoryCarRepository())

        //when
        val count = action.invoke()

        //then
        assert(count == 0)

    }

    @Test
    fun `count one or more existing cars`() {
        //given
        val existingCars = mutableMapOf(CarId(1L) to Car(CarId(1L), CarColor("blue")))
        val repository: CarRepository = InMemoryCarRepository(existingCars)
        val action = CountCars(repository)

        //when
        val count = action.invoke()

        //then
        assert(count > 0)

    }


}