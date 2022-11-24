package ui;


import persistence.JsonReader;
import persistence.JsonWriter;

import model.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewPlantWindow extends GPlantApp {


    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    //private GardenList gardenList;


    JFrame newPlantFrame = new JFrame("new plant!");
    JPanel newPlantPanel = new JPanel();


    JComboBox plantTypeField;

    JTextField nameField;
    JTextField birthdayField;

    JLabel nameLabel;
    JLabel birthdayLabel;

    JLabel sameNameLabel;

    JButton addNewPlantButton;

    //add text fields and a drop down menu etc


    public NewPlantWindow() {

        newPlantPanel.setLayout(null);

        String[] plantTypeStrings = {"monstera", "pothos", "string of pearls", "succulent"};


        newPlantFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newPlantFrame.setSize(375, 220);
        newPlantFrame.getContentPane().setBackground(new Color(194, 190, 217));

        plantTypeField = new JComboBox(plantTypeStrings);
        plantTypeField.setBounds(10, 20, 200, 20);
        newPlantPanel.add(plantTypeField);

        nameLabel = new JLabel("enter name:");
        nameLabel.setBounds(10, 50, 80, 20);
        birthdayLabel = new JLabel("enter birthday");
        birthdayLabel.setBounds(10, 90, 80, 20);
        newPlantPanel.add(nameLabel);
        newPlantPanel.add(birthdayLabel);


        nameField = new JTextField(20);
        nameField.setBounds(100, 50, 200, 20);
        birthdayField = new JTextField(20);
        birthdayField.setBounds(100, 90, 200, 20);
        newPlantPanel.add(nameField);
        newPlantPanel.add(birthdayField);


        addNewPlantButton = new JButton("plant it!");
        addNewPlantButton.setBounds(125, 120, 100, 30);
        newPlantPanel.add(addNewPlantButton);

        addNewPlantButton.addActionListener(new ActionListener() {
            @Override


            public void actionPerformed(ActionEvent e) {

                //if (e.getSource() == addNewPlantButton) {
                String plantname = nameField.getText();
                String plantbday = birthdayField.getText();
                // 0 = monstera, 1 = pothos, 2 = string of pearls, 3 = succulent
                int plantType = plantTypeField.getSelectedIndex();

                //getGPlantApp().attemptAddPlant(name);
                //gardenList.addPlantToGarden(new Plant("bob", "monstera", 2, "uh", "nfdsifns"));

                if (getGPlantApp().getGardenList().getGardenList().size() != 0) {
                    for (Plant p : getGPlantApp().getGardenList().getGardenList()) {
                        //if (plantname.equals(p.getName())) {
                            sameNameLabel.setText("you already have a plant with this name!");
                            //return;
                        //} else {
                            newPlantAddToGarden(plantType, plantname, plantbday);
                            //addNewPlantScroll();
                            newPlantFrame.dispose();
                        }
                    //}

                } else {
                    newPlantAddToGarden(plantType, plantname, plantbday);
                    //addNewPlantScroll();
                    newPlantFrame.dispose();
                }


                System.out.println(getGPlantApp().getGardenList().getGardenList());
                //}

                //addButton(new JButton("plantname"));
                //scrollPanel.revalidate();
            }
        });

        sameNameLabel = new JLabel("");
        sameNameLabel.setBounds(65, 150, 300, 30);
        newPlantPanel.add(sameNameLabel);

        newPlantFrame.add(newPlantPanel);

        newPlantFrame.setVisible(true);

    }

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
}
