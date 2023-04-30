import edu.macalester.graphics.*;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import javax.lang.model.util.ElementScanner14;
import javax.security.auth.RefreshFailedException;
import javax.sound.sampled.Port;

import org.w3c.dom.events.Event;



public class boxes {
    private final static double boxsize = 30;
    private Point leftupcorner;
    private Point rightdowncorner;
    private double updetX, downdetX, leftdetX, rightdetX;
    private double updetY, downdetY, leftdetY, rightdetY;


    private static ArrayList<Object> detectionlList;
    

    public boxes(CanvasWindow canvas, double x, double y, double width, double height) {
        this.updetX = x + width/2;
        this.downdetX = x + width/2;
        this.leftdetX = x;
        this.rightdetX = x + width;
        this.updetY = y;
        this.downdetY = y + height;
        this.leftdetY = y + height/2;
        this.rightdetY = y + height/2;

        
        boxes.detectionlList = new ArrayList<>();
    }

    
    private static void refreshdetectionlist(CanvasWindow canvas, boxes box){
        detectionlList.clear();
        if (canvas.getElementAt(box.updetX,box.updetY)!= null){
            System.out.print(1);
            detectionlList.add(canvas.getElementAt(box.updetX,box.updetY));
        }

        if (canvas.getElementAt(box.updetX,box.updetY)!= null){
            System.out.print(1);
            detectionlList.add(canvas.getElementAt(box.updetX,box.updetY));
        }

        if (canvas.getElementAt(box.updetX,box.updetY) != null){
            System.out.print(1);
            detectionlList.add(canvas.getElementAt(box.updetX,box.updetY));
        }

        if (canvas.getElementAt(box.updetX,box.updetY) != null){
            System.out.print(1);
            detectionlList.add(canvas.getElementAt(box.updetX,box.updetY));
        }
    }

    private ArrayList<Object> getcolorlist(){
        return detectionlList;
    }

    private Point getleftupcorner(){
        return leftupcorner;
    }

    private Point getrighdowncorner(){
        return rightdowncorner;
    }
    

    private static boolean isFilled(boxes box) {
        if(box.getcolorlist().size()!=4){
            return false;
        }
        return true;
    }

    public static ArrayList<boxes> boxshouldcolor(CanvasWindow canvas, ArrayList<boxes> boxeslist){
        ArrayList<boxes> boxesshouldcolor = new ArrayList<>();
        for(boxes box : boxeslist){
            refreshdetectionlist(canvas, box);
            if (isFilled(box) == true){
                boxesshouldcolor.add(box);
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
