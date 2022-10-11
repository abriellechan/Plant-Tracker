package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class PlantTest {
    private Plant testPlant;

    @BeforeEach
    void runBefore(){
        testPlant = new Plant("bobby", 5, "direct light", "January 5");
    }

    @Test
    void testConstructor(){
        assertEquals("bobby", testPlant.getName());
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
    void testChangeDaysBetweenWater() {
        testPlant.changeDaysBetweenWater(5);
        assertEquals(5, testPlant.getDaysBetweenWater());
    }

    @Test
    void testChangeLightType() {
        testPlant.changeLightType("indirect light");
        assertEquals("indirect light", testPlant.getLightType());
    }

    @Test
    void testChangeBirthday() {
        testPlant.changeBirthday("April 20");
        assertEquals("April 20", testPlant.getBirthday());
    }

    /*
    @Test
    void testPrintInfo(){
        String s = testPlant.printInfo();
        assertEquals("bobby, 5, direct light, January 5", s);
    }
     */


}