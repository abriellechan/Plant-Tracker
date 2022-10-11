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

    public int sizeOfGarden() {
        return gardenList.size();
    }

    public ArrayList<Plant> getGardenList() {
        return gardenList;
    }

}
