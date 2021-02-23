package projects.week6;

import javax.swing.*;

public class BankGUI {
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("My Bank Account");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //BankPanel panel = new BankPanel();
        //frame.getContentPane().add(panel);
        frame.getContentPane().add(new BankPanel());

        frame.pack();
        frame.setVisible(true);
    }
}
