import edu.macalester.graphics.*;

import java.awt.Color;
import java.util.ArrayList;

public class Lines {
    private Lines line;
    public final static double boxsize = 30;
    public static CanvasWindow canvas;
    private static ArrayList<Ellipse> dotListselected = new ArrayList<>();
    
    public Lines(Point p1, Point p2){
        this.line = new Lines(p1, p2);
    }


    public static void clickonboard(CanvasWindow canvas, ArrayList<Ellipse> dots){    
        canvas.onClick(Event -> {
            GraphicsObject dot = canvas.getElementAt(Event.getPosition());
            if(dot instanceof Ellipse){
                dotslected((Ellipse)dot, canvas);
        };
        });
    }


    public static void dotslected(Ellipse dot, CanvasWindow canvas){
        dotListselected.add(dot);
        dot.setFillColor(Color.RED);
        if (dotListselected.size() == 2){
            if (detection(dotListselected)){
                // //
                Line line= new Line(dotListselected.get(0).getCenter(), dotListselected.get(1).getCenter());
                canvas.add(line);
                // I'm wondering how to locate two boxes with a line or two points(Since boxes are overlapped, for each line, there will two overlapped boxes)
                // After locate the box, I can adjust the color of the line. And if you have no idea, there is an aleternative way to complete the boxes class:
                // don't draw any box at the start after the game, and add line to the boxes each time.
                ArrayList<boxes> boxshouldcolor = new ArrayList<>();
                boxshouldcolor = boxes.boxshouldcolor();
                boxes.colorbox(boxshouldcolor,canvas);
            }
            for (Ellipse p: dotListselected){
                p.setFillColor(Color.WHITE);
            }
            dotListselected.removeAll(dotListselected);
            
        }

    }

    private static boolean detection(ArrayList<Ellipse> dotlist){
        double xcord1 = dotListselected.get(0).getX();
        double xcord2 = dotListselected.get(1).getX();
        double ycord1 = dotListselected.get(0).getY();
        double ycord2 = dotListselected.get(1).getY();
        if((Math.abs(xcord1-xcord2)==boxsize && Math.abs(ycord1-ycord2)==0)||(Math.abs(xcord1-xcord2)==0 && Math.abs(ycord1-ycord2)==boxsize)){
            return true;
        }else{
            return false;
        }
    }

}

