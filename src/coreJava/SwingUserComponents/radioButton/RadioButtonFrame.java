package coreJava.SwingUserComponents.radioButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A frame with a sample text label and radio buttons for selecting font sizes.
 * @author Archy
 **/
public class RadioButtonFrame extends JFrame {

    private JPanel buttonPanel;
    private ButtonGroup group;
    private JLabel label;
    private static final int DEFAULT_SIZE = 36;

    public RadioButtonFrame() {

        // add the simple text label

        label = new JLabel("The quick brown fox jumps over the lazy dog.");
        label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
        add(label, BorderLayout.CENTER);

        // add the radio buttons

        buttonPanel = new JPanel();
        group = new ButtonGroup();

        addRadioButton("Small", 8);
        addRadioButton("Medium", 12);
        addRadioButton("Large", 18);
        addRadioButton("Extra large", 36);

        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }

    /**
     * Adds a radio button that sets the font size of the sample text.
     * @param name the string to appear on the button
     * @param size the font size that this button sets
     */
    public void addRadioButton(String name, final int size) {
        boolean selected = size == DEFAULT_SIZE;
        JRadioButton button = new JRadioButton(name, selected);
        group.add(button);
        buttonPanel.add(button);

        // this listener sets the label font size

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // size refers to the final parameter of the addRadioButton method
                label.setFont(new Font("Serif", Font.PLAIN, size));
            }
        };

        button.addActionListener(listener);
    }
}
