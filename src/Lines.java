import edu.macalester.graphics.*;

import java.awt.Color;
import java.util.ArrayList;

public class Lines {
    public final static double boxsize = 30;
    public static CanvasWindow canvas;
    private static ArrayList<Ellipse> dotListselected = new ArrayList<>();
    public static Point linedetect;
    
    private static Color p1Color = Color.RED;
    private static Color p2Color = Color.BLUE;

    private static final int CANVAS_WIDTH = 300;
    private Lines line;
    
    public Lines(Point p1, Point p2){
        this.line = new Lines(p1, p2);
    }

    /**
     * @param canvas
     * @param dots
     * @param boxeslist
     * 
     * Get the response form keyboard press, and do detect each time after click.
     */
    public static void clickonboard(CanvasWindow canvas, ArrayList<Ellipse> dots, ArrayList<Boxes> boxeslist){    
        canvas.onClick(Event -> {
            GraphicsObject dot = canvas.getElementAt(Event.getPosition());
            if(dot instanceof Ellipse){
                dotslected((Ellipse)dot, canvas, boxeslist);
            };
            DotsandBoxes.setPointsText();
            if (DotsandBoxes.checkWin() == DotsandBoxes.getP1Points()) {
                canvas.remove(DotsandBoxes.getTurnText());
                GraphicsText p1Win = new GraphicsText("Congrats " + DotsandBoxes.getP1Name() + ", you won!", 10, 20);
                p1Win.setPosition(CANVAS_WIDTH/2 - p1Win.getWidth()/2, 350);
                canvas.add(p1Win);
            } else if (DotsandBoxes.checkWin() == DotsandBoxes.getP2Points()) {
                canvas.remove(DotsandBoxes.getTurnText());
                GraphicsText p2Win = new GraphicsText("Congrats " + DotsandBoxes.getP2Name() + ", you won!", 10, 20);
                p2Win.setPosition(CANVAS_WIDTH/2 - p2Win.getWidth()/2, 350);
                canvas.add(p2Win);
            } else if (DotsandBoxes.checkWin() == 0) {
                canvas.remove(DotsandBoxes.getTurnText());
                GraphicsText draw = new GraphicsText("It's a draw!", 10, 20);
                draw.setPosition(CANVAS_WIDTH/2 - draw.getWidth()/2, 350);
                canvas.add(draw);
            }
        });
    }

    /**
     * @param dot
     * @param canvas
     * @param boxeslist
     * 
     * If the dot is selected to two, draw the line if they are in suitable condition
     */
    private static void dotslected(Ellipse dot, CanvasWindow canvas, ArrayList<Boxes> boxeslist){
        dotListselected.add(dot);
        dot.setFillColor(Color.GREEN);
        if (dotListselected.size() == 2){
            if (detection(dotListselected)){
                drawline(dotListselected.get(0).getCenter(), dotListselected.get(1).getCenter(), canvas);
                ArrayList<Boxes> boxshouldcolor = new ArrayList<>();
                boxshouldcolor = Boxes.boxshouldcolor(canvas, boxeslist);
                Boxes.colorbox(boxshouldcolor,canvas);
            }
            for (Ellipse p: dotListselected){
                p.setFillColor(Color.WHITE);
            }
            dotListselected.removeAll(dotListselected);
            
        }

    }

    /**
     * 
     * @param p1
     * @param p2
     * @param canvas
     * 
     * Accept two points and draw the line by user's turn
     */
    private static void drawline(Point p1, Point p2, CanvasWindow canvas){
        Line line= new Line(p1, p2);
        if (DotsandBoxes.getTurnValue() == 1) {
            line.setStrokeColor(p1Color);
            DotsandBoxes.changeTurnValue();
        } else {
            line.setStrokeColor(p2Color);
            DotsandBoxes.changeTurnValue();
        }
        canvas.add(line);
        canvas.draw();
        linedetect = new Point(line.getCenter().getX(), line.getCenter().getY());
    }

    /**
     * 
     * @param dotlist
     * @return
     * The method use for detecting box distance
     */

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

