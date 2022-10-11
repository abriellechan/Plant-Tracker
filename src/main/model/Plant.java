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

    public int changeDaysBetweenWater(int newdays) {
        return this.daysBetweenWater = newdays;
    }

    public String changeLightType(String newlighttype) {
        return this.lightType = newlighttype;
    }

    public String changeBirthday(String newbirthday) {
        return this.birthday = newbirthday;
    }

    /*
    public String printInfo(){
        System.out.println(this.name"," this.daysBetweenWater "," this.lightType "," this.birthday);
    }

     */

}
