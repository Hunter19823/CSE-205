package projects.week5.guis.leftright;

import javax.swing.*;

public class LeftRight {
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Left Right");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(new LeftRightPanel());

        frame.pack();
        frame.setVisible(true);
    }
}
