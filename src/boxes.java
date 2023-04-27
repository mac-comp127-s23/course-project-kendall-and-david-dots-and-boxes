import edu.macalester.graphics.*;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import javax.lang.model.util.ElementScanner14;
import javax.sound.sampled.Port;

import org.w3c.dom.events.Event;



public class boxes {
    public CanvasWindow canvas;
    private final static double boxsize = 30;
    private Line up, down, left, right;
    private GraphicsGroup boxshape;
    private Point leftupcorner;

    private static ArrayList<Color> detectionlList;
    

    public boxes(CanvasWindow canvas, double x, double y, double width, double height) {
        this.leftupcorner = new Point((int)x, (int)y);
        this.boxshape = new GraphicsGroup(x, y);
        this.up = new Line(0, 0, boxsize, 0 );
        this.down = new Line(0, boxsize, boxsize, boxsize);
        this.left = new Line(0, 0, 0, boxsize);
        this.right = new Line(boxsize, 0, boxsize, boxsize);

        boxshape.add(up);
        boxshape.add(down);
        boxshape.add(left);
        boxshape.add(right);
        canvas.add(boxshape, x, y);
        
        boxes.detectionlList = new ArrayList<>();
        detectionlList.add((Color)up.getStrokeColor());
        detectionlList.add((Color)up.getStrokeColor());
        detectionlList.add((Color)up.getStrokeColor());
        detectionlList.add((Color)up.getStrokeColor());

        //rect.setFillColor(Color.white);

    }

    // public static void setlinecolor(Point p1, Point p2){
        
    // }

    private ArrayList<Color> getcolorlist(){
        return detectionlList;
    }

    private Point getleftupcorner(){
        return leftupcorner;
    }

    private static boolean isFilled(boxes box) {
        ArrayList<Color> local = box.getcolorlist();
        for (Color color : local) {
            if (color.equals(Color.black)) {
                return false;
            }
        }
        return true;
    }

    public static ArrayList<boxes> boxshouldcolor(){
        ArrayList<boxes> boxesshouldcolor = new ArrayList<>();
        for(boxes box : DotsandBoxes.boxeslist){
            if (isFilled(box) == true){
                System.out.print(1);
                boxesshouldcolor.add(box);
                DotsandBoxes.boxeslist.remove(box);
            }
        }
        return boxesshouldcolor;
    }

    public static void colorbox(ArrayList<boxes> boxesshouldcolor, CanvasWindow canvas){
        if (boxesshouldcolor != null){
            for(boxes box: boxesshouldcolor){
                Point leftupcorner = box.getleftupcorner();
                Rectangle colorbox = new Rectangle(leftupcorner.getX(), leftupcorner.getY(), boxsize, boxsize);
                canvas.add(colorbox);
            }
        }
    }



}
