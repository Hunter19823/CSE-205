package projects.week5.guis.styleoptions;
//********************************************************************
//  StyleOptionsPanel.java       Java Foundations
//
//  Demonstrates the use of check boxes.
//********************************************************************

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class StyleOptionsPanel extends JPanel {
    private JLabel saying;
    private JCheckBox bold, italic;

    //-----------------------------------------------------------------
    //  Sets up a panel with a label and some check boxes that
    //  control the style of the label's font.
    //-----------------------------------------------------------------
    public StyleOptionsPanel()
    {
        saying = new JLabel("Say it with style!");
        saying.setFont(new Font("Helvetica", Font.PLAIN, 36));
        bold = new JCheckBox("Bold");
        bold.setBackground(Color.cyan);
        italic = new JCheckBox("Italic");
        italic.setBackground(Color.cyan);
        StyleListener listener = new StyleListener();
        bold.addItemListener(listener);
        italic.addItemListener(listener);
        add(saying);
        add(bold);
        add(italic);
        setBackground(Color.cyan);
        setPreferredSize(new Dimension(300, 100));
    }

    //*****************************************************************
    //  Represents the listener for both check boxes.
    //*****************************************************************

    private class StyleListener implements ItemListener {
        //--------------------------------------------------------------
        //  Updates the style of the label font style.
        //--------------------------------------------------------------

        public void itemStateChanged(ItemEvent event)
        {
            int style = Font.PLAIN;

            if (bold.isSelected())
                style = Font.BOLD;

            if (italic.isSelected())
                style = Font.ITALIC;

            saying.setFont(new Font("Helvetica", style, 36));
        }
    }
}
