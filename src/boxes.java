import edu.macalester.graphics.*;

import java.awt.Color;

public class Boxes {
    private static final int CANVAS_WIDTH = 300;
    private static final int CANVAS_HEIGHT = 500;
    private final double boxsize = 30;
    private double dotsize = 2;
    private int numberofdots = 6;

    public Boxes(CanvasWindow canvas, double x, double y, double width, double height) {
        Rectangle rect = new Rectangle(x, y, width, height);
        canvas.add(rect);
        //rect.setFillColor(Color.white);
    }
}
