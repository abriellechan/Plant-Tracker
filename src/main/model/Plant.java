package model;

public class Plant {

    private String name;
    private int daysBetweenWater;
    private String lightType;
    private String birthday;

    //CONSTRUCTOR
    public Plant(String name, int daysBetweenWater, String lightType, String birthday) {
        this.name = name;
        this.daysBetweenWater = daysBetweenWater;
        this.lightType = lightType;
        this.birthday = birthday;
    }


    public String getName() {
        return name;
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


    public String changeName(String newname) {

        return this.name = newname;
    }

}
