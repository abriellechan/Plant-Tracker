package ui;

import model.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PlantApp {

    private Scanner input;
    private GardenList gardenList;

    public PlantApp() {
        runPlant();
    }

    private void runPlant() {
        boolean keepGoing = true;
        String command;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("quit")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nHappy Planting!");

    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        switch (command) {
            case "new":
                optionNewPlant();
                break;
            case "view":
                menuView();
                break;
            case "edit":
                menuEdit();
                break;
            default:
                System.out.println("select a listed option pls :>");
                break;
        }
    }

    private void optionNewPlant() {
        menuNewPlant();
        String command = input.next();
        processNewPlantCommand(command);
    }

    private void processNewPlantCommand(String command) {

        System.out.println("enter plant name: "); //pull stuff out into a new function.. and check if the user input dne
        String plantname = input.next();
        System.out.println("enter plant birthday: ");
        String plantbday = input.next();

        switch (command) {
            case "m":
                Plant mnewplant = new Monstera(plantname, plantbday);
                gardenList.addPlantToGarden(mnewplant);
                System.out.println("new monstera " + plantname + " created!");
                System.out.println(gardenList);
                break;

            case "p":
                Plant pnewplant = new Pothos(plantname, plantbday);
                gardenList.addPlantToGarden(pnewplant);
                System.out.println("new pothos " + plantname + " created!");
                break;

            case "sop":
                Plant sopnewplant = new StringOfPearls(plantname, plantbday);
                gardenList.addPlantToGarden(sopnewplant);
                System.out.println("new string of pearls " + plantname + " created!");
                break;

            case "s":
                Plant snewplant = new Succulent(plantname, plantbday);
                gardenList.addPlantToGarden(snewplant);
                System.out.println("new succulent " + plantname + " created!");
                break;

            default:
                System.out.println("select a listed option pls :>");
                break;


        }
    }

    private void init() {

        input = new Scanner(System.in);
        input.useDelimiter("\n");

        gardenList = new GardenList();
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tnew -> create a new plant!");
        System.out.println("\tview -> view all your plants");
        System.out.println("\tedit -> edit your plant's info");
        System.out.println("\tquit -> quit :>");
    }

    //TODO
    void menuNewPlant() {
        System.out.println("\nwhat plant would you like to add? Choose from: ");
        System.out.println("\tm -> Monstera");
        System.out.println("\tp -> Pothos");
        System.out.println("\tsop -> String of Pearls");
        System.out.println("\ts -> Succulent");
    }


    //TODO
    //EFFECTS: prints out names and types of the plants the user owns
    void menuView() {
        System.out.println("\nwhat plant would you like to view? type name below: \n");
        for (Plant p : gardenList.getGardenList()) {
            System.out.println(p.getName());

        }
    }

    //TODO
    void doView() {
        //print a list of the plants that they have
        // example:
        // "bobby" the Monstera
        // "abby" the Pothos
        // "fluffy" the String of Pearls
        //then prompt the user for the name of the plant they wish to view more closely
        //then print out the info of that plant
        //example
        // fluffy!
        // plant: String of Pearls
        // days needed between watering: 5
        // birthday: april 3
    }

    //TODO
    void menuEdit() {
    }

    //TODO
    void doEdit() {
        //display same list of plants
        //prompt user for which plant they want to edit
        //display the info of that plant (like above)
        //prompt user for keyword of what they want to change, example: "birthday"
        //prompt the user for the new edit
        //call the edit function in model.Plant
        //print a line like "bobby's birthday was changed to august 6!"
    }


}
