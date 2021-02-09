package projects.week6.guis.pushcounter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PushCounterPanel extends JPanel {
    private int count;
    private JButton push;
    private JLabel label;

    public PushCounterPanel()
    {
        count = 0;

        push = new JButton("Push Me");
        push.addActionListener(new ButtonListener());

        label = new JLabel();
        label.setText("Pushes: "+count);

        add(push);
        add(label);

        setBackground(Color.cyan);
        setPreferredSize(new Dimension(300,40));
    }

    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent event)
        {
            count++;
            label.setText("Pushes: "+count);
        }
    }
}
