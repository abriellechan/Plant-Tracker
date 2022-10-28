package persistence;

import model.GardenList;
import model.Plant;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

//Sources: JsonSerializationDemo

// Represents a reader that reads gardenlist from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads gardenlist from file and returns it;
    // throws IOException if an error occurs reading data from file
    public GardenList read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseGardenList(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses gardenlist from JSON object and returns it
    private GardenList parseGardenList(JSONObject jsonObject) {
        //String name = jsonObject.getString("name");
        GardenList gl = new GardenList();
        addPlants(gl, jsonObject);
        return gl;
    }

    // MODIFIES: gl
    // EFFECTS: parses plants from JSON object and adds them to gardenlist
    private void addPlants(GardenList gl, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("gardenlist");
        for (Object json : jsonArray) {
            JSONObject nextThingy = (JSONObject) json;
            addPlant(gl, nextThingy);
        }
    }

    // MODIFIES: gl
    // EFFECTS: parses plant from JSON object and adds it to gardenlist
    private void addPlant(GardenList gl, JSONObject jsonObject) {

        String name = jsonObject.getString("name");
        String plantType = jsonObject.getString("plant type");
        int daysBetweenWater = jsonObject.getInt("days between water");
        String lightType = jsonObject.getString("light type");
        String birthday = jsonObject.getString("birthday");

        Plant plant = new Plant(name, plantType, daysBetweenWater, lightType, birthday);
        gl.addPlantToGarden(plant);
    }

}
