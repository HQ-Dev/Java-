package src.核心技术java.六_接口与内部类.接口.接口与回调;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.Timer;

/**
 * Created by archy on 6/15/16.
 */
public class TimeTester {
    public static void main(String[] args) {
        ActionListener listener = new TimePrinter();

        // construct a timer that calls the listener
        // once every 10 seconds
        javax.swing.Timer t = new javax.swing.Timer(10000,listener);
        t.start();

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}


class TimePrinter implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Date now = new Date();
        System.out.println("At the tone, the time is " + now);
        Toolkit.getDefaultToolkit().beep();
    }
}
