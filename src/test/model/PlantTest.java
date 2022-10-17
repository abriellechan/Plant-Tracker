package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class PlantTest {
    private Plant testPlant;

    @BeforeEach
    void runBefore(){
        testPlant = new Plant("bobby", "pothos", 5, "direct light", "January 5");
    }

    @Test
    void testConstructor(){
        assertEquals("bobby", testPlant.getName());
        assertEquals("pothos", testPlant.getPlantType());
        assertEquals(5, testPlant.getDaysBetweenWater());
        assertEquals("direct light", testPlant.getLightType());
        assertEquals("January 5", testPlant.getBirthday());
    }

    @Test
    void testChangeName(){
        testPlant.changeName("charlie");
        assertEquals("charlie", testPlant.getName());
    }

    @Test
    void testChangeBirthday() {
        testPlant.changeBirthday("April 20");
        assertEquals("April 20", testPlant.getBirthday());
    }
}