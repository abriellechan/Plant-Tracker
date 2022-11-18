package ui;

import model.GardenList;
import org.w3c.dom.ls.LSOutput;
import persistence.JsonReader;
import persistence.JsonWriter;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GPlantApp extends JFrame {


    //private JPanel gPlantApp;

    private GardenList gardenList;

    private JScrollPane scrollPane;
    private JPanel scrollPanel;
    private JButton btnAddPlant;
    private JButton btnSave;
    private JButton btnLoad;
    private JButton btnDel;

    private Boolean wasLoadPressed;

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private JDialog newPlantWindow;
    private JDialog displayPlantInfo;


    private static final String JSON_STORE = "./data/gardenlist.json";


    private boolean isNewPlantWindow = false;

    public GPlantApp() {
        super("Plant Tracker");
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 200);
        this.setVisible(true);
        init();
    }

    public static void makeAndShowGUI() {

        //JFrame frame = new JFrame("My Garden");
        /*
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.add(new GPlantApp());
        frame.getContentPane().setBackground(new Color(194, 190, 217));
        frame.setVisible(true);



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.add(new GPlantApp());
        frame.getContentPane().setBackground(new Color(194, 190, 217));
        frame.setVisible(true);

         */
    }

    public void init() {

        System.out.println("iniialize");
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        gardenList = new GardenList();
        runPlantTracker();
        wasLoadPressed = false;



        /*
        scrollPanel = new JPanel();
        scrollPanel.setSize(new Dimension(300, 300));
        scrollPane = new JScrollPane(scrollPanel);
        btnAddPlant = new JButton("new plant!");
        btnSave = new JButton("save");
        btnLoad = new JButton("load");
        btnDel = new JButton("delete plant");

        btnAddPlant.addActionListener(e -> {
            NewPlantWindow newPlantWindow = new NewPlantWindow();
            //popNewPlantWindow();
        });

        btnSave.addActionListener(e -> {
            saveGardenList();
        });

        btnLoad.addActionListener(e -> {
            loadGardenList();
        });

        btnDel.addActionListener(e -> {
            pressDelPlant();
        });

        add(scrollPane, BorderLayout.CENTER);
        add(btnAddPlant, BorderLayout.SOUTH);
        add(btnSave, BorderLayout.WEST);
        add(btnLoad, BorderLayout.EAST);

         */
    }
    /*
    public void popNewPlantWindow(){

        JDialog newPlantWindow = new JDialog(this, "new plant!", true);

    }

     */

    private void runPlantTracker() {
        firstMenu();
    }

    private void firstMenu() {
        firstMenuComponents();
    }

    private void firstMenuComponents() {
        scrollPanel = new JPanel();
        scrollPanel.setSize(new Dimension(300, 300));
        scrollPane = new JScrollPane(scrollPanel);
        btnAddPlant = new JButton("new plant!");
        btnSave = new JButton("save");
        btnLoad = new JButton("load");
        btnDel = new JButton("delete plant");

        btnAddPlant.addActionListener(e -> {
            //NewPlantWindow newPlantWindow = new NewPlantWindow();
            popNewPlantWindow();
        });

        btnSave.addActionListener(e -> {
            saveGardenList();
        });

        btnLoad.addActionListener(e -> {
            loadGardenList();
        });

        btnDel.addActionListener(e -> {
            pressDelPlant();
        });

        add(scrollPane, BorderLayout.CENTER);
        add(btnAddPlant, BorderLayout.SOUTH);
        add(btnSave, BorderLayout.WEST);
        add(btnLoad, BorderLayout.EAST);
    }

    private void popNewPlantWindow() {
        newPlantWindow = new JDialog(this, "new plant!", true);
        popNewPlantButtons();

    }

    private void popNewPlantButtons() {
        newPlantWindow.setLayout(null);
        newPlantWindow.setSize(375, 220);

        String[] plantTypeStrings = {"monstera", "pothos", "string of pearls", "succulent"};
        JComboBox plantTypeField = new JComboBox(plantTypeStrings);
        plantTypeField.setBounds(10, 20, 200, 20);
        newPlantWindow.add(plantTypeField);

        JTextField nameField = new JTextField(20);
        nameField.setBounds(100, 50, 200, 20);
        newPlantWindow.add(nameField);

        JTextField birthdayField = new JTextField(20);
        birthdayField.setBounds(100, 90, 200, 20);
        newPlantWindow.add(birthdayField);

        JLabel nameLabel = new JLabel("enter name:");
        nameLabel.setBounds(10, 50, 80, 20);
        newPlantWindow.add(nameLabel);

        JLabel birthdayLabel = new JLabel("enter birthday:");
        birthdayLabel.setBounds(10, 90, 80, 20);
        newPlantWindow.add(birthdayLabel);

        JButton plantItButton = new JButton("plant it <3");
        plantItButton.setBounds(125, 120, 100, 30);
        newPlantWindow.add(plantItButton);

        JLabel sameNameLabel = new JLabel("");


        plantItButton.addActionListener(e -> {

            String plantname = nameField.getText();
            String plantbday = birthdayField.getText();
            // 0 = monstera, 1 = pothos, 2 = string of pearls, 3 = succulent
            int plantType = plantTypeField.getSelectedIndex();

            if (gardenList.getGardenList().size() != 0) {
                for (Plant p : getGPlantApp().getGardenList().getGardenList()) {
                    if (plantname.equals(p.getName())) {
                        sameNameLabel.setText("you already have a plant with this name!");
                        return;
                    } else {
                        newPlantWindowAddPlant(plantType, plantname, plantbday);
                        //addNewPlantScroll();
                        newPlantWindow.dispose();
                        return;
                    }
                }

            } else {
                newPlantWindowAddPlant(plantType, plantname, plantbday);
                //addNewPlantScroll();
                newPlantWindow.dispose();
                return;
            }


            System.out.println(getGPlantApp().getGardenList().getGardenList());
            //}

            //addButton(new JButton("plantname"));
            //scrollPanel.revalidate();


        });
        newPlantWindow.setVisible(true);

    }

    //TODO split it up
    private void plantItButtonAction() {

    }

    public void newPlantWindowAddPlant(int plantType, String plantname, String plantbday) {
        switch (plantType) {
            case 0:
                Monstera mnewplant = new Monstera(plantname, plantbday);
                addPlantToTheGarden(mnewplant, "monstera", plantname);
                break;

            case 1:
                Pothos pnewplant = new Pothos(plantname, plantbday);
                addPlantToTheGarden(pnewplant, "pothos", plantname);
                break;

            case 2:
                StringOfPearls sopnewplant = new StringOfPearls(plantname, plantbday);
                addPlantToTheGarden(sopnewplant, "string of pearls", plantname);
                break;

            default:
                Succulent snewplant = new Succulent(plantname, plantbday);
                addPlantToTheGarden(snewplant, "succulent", plantname);
                break;
        }

    }


    //called from the add plant window popup
    // adds the plant that was passed from the popup to the gardenList, as well as
    public void addPlantToTheGarden(Plant newplant, String type, String plantname) {
        gardenList.addPlantToGarden(newplant);

        for (Plant p : gardenList.getGardenList()) {
            System.out.println("THIS IS WHAT IS IN LIST " + p.getName() + " END");
            //scrollPanel.add(new JButton(p.getName()));
            //scrollPanel.revalidate();
        }

        JButton newButton = new JButton(newplant.getName());
        scrollPanel.add(newButton);
        newButton.addActionListener(e -> {
            System.out.println("THE NAME IS " + newButton.getText());
            popDisplayPlantInfo(newButton.getText());
        });
        scrollPanel.revalidate();
        System.out.println("new " + type + " " + plantname + " created!");
    }

    public void popDisplayPlantInfo(String plantname) {
        Plant clickedPlant = gardenList.getPlantFromGarden(plantname);
        displayPlantInfo = new JDialog(this, "new plant!", true);
        popDisplayPlantInfoButtons(clickedPlant);
    }

    private void popDisplayPlantInfoButtons(Plant clickedPlant) {
        displayPlantInfo.setLayout(null);
        displayPlantInfo.setSize(375, 220);

        JLabel nameLabel = new JLabel("name: " + clickedPlant.getName());
        nameLabel.setBounds(10, 50, 200, 20);
        displayPlantInfo.add(nameLabel);

        JLabel typeLabel = new JLabel("type: " + clickedPlant.getPlantType());
        nameLabel.setBounds(10, 70, 200, 20);
        displayPlantInfo.add(typeLabel);

        JLabel birthdayLabel = new JLabel("birthday: " + clickedPlant.getBirthday());
        nameLabel.setBounds(10, 90, 200, 20);
        displayPlantInfo.add(birthdayLabel);

        JLabel daysBetweenWaterLabel = new JLabel("days between water: " + clickedPlant.getDaysBetweenWater());
        nameLabel.setBounds(10, 110, 200, 20);
        displayPlantInfo.add(daysBetweenWaterLabel);

        JLabel lightTypeLabel = new JLabel("light type: " + clickedPlant.getLightType());
        nameLabel.setBounds(10, 130, 200, 20);
        displayPlantInfo.add(lightTypeLabel);

        displayPlantInfo.setVisible(true);
    }

    //TODO
    public void pressDelPlant() {
    }

    // EFFECTS: saves the workroom to file
    public void saveGardenList() {
        try {
            jsonWriter.open();
            jsonWriter.write(gardenList);
            jsonWriter.close();
            System.out.println("saved your garden to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads workroom from file
    public void loadGardenList() {
        try {
            gardenList = jsonReader.read();
            System.out.println("Loaded your garden from " + JSON_STORE);
            if (!wasLoadPressed) {
                for (Plant p : gardenList.getGardenList()) {
                    JButton newButton = new JButton(p.getName());
                    scrollPanel.add(newButton);
                    newButton.addActionListener(e -> {
                        System.out.println("THE NAME IS " + newButton.getText());
                        popDisplayPlantInfo(newButton.getText());
                    });
                    scrollPanel.revalidate();
                }
                wasLoadPressed = true;
            } else {
                btnLoad.disable();
            }
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    public GPlantApp getGPlantApp() {
        return this;
    }

    public GardenList getGardenList() {
        return gardenList;
    }

}
