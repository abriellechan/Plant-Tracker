package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class SucculentTest {

    private Succulent testSucculent;

    @BeforeEach
    void runBefore() {
        testSucculent = new Succulent("Bob", "April 20");

    }

    @Test
    void testConstructor() {
        assertEquals(testSucculent.getName(), "Bob");
        assertEquals(testSucculent.getPlantType(), "succulent");
        assertEquals(testSucculent.getBirthday(), "April 20");
        assertEquals(testSucculent.getLightType(), "direct light");
        assertEquals(testSucculent.getDaysBetweenWater(), 21);
    }

}
