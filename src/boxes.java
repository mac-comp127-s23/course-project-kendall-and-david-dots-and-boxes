import edu.macalester.graphics.*;

import java.awt.Color;
import java.util.ArrayList;

import org.w3c.dom.events.Event;



public class boxes {
    public CanvasWindow canvas;
    private static final int CANVAS_WIDTH = 300;
    private static final int CANVAS_HEIGHT = 500;
    private final double boxsize = 30;
    private double dotsize = 2;
    private int numberofdots = 6;
    private int dotnum = 0;
    private ArrayList<Point> dotListselected = new ArrayList<>();

    public boxes(CanvasWindow canvas, double x, double y, double width, double height) {
        Rectangle rect = new Rectangle(x, y, width, height);
        canvas.add(rect);
        //rect.setFillColor(Color.white);
    }

    

}
