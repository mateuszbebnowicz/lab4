package laby_jp;

import javax.swing.*;

import java.awt.*;

import static java.awt.Color.white;

public class DefaultSettings {

    public DefaultSettings()
    {

    }

    public JFrame createFrame(String text)
    {
        JFrame frame = new JFrame(text);

        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setBackground(white);
        frame.setVisible(true);

        return frame;
    }

    public JButton createButton(String text)
    {
        return createButton(text,200,50);
    }

    public JButton createButton(String text, int width, int height)
    {
        JButton button = new JButton(text);

        button.setSize(width, height);
        button.setFocusable(false);

        return button;
    }


}
