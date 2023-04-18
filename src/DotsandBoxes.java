import edu.macalester.graphics.*;
import java.util.Scanner;

public class DotsandBoxes {
    private static final int CANVAS_WIDTH = 300;
    private static final int CANVAS_HEIGHT = 500;
    private final double boxsize = 30;
    private double dotsize = 2;
    private int numberofdots = 6;
    

    private DotsandBoxes(){
        CanvasWindow canvas = new CanvasWindow("Dots & Boxes", CANVAS_WIDTH, CANVAS_HEIGHT);
        for (int i = 0; i < numberofdots; i++ ){
            for (int j = 0; j < numberofdots ; j++){
                Ellipse dots = new Ellipse((CANVAS_WIDTH-(numberofdots-1)*boxsize)/2+boxsize * i, CANVAS_HEIGHT/5+boxsize * j, dotsize, dotsize);
                canvas.add(dots);
                if (i < numberofdots - 1 && j < numberofdots - 1) {
                    boxes box = new boxes(canvas, (CANVAS_WIDTH-(numberofdots-1)*boxsize)/2+boxsize * i, CANVAS_HEIGHT/5+boxsize * j, boxsize, boxsize);
                }
            }
        }
    }





    public static void main(String[] args) {
        new DotsandBoxes();
    }
    
}
