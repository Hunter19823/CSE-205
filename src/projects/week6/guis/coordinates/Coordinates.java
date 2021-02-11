package projects.week6.guis.coordinates;
//********************************************************************
//  Coordinates.java       Java Foundations
//
//  Demonstrates mouse events.
//********************************************************************

import javax.swing.JFrame;

public class Coordinates
{
    //-----------------------------------------------------------------
    //  Creates and displays the application frame.
    //-----------------------------------------------------------------
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Coordinates");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(new CoordinatesPanel());

        frame.pack();
        frame.setVisible(true);
    }
}
