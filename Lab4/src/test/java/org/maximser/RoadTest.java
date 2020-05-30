package org.maximser;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.maximser.exceptions.*;
import org.maximser.passengers.*;
import org.maximser.vehicles.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class RoadTest {
    static Road road;

    @BeforeAll
    public static void setUp() throws Exception {
        road = new Road();
        Taxi taxi = new Taxi("Daewoo", 4);
        taxi.download(new Human("Mike", "Tyson", 23));
        road.addCarToRoad(taxi);
    }

    @Test
    public void testGetCountOfHumans() {
        assertEquals(1, road.getCountOfHumans());
        assertNotEquals(3, road.getCountOfHumans());
    }

    @Test
    public void testRemoveVehicle() {
        Assertions.assertThrows(NotFoundCarException.class, () -> {
            road.removeCarOfRoad(new Taxi("Nissan_Leaf", 4));
        });
    }

    @Test
    public void testFreePlaces(){
        Assertions.assertThrows(NoFreePlaceException.class, () -> {
            PoliceCar policeCar;
            policeCar = new PoliceCar("Toyota_Prius", 4);
            policeCar.download(new Policeman("Steve", "Gb", 32));
            policeCar.download(new Policeman("Dave", "Ak", 41));
            policeCar.download(new Policeman("Jojo", "Be", 24));
            policeCar.download(new Policeman("Jhonatan", "Ak", 41));
            policeCar.download(new Policeman("Jo", "Be", 24));
        });
    }

    @Test
    public void unloadPassenger(){
        Assertions.assertThrows(NotFoundPassengerException.class, () -> {
        Bus bus = new Bus("BMW", 15);
        Human human = new Human("Micle", "Ag", 24);
        bus.unload(human);
        });
    }

    @AfterAll
    public static void tearDown() throws Exception {
        road = null;
    }

}