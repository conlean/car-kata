package com.kata.car.core.actions

import com.kata.car.core.domain.entities.Car
import com.kata.car.core.domain.entities.CarColor
import com.kata.car.core.domain.entities.CarId
import com.kata.car.core.domain.repositories.CarRepository
import com.kata.car.infra.repositories.InMemoryCarRepository
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class FindCarTest {

    private lateinit var carRepository: CarRepository
    private var car: Car? = null
    private lateinit var action: FindCar

    @Test
    fun `find not existing car`() {
        val idCar = 1L
        givenAnAction(InMemoryCarRepository())

        whenActionIsInvoked(idCar)

        thenCarReturnedIs(car)
    }

    @Test
    fun `find existing car`() {
        val carId = CarId(1L)
        val existingCar = givenCarId(carId)

        givenCarRepository(carId, existingCar)
        givenAnAction(carRepository)

        whenActionIsInvoked(carId.value)

        thenRetrievedCarIs(existingCar)

    }

    private fun thenRetrievedCarIs(existingCar: Car) {
        assertNotNull(car)
        assertEquals(existingCar, car)
    }

    private fun givenCarRepository(carId: CarId, existingCar: Car) {
        carRepository = InMemoryCarRepository(mutableMapOf(carId to existingCar))
    }

    private fun givenCarId(carId: CarId) = Car(id = carId, color = CarColor("red"))

    private fun thenCarReturnedIs(car: Car?) {
        assertNull(car)
    }

    private fun whenActionIsInvoked(carId: Long) {
        car = action(carId)
    }

    private fun givenAnAction(carRepository: CarRepository) {
        action = FindCar(carRepository)
    }


}