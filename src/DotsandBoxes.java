import edu.macalester.graphics.*;
import edu.macalester.graphics.ui.TextField;

import java.util.ArrayList;
import java.util.Scanner;

import java.awt.Color;

public class DotsandBoxes {
    private static final int CANVAS_WIDTH = 300;
    private static final int CANVAS_HEIGHT = 500;
    private final double boxsize = 30;
    private double dotsize = 5;
    private int numberofdots = 6;
    public static ArrayList<Ellipse> dotsList = new ArrayList<>();

    private int turn = 0;
    private int p1Points = 0;
    private int p2Points = 0;
    

    private DotsandBoxes(){
        String player1Name = playerOneName();
        String player2Name = playerTwoName();

        CanvasWindow canvas = new CanvasWindow("Dots & Boxes", CANVAS_WIDTH, CANVAS_HEIGHT);

        GraphicsText player1 = new GraphicsText("Player 1: " + player1Name, 10, 20);
        player1.setPosition(10, 20);
        canvas.add(player1);

        GraphicsText player2 = new GraphicsText("Player 2: " + player2Name, 10, 20);
        player2.setPosition(10, player1.getY() + player1.getHeight() + 10);
        canvas.add(player2);

        GraphicsText points1Text = new GraphicsText("Points: " + p1Points, 10, 20);
        points1Text.setPosition(player1.getWidth() + 60, 20);
        canvas.add(points1Text);

        GraphicsText points2Text = new GraphicsText("Points: " + p2Points, 10, 20);
        points2Text.setPosition(player1.getWidth() + 60, player1.getY() + player1.getHeight() + 10);
        canvas.add(points2Text);
        
        for (int i = 0; i < numberofdots; i++ ){
            for (int j = 0; j < numberofdots ; j++){
                Ellipse dots = new Ellipse((CANVAS_WIDTH-(numberofdots-1)*boxsize)/2+boxsize * i, CANVAS_HEIGHT/5+boxsize * j, dotsize, dotsize);
                dotsList.add(dots);
                canvas.add(dots);
                if (i < numberofdots - 1 && j < numberofdots - 1) {
                    boxes box = new boxes(canvas, (CANVAS_WIDTH-(numberofdots-1)*boxsize+dotsize)/2+boxsize * i, CANVAS_HEIGHT/5+boxsize * j + dotsize/2, boxsize, boxsize);
                }
            }
        }
        Lines.clickonboard(canvas, dotsList);
    }

    
    public static String playerOneName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Player 1's name: ");
        return scanner.nextLine();
    }

    public static String playerTwoName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Player 2's name: ");
        return scanner.nextLine();
    }


    public static void main(String[] args) {
        new DotsandBoxes();
       
    }
    
}
