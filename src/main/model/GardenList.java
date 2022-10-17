package model;

import java.util.ArrayList;
import java.util.List;

public class GardenList {

    private ArrayList<Plant> gardenList;

    public GardenList() {
        gardenList = new ArrayList<Plant>();
    }

    public void addPlantToGarden(Plant p) {
        gardenList.add(p);
    }

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
