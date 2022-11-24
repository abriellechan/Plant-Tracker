package ui;

import model.GardenList;

import persistence.JsonReader;
import persistence.JsonWriter;

import model.*;

import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GPlantApp extends JFrame {

    public static final int WIDTH = 500;
    public static final int HEIGHT = 300;

    private GardenList gardenList;

    private JScrollPane scrollPane;
    private JPanel scrollPanel;
    private JButton btnAddPlant;
    private JButton btnSave;
    private JButton btnLoad;
    private JButton btnDel;
    private JLabel welcomeLabel;
    private JLabel infoLabel;

    private Boolean wasLoadPressed;

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private JDialog newPlantWindow;
    private JDialog displayPlantInfo;

    private Boolean deleting;

    private Color colouruno = new Color(204,213,174);
    private Color colourdos = new Color(233, 237, 201);
    private Color colourtres = new Color(254, 250, 224);
    private Color colourquatros = new Color(250, 237, 205);
    private Color colourcinq = new Color(221, 184, 146);


    private static final String JSON_STORE = "./data/gardenlist.json";

    //MODIFIES: this
    //EFFECTS: creates GPLantApp frame
    public GPlantApp() {
        super("Plant Tracker");
        //this.setLayout(new BorderLayout());
        this.setLayout(new GridLayout(5, 1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setVisible(true);
        init();
    }

    //EFFECTS: initializes needed variables and calls function to begin creating/displaying menus
    public void init() {

        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        gardenList = new GardenList();
        runPlantTracker();
        wasLoadPressed = false;
        deleting = false;
    }

    //EFFECTS: runs function to start showing first menu
    private void runPlantTracker() {
        firstMenu();
    }

    //EFFECTS: runs function to display components
    private void firstMenu() {
        firstMenuComponents();
    }

    //MODIFIES: this
    //EFFECTS: creates components for main menu
    private void firstMenuComponents() {
        scrollPanel = new JPanel();
        scrollPanel.setSize(new Dimension(300, HEIGHT / 3));
        scrollPane = new JScrollPane(scrollPanel);
        scrollPane.setSize(300, HEIGHT / 3);
        btnAddPlant = new JButton("new plant!");
        btnSave = new JButton("save");
        btnLoad = new JButton("load");
        btnDel = new JButton("delete plant");

        welcomeLabel = new JLabel("                      welcome to plant tracker!");
        welcomeLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
        welcomeLabel.setSize(WIDTH, HEIGHT / 6);

        infoLabel = new JLabel("");
        infoLabel.setSize(WIDTH, HEIGHT / 7);

        firstMenuComponentsActListeners();
    }


    //EFFECTS: creates action listeners for each button
    private void firstMenuComponentsActListeners() {
        btnAddPlant.addActionListener(e -> {
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

        firstMenuComponentsCreateandShow();
    }

    //MODIFIES: this
    //EFFECTS: displays components for main menu
    private void firstMenuComponentsCreateandShow() {

        JPanel addDelRow = new JPanel();
        addDelRow.add(btnAddPlant);
        addDelRow.add(btnDel);
        addDelRow.setSize(WIDTH, HEIGHT / 8);

        JPanel infoLabelRow = new JPanel();
        infoLabelRow.add(infoLabel);
        infoLabelRow.setSize(WIDTH, HEIGHT / 8);

        JPanel saveLoadRow = new JPanel();
        saveLoadRow.add(btnSave);
        saveLoadRow.add(btnLoad);
        saveLoadRow.setSize(WIDTH, HEIGHT / 8);

        welcomeLabel.setBackground(colouruno);
        welcomeLabel.setOpaque(true);
        scrollPane.getHorizontalScrollBar().setBackground(colourdos);
        scrollPane.getViewport().setBackground(colourdos);
        addDelRow.setBackground(colourtres);
        infoLabelRow.setBackground(colourquatros);
        saveLoadRow.setBackground(colourcinq);

        this.add(welcomeLabel);
        this.add(scrollPane);
        this.add(addDelRow);
        this.add(infoLabelRow);
        this.add(saveLoadRow);
    }

    //MODIFIES: this
    //EFFECTS: creates Dialog box for the 'new plant' popup
    private void popNewPlantWindow() {
        newPlantWindow = new JDialog(this, "new plant!", true);
        newPlantWindow.setLayout(null);
        newPlantWindow.setSize(375, 220);
        newPlantWindow.getContentPane().setBackground(colourdos);
        popNewPlantButtons();

    }

    //MODIFIES: this
    //EFFECTS: creates/displays 'new plant' pop up components
    private void popNewPlantButtons() {
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
        sameNameLabel.setBounds(70, 150, 300, 30);
        newPlantWindow.add(sameNameLabel);

        popNewPlantActListener(plantItButton, nameField, birthdayField, plantTypeField, sameNameLabel);
    }

    //MODIFIES: this
    //EFFECTS: creates action listener for the 'plant it!' button on the 'new plant' menu
    private void popNewPlantActListener(JButton plantItButton, JTextField nameField, JTextField birthdayField,
                                        JComboBox plantTypeField, JLabel sameNameLabel) {
        plantItButton.addActionListener(e -> {

            String plantname = nameField.getText();
            String plantbday = birthdayField.getText();
            int plantType = plantTypeField.getSelectedIndex();

            if (gardenList.getGardenList().size() != 0) {
                for (Plant p : getGPlantApp().getGardenList().getGardenList()) {
                    if (plantname.equals(p.getName())) {
                        sameNameLabel.setText("you already have a plant with this name!");
                        return;
                    } else {
                        newPlantAddToGarden(plantType, plantname, plantbday);

                        displayCutePlant();
                        return;
                    }
                }

            } else {
                newPlantAddToGarden(plantType, plantname, plantbday);
                displayCutePlant();
                return;
            }
        });
        newPlantWindow.setVisible(true);
    }

    //MODIFIES: this
    //EFFECTS: displays the popup gif animation when plant is successfully created (when 'plant it!' is pressed)
    private void displayCutePlant() {

        newPlantWindow.dispose();

        JDialog cutePlant = new JDialog(this, "wow!", true);
        cutePlant.setSize(200, 200);
        JLabel cutePlantLabel = new JLabel(new
                ImageIcon("C:\\Users\\User\\Desktop\\UBC\\CPSC 210\\proj\\src\\main\\ui\\cuteplant.gif"));
        cutePlantLabel.setSize(834, 839);
        cutePlantLabel.setBounds(0, 0, 99, 99);
        cutePlant.add(cutePlantLabel);

        Timer timer = new Timer(800, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cutePlant.dispose();
            }
        });

        timer.setRepeats(false);
        timer.start();

        cutePlant.setVisible(true);


    }

    //MODIFIES: gardenList
    //EFFECTS: adds plant to garden (according to selected type)
    public void newPlantAddToGarden(int plantType, String plantname, String plantbday) {
        switch (plantType) {
            case 0:
                Monstera mnewplant = new Monstera(plantname, plantbday);
                newPlantButtonActListen(mnewplant, "monstera", plantname);
                break;

            case 1:
                Pothos pnewplant = new Pothos(plantname, plantbday);
                newPlantButtonActListen(pnewplant, "pothos", plantname);
                break;

            case 2:
                StringOfPearls sopnewplant = new StringOfPearls(plantname, plantbday);
                newPlantButtonActListen(sopnewplant, "string of pearls", plantname);
                break;

            default:
                Succulent snewplant = new Succulent(plantname, plantbday);
                newPlantButtonActListen(snewplant, "succulent", plantname);
                break;
        }

    }

    //MODIFIES: this
    //EFFECTS: adds button for the new plant as well as creates action listener
    public void newPlantButtonActListen(Plant newplant, String type, String plantname) {
        gardenList.addPlantToGarden(newplant);

        for (Plant p : gardenList.getGardenList()) {
            System.out.println("THIS IS WHAT IS IN LIST " + p.getName() + " END");
        }

        JButton newButton = new JButton(newplant.getName());
        scrollPanel.add(newButton);
        newButton.addActionListener(e -> {

            if (!deleting) {
                popDisplayPlantInfo(newButton.getText());
            } else {
                System.out.println("deleting plant");
                gardenList.removePlantFromGarden(newButton.getText());
                newButton.setVisible(false);
                infoLabel.setText("");
                deleting = false;
            }

        });
        scrollPanel.revalidate();
        System.out.println("new " + type + " " + plantname + " created!");
    }

    //EFFECTS: creates Dialog to display plant info
    public void popDisplayPlantInfo(String plantname) {
        Plant clickedPlant = gardenList.getPlantFromGarden(plantname);
        displayPlantInfo = new JDialog(this, "plant info!", true);
        popDisplayPlantInfoButtons(clickedPlant);
    }

    //MODIFIES: this
    //EFFECTS: creates/displays plant info components
    private void popDisplayPlantInfoButtons(Plant clickedPlant) {
        displayPlantInfo.setLayout(new GridLayout(6, 1));
        displayPlantInfo.setSize(500, 500);

        JLabel nameLabel = new JLabel("             " + clickedPlant.getName());
        nameLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 20));

        nameLabel.setBounds(10, 100, 80, 20);
        displayPlantInfo.add(nameLabel);

        JLabel typeLabel = new JLabel("            type: " + clickedPlant.getPlantType());
        nameLabel.setBounds(10, 75, 80, 20);
        displayPlantInfo.add(typeLabel);

        JLabel birthdayLabel = new JLabel("            birthday: " + clickedPlant.getBirthday());
        nameLabel.setBounds(10, 95, 80, 20);
        displayPlantInfo.add(birthdayLabel);

        JLabel daysBetweenWaterLabel = new
                JLabel("            days between water: " + clickedPlant.getDaysBetweenWater());
        nameLabel.setBounds(10, 115, 80, 20);
        displayPlantInfo.add(daysBetweenWaterLabel);

        JLabel lightTypeLabel = new JLabel("            light type: " + clickedPlant.getLightType());
        nameLabel.setBounds(10, 135, 80, 20);
        displayPlantInfo.add(lightTypeLabel);

        bob(clickedPlant);
    }

    //MODIFIES: this
    //EFFECTS: :) displays bob photo in info when the plant name includes 'bob'
    public void bob(Plant clickedPlant) {
        if (clickedPlant.getName().contains("bob")) {
            JLabel bob = new JLabel(new
                    ImageIcon("C:\\Users\\User\\Desktop\\UBC\\CPSC 210\\proj\\src\\main\\ui\\bob.jpg"));
            bob.setSize(150, 160);
            displayPlantInfo.add(bob);
        }

        displayPlantInfo.setVisible(true);
    }

    //MODIFIES: this
    //EFFECTS: changes text label on main menu and sets deleting to true
    public void pressDelPlant() {
        infoLabel.setText("please click the plant you would like to delete above");
        deleting = true;

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

    // EFFECTS: loads workroom from file
    public void loadGardenList() {
        try {
            gardenList = jsonReader.read();
            //System.out.println("Loaded your garden from " + JSON_STORE);
            if (!wasLoadPressed) {
                loadPlantButtons();
            } else {
                btnLoad.setVisible(false);
            }
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    //MODIFIES: this
    //EFFECTS: adds buttons for loaded plants to main menu
    public void loadPlantButtons() {
        for (Plant p : gardenList.getGardenList()) {
            JButton newButton = new JButton(p.getName());
            scrollPanel.add(newButton);
            newButton.addActionListener(e -> {
                if (!deleting) {
                    popDisplayPlantInfo(newButton.getText());
                } else {
                    gardenList.removePlantFromGarden(newButton.getText());
                    newButton.setVisible(false);
                    infoLabel.setText("");
                    deleting = false;
                }
            });
            scrollPanel.revalidate();
        }
        wasLoadPressed = true;
    }

    public GPlantApp getGPlantApp() {
        return this;
    }

    public GardenList getGardenList() {
        return gardenList;
    }

}
