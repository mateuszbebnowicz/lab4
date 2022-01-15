package laby_jp;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class DrawingShapes extends JComponent
{
    private int size = 40;
    private ArrayList<Shape> Shapes;
    private ArrayList<Color> Colors;

    public DrawingShapes()
    {
        Shapes = new ArrayList<>();
        Colors = new ArrayList<>();
    }


    public void addCircle(Point2D point, Color color)
    {
        double dPosX = point.getX() - (double)size/2;
        double dPoxY = point.getY() - (double)size/2;

        Shapes.add(new Ellipse2D.Double(dPosX, dPoxY, size, size));
        Colors.add(color);
    }

    public void addSquare(Point2D point, Color color)
    {
        double dPosX = point.getX() - (double)size/2;
        double dPoxY = point.getY() - (double)size/2;

        Shapes.add(new Rectangle2D.Double(dPosX, dPoxY, size, size));
        Colors.add(color);
    }

    public void paint(Graphics graphics)
    {
        super.paint(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;

        for(int i = 0; i < Shapes.size(); i++)
        {
            graphics2D.setColor(Colors.get(i));
            graphics2D.fill(Shapes.get(i));
        }
    }

    public void removeShapes()
    {
        Shapes.clear();
        Colors.clear();
        repaint();
    }

}