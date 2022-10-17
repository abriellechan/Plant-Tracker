package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PothosTest {

    private Pothos testPothos;

    @BeforeEach
    void runBefore() {
        testPothos = new Pothos("Bob", "April 20");

    }

    @Test
    void testConstructor() {
        assertEquals(testPothos.getName(), "Bob");
        assertEquals(testPothos.getPlantType(), "pothos");
        assertEquals(testPothos.getBirthday(), "April 20");
        assertEquals(testPothos.getLightType(), "medium light");
        assertEquals(testPothos.getDaysBetweenWater(), 7);
    }

}
