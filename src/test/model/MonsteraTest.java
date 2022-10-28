package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class MonsteraTest {

    private Monstera testMonstera;

    @BeforeEach
    void runBefore() {
        testMonstera = new Monstera("Bob", "April 20");

    }

    @Test
    void testConstructor() {
        assertEquals(testMonstera.getName(), "Bob");
        assertEquals(testMonstera.getPlantType(), "monstera");
        assertEquals(testMonstera.getBirthday(), "April 20");
        assertEquals(testMonstera.getLightType(), "indirect light");
        assertEquals(testMonstera.getDaysBetweenWater(), 10);
    }

}
