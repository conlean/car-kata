package com.kata.car;

import com.kata.car.domain.CarFilter;
import com.kata.car.domain.entities.Car;
import com.kata.car.domain.entities.CarColor;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;


public class CarFilterTest {

    private List<Car> cars = Collections.emptyList();
    private CarFilter carFilter;
    private List<Car> filteredList = Collections.emptyList();
    CarColor carColorRed;
    CarColor carColorBlue;
    CarColor carColorBlack;


    @Before
    public void init() {
        carColorRed = new CarColor("red");
        carColorBlue = new CarColor("blue");
        carColorBlack = new CarColor("Black");
    }

    @Test
    public void filterRedCarsTest() {
        givenAListOfCars();
        givenACarFilter("red");

        whenFilterIsApplied();

        thenResultingListHasRedCars();
    }

    @Test
    public void mapTest() {

        cars = Arrays.asList(new Car(carColorRed), new Car(carColorBlue), new Car(carColorBlack));

        List<String> carColors = cars.stream().map(car -> car.getColor().getColor()).collect(Collectors.toList());

        assertThat(carColors, hasItems("blue"));
    }

    @Test(expected = RuntimeException.class)
    public void carWithEmptyColor() {
        CarColor carColor = new CarColor("");
        Car car = new Car(carColor);


    }

    private void givenACarFilter(String color) {
        carFilter = new CarFilter(color);
    }

    private void givenAListOfCars() {
        cars = Arrays.asList(new Car(carColorBlack), new Car(carColorBlue), new Car(carColorRed));
    }

    private void whenFilterIsApplied() {
        filteredList = carFilter.apply(cars);
    }

    private void thenResultingListHasRedCars() {
        assertThat(filteredList.size(), is(1));
    }

}
