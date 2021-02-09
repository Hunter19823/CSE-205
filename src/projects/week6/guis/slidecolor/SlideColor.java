package projects.week6.guis.slidecolor;
//********************************************************************
//  SlideColor.java       Java Foundations
//
//  Demonstrates the use slider components.
//********************************************************************

import javax.swing.*;

public class SlideColor {
    //-----------------------------------------------------------------
    //  Presents a frame with a control panel and a panel that
    //  changes color as the sliders are adjusted.
    //-----------------------------------------------------------------
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Slide Colors");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(new SlideColorPanel());

        frame.pack();
        frame.setVisible(true);
    }

}
