package ui;

import model.Plant;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;



public class PlantApp {

    private Scanner input;
    private ArrayList garden = new ArrayList();


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
                doNewPlant();
                break;
            case "view":
                doView();
                break;
            case "edit":
                doEdit();
                break;
            default:
                System.out.println("select a listed option pls :>");
                break;
        }
    }

    private void init() {

        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tneq -> create a new plant!");
        System.out.println("\tview -> view all your plants");
        System.out.println("\tedit -> edit your plant's info");
        System.out.println("\tquit -> quit :>");
    }

    //TODO
    void doNewPlant() {
        //prompt user for which plant they want to add
        //prompt user for the name and birthday of their new plant
        //using the info above, call constructor for plant and add it to the list of plants
        //print a statement like "bobby" was added to your garden!

    }

    //TODO
    //EFFECTS: prints out names and types of the plants the user owns
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
