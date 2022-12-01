package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

public class GardenList implements Writable {

    private ArrayList<Plant> gardenList;

    //EFFECTS: constructs an empty garden list
    public GardenList() {
        gardenList = new ArrayList<Plant>();
    }

    //MODIFIES: this
    //EFFECTS: adds a plant to the Garden List
    public void addPlantToGarden(Plant p) {
        gardenList.add(p);
        EventLog.getInstance().logEvent(new Event(p.getName() + " the " + p.getPlantType() + " was added!"));
    }

    //MODIFIES: this
    //EFFECTS: removes a plant from the Garden List
    public void removePlantFromGarden(String name) {
        Plant oopsPlant = null;
        for (Plant plant : gardenList) {
            if ((plant.getName()).equals(name)) {
                oopsPlant = plant;
            }
        }
        gardenList.remove(oopsPlant);
        EventLog.getInstance().logEvent(new Event(oopsPlant.getName() + " the "
                + oopsPlant.getPlantType() + " was removed."));
    }


    //EFFECTS: takes in a name, returns plant with that name. If it doesn't exist, return null
    public Plant getPlantFromGarden(String name) {
        for (Plant plant : gardenList) {
            if ((plant.getName()).equals(name)) {
                return plant;
            }
        }
        return null;
    }

    public int sizeOfGarden() {
        return gardenList.size();
    }

    public ArrayList<Plant> getGardenList() {
        return gardenList;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("gardenlist", plantsToJson());
        return json;
    }

    // EFFECTS: returns things in this workroom as a JSON array
    // thingies
    private JSONArray plantsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Plant p : gardenList) {
            jsonArray.put(p.toJson());
        }
        return jsonArray;
    }


}
