package persistence;

import model.GardenList;
import model.Plant;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
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

    // EFFECTS: parses workroom from JSON object and returns it
    private GardenList parseGardenList(JSONObject jsonObject) {
        //String name = jsonObject.getString("name");
        GardenList gr = new GardenList();
        addPlants(gr, jsonObject);
        return gr;
    }

    // MODIFIES: wr
    // EFFECTS: parses plants from JSON object and adds them to gardenlist
    private void addPlants(GardenList gr, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("gardenlist");
        for (Object json : jsonArray) {
            JSONObject nextThingy = (JSONObject) json;
            addPlant(gr, nextThingy);
        }
    }

    // MODIFIES: gr
    // EFFECTS: parses plant from JSON object and adds it to gardenlist
    private void addPlant(GardenList gr, JSONObject jsonObject) {

        String name = jsonObject.getString("name");
        String plantType = jsonObject.getString("plant type");
        int daysBetweenWater = jsonObject.getInt("days between water");
        String lightType = jsonObject.getString("light type");
        String birthday = jsonObject.getString("birthday");

        Plant plant = new Plant(name, plantType, daysBetweenWater, lightType, birthday);
        gr.addPlantToGarden(plant);
    }

}
