package persistence;

import model.GardenList;
import model.Plant;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            GardenList gr = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyGardenList() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyGardenList.json");
        try {
            GardenList gl = reader.read();
            assertEquals(0, gl.sizeOfGarden());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralGardenList() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralGardenList.json");
        try {
            GardenList gl = reader.read();

            List<Plant> gardenlist = gl.getGardenList();
            assertEquals(2, gardenlist.size());

            checkPlant("bob", "monstera", 10, "indirect light",
                    "april 6", gardenlist.get(0));

            checkPlant("boop", "succulent", 21, "direct light",
                    "dec 29", gardenlist.get(1));

        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}