package persistence;

import model.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkPlant(String name, String plantType, int daysBetweenWater, String lightType, String birthday, Plant plant) {
        assertEquals(name, plant.getName());
        assertEquals(plantType, plant.getPlantType());
        assertEquals(daysBetweenWater, plant.getDaysBetweenWater());
        assertEquals(lightType, plant.getLightType());
        assertEquals(birthday, plant.getBirthday());
    }
}
