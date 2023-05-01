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
    private edu.macalester.graphics.Point leftupcorner;

    private edu.macalester.graphics.Point updetX, downdetX, leftdetX, rightdetX, rightdowncorner;


    private ArrayList<Object> detectionlList;
    

    public boxes(CanvasWindow canvas, double x, double y, double width, double height) {
        this.leftupcorner = new edu.macalester.graphics.Point(x, y);
        this.updetX = new edu.macalester.graphics.Point(x + width/2, y) ;
        this.downdetX = new edu.macalester.graphics.Point(x + width/2, y + height);
        this.leftdetX = new edu.macalester.graphics.Point(x, y + height/2);
        this.rightdetX = new edu.macalester.graphics.Point(x + width,y + height/2);
        
        this.detectionlList = new ArrayList<>();
    }

    
    private static void refreshdetectionlist(CanvasWindow canvas, boxes box){
        edu.macalester.graphics.Point p = Lines.linedetect;
        // System.out.println(box.updetX);
        // System.out.println(box.downdetX);
        // System.out.println(box.leftdetX);
        // System.out.println(box.rightdetX);
        if (p.equals(box.updetX)){
            System.out.print("a"); //help for test, you can ignore or delete it
            addelement(box);
        }
        if (p.equals(box.downdetX)){
            System.out.print("b");
            addelement(box);
        }
        if (p.equals(box.leftdetX)){
            System.out.print("c");
            addelement(box);
        }
        if (p.equals(box.rightdetX)){
            System.out.print("d");
            addelement(box);
        }
        // if (canvas.getElementAt(box.updetX,box.updetY)!= null){
        //     System.out.print(1);
        //     detectionlList.add(canvas.getElementAt(box.updetX,box.updetY));
        // }

        // if (canvas.getElementAt(box.updetX,box.updetY)!= null){
        //     System.out.print(1);
        //     detectionlList.add(canvas.getElementAt(box.updetX,box.updetY));
        // }

        // if (canvas.getElementAt(box.updetX,box.updetY) != null){
        //     System.out.print(1);
        //     detectionlList.add(canvas.getElementAt(box.updetX,box.updetY));
        // }

        // if (canvas.getElementAt(box.updetX,box.updetY) != null){
        //     System.out.print(1);
        //     detectionlList.add(canvas.getElementAt(box.updetX,box.updetY));
        // }
    }

    private static void addelement(boxes box){
        box.getcolorlist().add("1");
    }

    private ArrayList<Object> getcolorlist(){
        return detectionlList;
    }

    private edu.macalester.graphics.Point getleftupcorner(){
        return leftupcorner;
    }

    private edu.macalester.graphics.Point getrighdowncorner(){
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
            System.out.println(box.getcolorlist());
            if (isFilled(box)){
                boxesshouldcolor.add(box);
            }
        }
        
        return boxesshouldcolor;
    }

    public static void colorbox(ArrayList<boxes> boxesshouldcolor, CanvasWindow canvas){
        if (boxesshouldcolor != null){
            for(boxes box: boxesshouldcolor){
                edu.macalester.graphics.Point leftupcorner = box.getleftupcorner();
                Rectangle colorbox = new Rectangle(leftupcorner.getX(), leftupcorner.getY(), boxsize, boxsize);
                colorbox.setFillColor(Color.red);
                canvas.add(colorbox);
            }
        boxesshouldcolor.clear();
        }
    }


}
