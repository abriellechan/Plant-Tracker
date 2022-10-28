package persistence;

import model.GardenList;
import model.Plant;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest extends JsonTest {
    //NOTE TO CPSC 210 STUDENTS: the strategy in designing tests for the JsonWriter is to
    //write data to a file and then use the reader to read it back in and check that we
    //read in a copy of what was written out.

    @Test
    void testWriterInvalidFile() {
        try {
            GardenList gl = new GardenList();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyGardenList() {
        try {
            GardenList gl = new GardenList();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyGardenList.json");
            writer.open();
            writer.write(gl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyGardenList.json");
            gl = reader.read();
            assertEquals(0, gl.sizeOfGarden());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralGardenList() {
        try {
            GardenList gl = new GardenList();

            gl.addPlantToGarden(new Plant("bob", "string of pearls", 14,
                    "indirect light", "jan 1"));

            gl.addPlantToGarden(new Plant("lob", "monstera", 10,
                    "indirect light", "jan 2"));

            JsonWriter writer = new JsonWriter("./data/testWriterGeneralGardenList.json");
            writer.open();
            writer.write(gl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralGardenList.json");
            gl = reader.read();
            List<Plant> gardenlist = gl.getGardenList();
            assertEquals(2, gardenlist.size());

            checkPlant("bob", "string of pearls", 14,
                    "indirect light", "jan 1", gardenlist.get(0));

            checkPlant("lob", "monstera", 10,
                    "indirect light", "jan 2", gardenlist.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}