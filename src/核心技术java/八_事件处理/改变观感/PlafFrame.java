package 核心技术java.八_事件处理.改变观感;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Archy
 *
 * A frame with button panel for changing look-and-feel
 **/
public class PlafFrame extends JFrame {

    public static void main(String[] args) {
        PlafFrame plafFrame = new PlafFrame();
        plafFrame.setVisible(true);
    }

    private JPanel buttonPanel;

    public PlafFrame() {

        buttonPanel = new JPanel();
        UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();

        for (UIManager.LookAndFeelInfo info : infos) {
            makeButton(info.getName(), info.getClassName());
        }
        add(buttonPanel);
        pack();
    }

    /**
     * Makes a button to change the pluggable look-and-feel
     * @param name the button name
     * @param plafName the name of the look-and-feel class
     */
    void makeButton(String name, final String plafName) {
        // add button to panel
        JButton button = new JButton(name);
        buttonPanel.add(button);

        // set button action
        button.addActionListener(e -> {
            // button action: switch to the new look-and-feel
            try {
                UIManager.setLookAndFeel(plafName);
                SwingUtilities.updateComponentTreeUI(PlafFrame.this);
                pack();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
    }
}
