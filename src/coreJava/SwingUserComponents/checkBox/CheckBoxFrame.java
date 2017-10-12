package coreJava.SwingUserComponents.checkBox;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Archy
 **/
public class CheckBoxFrame extends JFrame {

    private JLabel label;
    private JCheckBox bold;
    private JCheckBox italic;
    private static final int FONTSIZE = 24;

    public CheckBoxFrame() {

        // add the simple text label
        label = new JLabel("The quick browm fox jumps over the lazy dog.");
        label.setFont(new Font("Serif", Font.BOLD, FONTSIZE));
        add(label, BorderLayout.CENTER);

        // this listener sets the font attribute of the label to the check box state

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int mode = 0;
                if (bold.isSelected()) mode += Font.BOLD;
                if (italic.isSelected()) mode += Font.ITALIC;
                label.setFont(new Font("Serif", mode, FONTSIZE));
            }
        };

        // add the check boxes

        JPanel buttonPanel = new JPanel();

        bold = new JCheckBox("Bold");
        bold.addActionListener(listener);
        bold.setSelected(true);
        buttonPanel.add(bold);

        italic = new JCheckBox("Italic");
        italic.addActionListener(listener);
        buttonPanel.add(italic);

        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }
}
