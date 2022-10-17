package model;

import java.util.ArrayList;
import java.util.List;

public class GardenList {

    private ArrayList<Plant> gardenList;

    public GardenList() {
        gardenList = new ArrayList<Plant>();
    }

    //MODIFIES: this
    //EFFECTS: adds a plant to the Garden List
    public void addPlantToGarden(Plant p) {
        gardenList.add(p);
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
    }


    public int sizeOfGarden() {
        return gardenList.size();
    }

    public ArrayList<Plant> getGardenList() {
        return gardenList;
    }


}
