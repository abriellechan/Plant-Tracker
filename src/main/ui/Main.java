package ui;

import java.io.FileNotFoundException;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/*
public class Main {
    public static void main(String[] args) {
        try {
            new PlantApp();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found :<");
        }

    }
}
 */

public class Main {
    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                /*

                JFrame frame = new JFrame("My Garden");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new GPlantApp());
                frame.setVisible(true);
                frame.getContentPane().setBackground(new Color(194, 190, 217));
                 */

                //GPlantApp.makeAndShowGUI();
                new GPlantApp();
            }
        });
    }
}