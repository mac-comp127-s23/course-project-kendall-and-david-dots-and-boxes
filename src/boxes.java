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
    private ArrayList<Point> dotList = new ArrayList<>();

    public boxes(CanvasWindow canvas, double x, double y, double width, double height) {
        Rectangle rect = new Rectangle(x, y, width, height);
        canvas.add(rect);
        //rect.setFillColor(Color.white);
    }

    
    public void clickonboard(CanvasWindow canvas, ArrayList<Ellipse> dots){       
        for (Ellipse dot : dots){
            canvas.onClick(Event -> {if
                (dot.testHitInLocalCoordinates(Event.getPosition().getX(),Event.getPosition().getY())){
                    dotslected(dot);
                }});


        }
    }

    public void dotslected(Ellipse dot){
        dotList.add(dot.getCenter());
        dotnum++;
        dot.setStrokeColor(Color.RED);
        canvas.draw();
        if (dotnum == 2){
            if (Math.abs(dotList.get(1).getX()-dotList.get(2).getX())==1||Math.abs(dotList.get(1).getY()-dotList.get(2).getY())==1){
                //  Call the method in Lines
                dotnum = 0;
                dotList.removeAll(dotList);
            }
            
        }
    }
}
