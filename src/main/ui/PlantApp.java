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
        checkDuplicateNameCommand(command);
    }


    private void checkDuplicateNameCommand(String command) {

        if (command.equals("m") || command.equals("p") || command.equals("sop") || command.equals("s")) {
            System.out.println("enter plant name: ");
            //pull stuff out into a new function.. and check if the user input dne
            String plantname = input.next();

            if (gardenList.sizeOfGarden() == 0) {
                processNewPlantCommand(command, plantname);
            } else {
                for (Plant p : gardenList.getGardenList()) {
                    if (plantname.equals(p.getName())) {
                        System.out.println("please pick a name that hasn't been used already!");
                    } else {
                        processNewPlantCommand(command, plantname);
                    }
                }
            }
        } else {
            System.out.println("select a listed option pls :>");
        }
    }


    private void processNewPlantCommand(String command, String plantname) {

        System.out.println("enter plant birthday: ");
        String plantbday = input.next();

        switch (command) {
            case "m":
                Monstera mnewplant = new Monstera(plantname, plantbday);
                gardenList.addPlantToGarden(mnewplant);
                System.out.println("new monstera " + plantname + " created!");
                break;

            case "p":
                Pothos pnewplant = new Pothos(plantname, plantbday);
                gardenList.addPlantToGarden(pnewplant);
                System.out.println("new pothos " + plantname + " created!");
                break;

            case "sop":
                StringOfPearls sopnewplant = new StringOfPearls(plantname, plantbday);
                gardenList.addPlantToGarden(sopnewplant);
                System.out.println("new string of pearls " + plantname + " created!");
                break;

            default:
                Succulent snewplant = new Succulent(plantname, plantbday);
                gardenList.addPlantToGarden(snewplant);
                System.out.println("new succulent " + plantname + " created!");
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

        String searchplant = input.next();

        for (Plant p : gardenList.getGardenList()) {
            if (searchplant.equals(p.getName())) {
                System.out.println(p.getName() + " is a " + p.getPlantType());
                System.out.println("it needs " + p.getDaysBetweenWater() + " days between water cycles");
                System.out.println("it needs " + p.getLightType() + " to thrive :)");
                System.out.println("and was born on " + p.getBirthday());
            }
        }
    }


    //TODO
    void menuEdit() {
        System.out.println("which plant would you like to edit? type name below: ");
        for (Plant p : gardenList.getGardenList()) {
            System.out.println(p.getName());
        }

        String searchplant = input.next();
        for (Plant p : gardenList.getGardenList()) {
            if (searchplant.equals(p.getName())) {
                System.out.println("which field would you like to edit? ");
                System.out.println("\nn -> name");
                System.out.println("\nb -> birthday");

                String editfield = input.next();
                if (editfield.equals("n")) {
                    System.out.println("what would you like to name the plant? ");
                    String newname = input.next();
                    p.changeName(newname);
                    System.out.println("your plant was renamed to " + newname + "!");
                } else if (editfield.equals("b")) {
                    System.out.println("when was your plant born? ");
                    String newbday = input.next();
                    p.changeBirthday(newbday);
                    System.out.println("your plant's new birthday is " + newbday + "!");
                }
            }
        }
        System.out.println("please pick an existing plant!");
    }


}
