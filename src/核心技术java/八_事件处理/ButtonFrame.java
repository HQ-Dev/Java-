package 核心技术java.八_事件处理;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *  A frame with a button panel
 */
public class ButtonFrame extends JFrame {

    public static void main(String[] args) {
        ButtonFrame frame = new ButtonFrame();
        frame.setVisible(true);
    }

    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public ButtonFrame() throws HeadlessException {

        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // create buttons
        JButton yellowButton = new JButton("Yellow");
        JButton blueButton = new JButton("blue");
        JButton redButton = new JButton("red");

        buttonPanel = new JPanel();

        // add Buttons to panel
        buttonPanel.add(yellowButton);
        buttonPanel.add(blueButton);
        buttonPanel.add(redButton);

        // add panel to frame
        add(buttonPanel);

        // create button actions
        ColorAction yellowAction = new ColorAction(Color.yellow);
        ColorAction blueAction = new ColorAction(Color.blue);
        ColorAction redAction = new ColorAction(Color.red);

        // associate actions with buttons
        yellowButton.addActionListener(yellowAction);
        blueButton.addActionListener(blueAction);
        redButton.addActionListener(redAction);
    }


    /**
     * An action listener that sets the panel's background color
     */
    private class ColorAction implements ActionListener {

        private Color backgroundColor;

        public ColorAction(Color backgroundColor) {
            this.backgroundColor = backgroundColor;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            buttonPanel.setBackground(backgroundColor);
        }
    }
}


