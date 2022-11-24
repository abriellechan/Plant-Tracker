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
                new GPlantApp();
            }
        });
    }
}