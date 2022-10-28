package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class StringOfPearlsTest {

    private StringOfPearls testStringOfPearls;

    @BeforeEach
    void runBefore() {
        testStringOfPearls = new StringOfPearls("Bob", "April 20");

    }

    @Test
    void testConstructor() {
        assertEquals(testStringOfPearls.getName(), "Bob");
        assertEquals(testStringOfPearls.getPlantType(), "string of pearls");
        assertEquals(testStringOfPearls.getBirthday(), "April 20");
        assertEquals(testStringOfPearls.getLightType(), "indirect light");
        assertEquals(testStringOfPearls.getDaysBetweenWater(), 14);
    }

}