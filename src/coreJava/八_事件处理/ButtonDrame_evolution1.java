package coreJava.八_事件处理;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * 这个类是对 ButtonFrame 的重构简化，简化后，代码量减少了 30% 以上
 * 对创建组件和增加监听以及监听方法进行了方法封装，同时使用了内部匿名类
 * @author Archy
 **/
public class ButtonDrame_evolution1 extends JFrame {

    public static void main(String[] args) {
        ButtonDrame_evolution1 buttonDrame_evolution1 = new ButtonDrame_evolution1();
        buttonDrame_evolution1.setVisible(true);
    }

    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 360;
    private static final int DEFAULT_HEIGHT = 200;

    public ButtonDrame_evolution1() {

        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        buttonPanel = new JPanel();
        // 调用一个封装了创建按钮，添加到画板上，增加监听器的方法
        makeButton("red", Color.red);
        makeButton("yellow", Color.yellow);
        makeButton("blue", Color.blue);
        add(buttonPanel);
    }

    // 封装后的方法
    public void makeButton(String colorName, Color backgroundColor) {
        JButton button  = new JButton(colorName);
        buttonPanel.add(button);
        // 创建匿名内部类方法（更加简洁）
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPanel.setBackground(backgroundColor);
            }
        });
    }

}
