package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GardenListTest {

    private GardenList testGardenList;
    private Plant testPlant1;
    private Plant testPlant2;
    private Plant testPlant3;

    @BeforeEach
    void runBefore() {
        testGardenList = new GardenList();
        testPlant1 = new Plant("bobby", "pothos", 5,
                        "direct light", "January 5");

        testPlant2 = new Plant("harold", "string of pearls", 5,
                "direct light", "January 5");

        testPlant3 = new Plant("sneepsnorp", "succulent", 5,
                "direct light", "January 5");

    }

    @Test
    void testAddPlantToGarden() {
        testGardenList.addPlantToGarden(testPlant1);
        assertTrue((testGardenList.getGardenList()).contains(testPlant1));
        assertEquals((testGardenList.getGardenList()).size(), 1);
    }

    @Test
    void testSizeOfGarden() {
        testGardenList.addPlantToGarden(testPlant1);
        assertEquals(testGardenList.sizeOfGarden(), 1);
        testGardenList.addPlantToGarden(testPlant1);
        testGardenList.addPlantToGarden(testPlant1);
        assertEquals(testGardenList.sizeOfGarden(), 3);
    }

    @Test
    void testRemovePlantFromGarden() {
        testGardenList.addPlantToGarden(testPlant1);
        testGardenList.addPlantToGarden(testPlant2);
        testGardenList.addPlantToGarden(testPlant3);
        testGardenList.removePlantFromGarden(testPlant1.getName());
        assertEquals(testGardenList.sizeOfGarden(), 2);
        testGardenList.removePlantFromGarden(testPlant3.getName());
        assertEquals(testGardenList.sizeOfGarden(), 1);
    }

    @Test
    void testEventLog() {
        testGardenList.addPlantToGarden(testPlant1);
        testGardenList.addPlantToGarden(testPlant2);
        testGardenList.addPlantToGarden(testPlant3);
        testGardenList.removePlantFromGarden(testPlant3.getName());
        testGardenList.addPlantToGarden(testPlant3);
        testGardenList.addPlantToGarden(new Plant("bobby", "uh",
                1, "uh", "uh"));
        //above should not be added to event log b/c same name as plant 1

        List<Event> l = new ArrayList<>();
        EventLog el = EventLog.getInstance();
        for (Event e : el) {
            l.add(e);
        }

        assertEquals(l.get(0).getDescription(), "bobby the pothos was added!");
        assertEquals(l.get(1).getDescription(), "harold the string of pearls was added!");
        assertEquals(l.get(2).getDescription(), "sneepsnorp the succulent was added!");
        assertEquals(l.get(3).getDescription(), "sneepsnorp the succulent was removed.");
        assertEquals(l.get(4).getDescription(), "sneepsnorp the succulent was added!");

    }


}
