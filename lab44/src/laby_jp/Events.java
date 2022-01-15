package laby_jp;

import javax.swing.*;

import java.awt.event.*;
import java.util.Random;

/**
    Main class of this program, controls canva and running button events.
 */
public class    Events
{

    private final DefaultSettings swingElements;

    public Events()
    {
        swingElements = new DefaultSettings();
    }

    public void mainEvent()
    {
        JFrame mainWindow = swingElements.createFrame("Main Window");

        JButton choiceButton1 = swingElements.createButton("Running Button");
        JButton choiceButton2 = swingElements.createButton("Canva");

        choiceButton1.setLocation(150, 250);
        choiceButton1.addActionListener(e -> runningButtonEvent(mainWindow));

        choiceButton2.setLocation(450, 250);
        choiceButton2.addActionListener(e -> canvaEvent(mainWindow));


        mainWindow.add(choiceButton1);
        mainWindow.add(choiceButton2);
    }

    private void runningButtonEvent(JFrame oldFrame)
    {
        oldFrame.dispose();

        JFrame runningButtonWindow = swingElements.createFrame("Running Window");

        JButton noButton = swingElements.createButton("Reset");
        JButton runningButton = swingElements.createButton("CATCH ME! (to return)");

        noButton.setLocation(450,250);
        noButton.addActionListener(e -> noButtonPressed(runningButton));

        runningButton.setLocation(150, 250);
        runningButton.addActionListener(e -> goBackEvent(runningButtonWindow));

        runningButton.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                Random random = new Random();

                if(e.getY() > 3)
                    runningButton.setLocation(random.nextInt(500), random.nextInt(450));

            }
        });

        runningButtonWindow.add(noButton);
        runningButtonWindow.add(runningButton);
    }

    private void canvaEvent(JFrame oldFrame)
    {
        oldFrame.dispose();

        JFrame canvaWindow = swingElements.createFrame("Canva Window");

        Canva drawingPanel = new Canva();
        JLabel instruction1 = new JLabel(" To draw circle press 'c'" );
        instruction1.setBounds(290,10,250, 50);
        instruction1.setLocation(10,450);

        JLabel instruction2 = new JLabel("To draw square press 's'" );
        instruction2.setBounds(290,10,250, 50);
        instruction2.setLocation(10,435);

        JButton resetButton = swingElements.createButton("Reset", 140,40);
        resetButton.setLocation(640,450);
        resetButton.addActionListener(e -> drawingPanel.drawingShapes.removeShapes());

        JButton goBackButton = swingElements.createButton("Go back",140,40);
        goBackButton.setLocation(640,500);
        goBackButton.addActionListener(e -> goBackEvent(canvaWindow));

        canvaWindow.add(drawingPanel);
        canvaWindow.add(resetButton);
        canvaWindow.add(goBackButton);
        canvaWindow.add(instruction1);
        canvaWindow.add(instruction2);

    }

    private void noButtonPressed(JButton button)
    {
        button.setLocation(150, 475);
    }

    private void goBackEvent(JFrame window)
    {
        window.dispose();
        mainEvent();
    }

}
