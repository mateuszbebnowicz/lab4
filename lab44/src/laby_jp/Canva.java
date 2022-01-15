package laby_jp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Canva extends JPanel{

    protected DrawingShapes drawingShapes;


    Canva()
    {
        drawingShapes = new DrawingShapes();

        this.drawingShapes.setPreferredSize(new Dimension(765, 40));

        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        this.setBackground(Color.lightGray);
        this.setBounds(10,20,765,400);


        drawingShapes.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {

                drawingShapes.requestFocusInWindow();

            }
        });
        drawingShapes.addKeyListener(new KeyAdapter()
        {

            @Override
            public void keyPressed(KeyEvent e)
            {
                Point mousePosition = MouseInfo.getPointerInfo().getLocation();
                SwingUtilities.convertPointFromScreen(mousePosition, drawingShapes);

                    switch (e.getKeyCode())
                    {
                        case KeyEvent.VK_C:
                            if (drawingShapes.contains(mousePosition))
                            {
                                drawingShapes.addCircle(mousePosition, Color.red);
                                repaint();
                            }

                            break;
                        case KeyEvent.VK_S:
                            if (drawingShapes.contains(mousePosition))
                            {
                                drawingShapes.addSquare(mousePosition, Color.blue);
                                repaint();
                            }
                            break;
                        default:
                            break;
                    }
            }
        });

        this.add(drawingShapes, BorderLayout.CENTER);
        this.setVisible(true);
    }

    }


