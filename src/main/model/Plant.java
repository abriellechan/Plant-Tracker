package model;

import org.json.JSONObject;
import persistence.Writable;

public class Plant implements Writable {

    private String name;
    private String plantType;
    private int daysBetweenWater;
    private String lightType;
    private String birthday;

    //REQUIRES: int daysBetweenWater > 0
    //EFFECTS: constructs a Plant
    public Plant(String name, String plantType, int daysBetweenWater, String lightType, String birthday) {
        this.name = name;
        this.plantType = plantType;
        this.daysBetweenWater = daysBetweenWater;
        this.lightType = lightType;
        this.birthday = birthday;
    }


    public String getName() {
        return name;
    }

    public String getPlantType() {
        return plantType;
    }

    public int getDaysBetweenWater() {
        return daysBetweenWater;
    }

    public String getLightType() {
        return lightType;
    }

    public String getBirthday() {
        return birthday;
    }

    //EFFECTS: changes name of plant
    public void changeName(String newname) {
        this.name = newname;
    }

    //EFFECTS: changes birthday of plant
    public void changeBirthday(String newbirthday) {
        this.birthday = newbirthday;
    }


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("plant type", plantType);
        json.put("days between water", daysBetweenWater);
        json.put("light type", lightType);
        json.put("birthday", birthday);
        return json;
    }

}
