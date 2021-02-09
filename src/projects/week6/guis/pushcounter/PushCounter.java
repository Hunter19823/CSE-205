package projects.week6.guis.pushcounter;

import javax.swing.*;

public class PushCounter {
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Push Counter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PushCounterPanel panel = new PushCounterPanel();
        frame.getContentPane().add(panel);

        frame.pack();
        frame.setVisible(true);
    }
}
