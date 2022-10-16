package model;

public class Plant {

    private String name;
    private String plantType;
    private int daysBetweenWater;
    private String lightType;
    private String birthday;

    //CONSTRUCTOR
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


    public void changeName(String newname) {
        this.name = newname;
    }

    public void changeBirthday(String newbirthday) {
        this.birthday = newbirthday;
    }


}
