package ui;

import model.Plant;
import org.w3c.dom.ls.LSOutput;

import java.util.Locale;
import java.util.Scanner;


public class PlantApp {
    private Scanner input;


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
            case "new plant":
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

        /*

        DO I NEED THIS? (made new classes for each of the plants instead?)

        Plant monstera = new Plant("blank", 10, "indirect light", "blank");
        Plant pothos =
                new Plant("blank", 7, "medium light", "blank");
        Plant stringofpearls =
                new Plant("blank", 14, "indirect light", "blank");
        Plant succulent = new Plant("blank", 21, "direct light", "blank");
        Plant aloevera = new Plant("blank", 21, "direct light", "blank");

         */

        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tnew plant -> create a new plant!");
        System.out.println("\tview -> view all your plants");
        System.out.println("\tedit -> edit your plant's info");
        System.out.println("\tquit -> quit :>");
    }

    //TODO
    void doNewPlant() {

    }

    //TODO
    void doView() {

    }

    //TODO
    void doEdit() {

    }


}
