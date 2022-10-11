package model;

import java.util.ArrayList;
import java.util.List;

public class GardenList {

    private ArrayList gardenList;

    public GardenList() {
        gardenList = new ArrayList<Plant>();
    }


    public void addPlantToGarden(Plant p) {
        gardenList.add(p);
    }

}
