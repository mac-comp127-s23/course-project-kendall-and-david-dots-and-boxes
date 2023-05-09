import edu.macalester.graphics.*;

import java.awt.Color;
import java.util.ArrayList;


public class Boxes{
    private final static double boxsize = 30;
    private edu.macalester.graphics.Point leftupcorner;

    private edu.macalester.graphics.Point updetX, downdetX, leftdetX, rightdetX;

    private ArrayList<Object> detectionlList;
    
    private static Color p1Color = Color.RED;
    private static Color p2Color = Color.BLUE;

    public Boxes(CanvasWindow canvas, double x, double y, double width, double height) {
        this.leftupcorner = new edu.macalester.graphics.Point(x, y);
        this.updetX = new edu.macalester.graphics.Point(x + width/2, y) ;
        this.downdetX = new edu.macalester.graphics.Point(x + width/2, y + height);
        this.leftdetX = new edu.macalester.graphics.Point(x, y + height/2);
        this.rightdetX = new edu.macalester.graphics.Point(x + width,y + height/2);
        
        this.detectionlList = new ArrayList<>();
    }

    /**
     * Accept the point from the user input, and match the point with every detection point of every box.
     * If it matches, make the length of the detection list extend 1.
     */     
    private static void refreshdetectionlist(CanvasWindow canvas, Boxes box){
        edu.macalester.graphics.Point p = Lines.linedetect;
        if (p.equals(box.updetX)){
            addelement(box);
        }
        if (p.equals(box.downdetX)){
            addelement(box);
        }
        if (p.equals(box.leftdetX)){
            addelement(box);
        }
        if (p.equals(box.rightdetX)){
            addelement(box);
        }
    }

    private static void addelement(Boxes box){
        box.getcolorlist().add("1");
    }

    private ArrayList<Object> getcolorlist(){
        return detectionlList;
    }

    private edu.macalester.graphics.Point getleftupcorner(){
        return leftupcorner;
    }

    /**
     * If the box's detectionlist's length is equal to 4, which means the box is filled, return true
     */
    private static boolean isFilled(Boxes box) {
        if(box.getcolorlist().size()!=4){
            return false;
        }
        return true;
    }

    /**
     * Run all over all the boxes and check which box's dection has been filled. If the box is filled, color the box.
     */
    public static ArrayList<Boxes> boxshouldcolor(CanvasWindow canvas, ArrayList<Boxes> boxeslist){
        ArrayList<Boxes> boxesshouldcolor = new ArrayList<>();
        for(Boxes box : boxeslist){
            refreshdetectionlist(canvas, box);
            if (isFilled(box)){
                DotsandBoxes.changeTurnValue();
                boxesshouldcolor.add(box);
            }
        }
        
        return boxesshouldcolor;
    }

    /**
     * Delete the box from the boxes list, to avoid the box be colored again
     */
    public static void deleteBox(ArrayList<Boxes> boxesList, ArrayList<Boxes> boxesList2) {
        for (Boxes box : boxesList2) {
            boxesList.remove(box);
        }
    }


    /**
     * Create a new rectangle for color and add it to the canvas
     */
    public static void colorbox(ArrayList<Boxes> boxesshouldcolor, CanvasWindow canvas){
        if (boxesshouldcolor != null){
            for(Boxes box: boxesshouldcolor){
                edu.macalester.graphics.Point leftupcorner = box.getleftupcorner();
                Rectangle colorbox = new Rectangle(leftupcorner.getX(), leftupcorner.getY(), boxsize, boxsize);
                if (DotsandBoxes.getTurnValue() == 1) {
                    colorbox.setFillColor(p1Color);
                    DotsandBoxes.setP1Points();
                } else {
                    colorbox.setFillColor(p2Color);
                    DotsandBoxes.setP2Points();
                }
                canvas.add(colorbox);
                
            }
        deleteBox(DotsandBoxes.boxesList, boxesshouldcolor);
        boxesshouldcolor.clear();
        }
    }


}
