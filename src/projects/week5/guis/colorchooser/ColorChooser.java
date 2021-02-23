package projects.week5.guis.colorchooser;

import javax.swing.*;
import java.io.File;
import java.util.Scanner;

/**
 * Author: Hunter S.
 */
public class ColorChooser {
    public static void main(String[] args)
    {

        JFrame frame = new JFrame("Display File");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JColorChooser chooser = new JColorChooser();

        frame.getContentPane().add(chooser);
        frame.pack();
        frame.setVisible(true);
    }
}
