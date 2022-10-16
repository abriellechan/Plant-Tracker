package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class GardenListTest {

    private GardenList testGardenList;
    private Plant testPlant;

    @BeforeEach
    void runBefore() {
        testGardenList = new GardenList();
        testPlant = new Plant("bobby", "pothos", 5, "direct light", "January 5");
    }

    @Test
    void testAddPlantToGarden() {
        testGardenList.addPlantToGarden(testPlant);
        assertTrue((testGardenList.getGardenList()).contains(testPlant));
        assertEquals((testGardenList.getGardenList()).size(), 1);
    }

    @Test
    void testSizeOfGarden() {
        testGardenList.addPlantToGarden(testPlant);
        assertEquals(testGardenList.sizeOfGarden(), 1);
        testGardenList.addPlantToGarden(testPlant);
        testGardenList.addPlantToGarden(testPlant);
        assertEquals(testGardenList.sizeOfGarden(), 3);
    }

}
