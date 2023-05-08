import edu.macalester.graphics.*;

import java.util.ArrayList;
import java.util.Scanner;

import java.awt.Color;

public class DotsandBoxes {
    private static final int CANVAS_WIDTH = 300;
    private static final int CANVAS_HEIGHT = 500;
    private final double boxsize = 30;
    private double dotsize = 5;
    private static int numberofdots = 2; // 6
    public static ArrayList<Ellipse> dotsList = new ArrayList<>();
    public static ArrayList<boxes> boxeslist = new ArrayList<>();
    public static CanvasWindow canvas;

    private static int turn = 1;
    private static int p1Points = 0;
    private static int p2Points = 0;

    private static GraphicsText points1Text;
    private static GraphicsText points2Text;

    private static Color p1Color = Color.RED;
    private static Color p2Color = Color.BLUE;


    private static String player1Name = playerOneName();
    private static String player2Name = playerTwoName();
    
    private static GraphicsText turnText;
    

    private DotsandBoxes(){
        CanvasWindow canvas = new CanvasWindow("Dots & Boxes", CANVAS_WIDTH, CANVAS_HEIGHT);

        GraphicsText player1 = new GraphicsText("Player 1: " + player1Name, 10, 20);
        player1.setPosition(10, 20);
        player1.setFillColor(p1Color);
        canvas.add(player1);

        GraphicsText player2 = new GraphicsText("Player 2: " + player2Name, 10, 20);
        player2.setPosition(10, player1.getY() + player1.getHeight() + 10);
        player2.setFillColor(p2Color);
        canvas.add(player2);

        points1Text = new GraphicsText("Points: " + p1Points, 10, 20);
        points1Text.setPosition(player1.getWidth() + 60, 20);
        points1Text.setFillColor(p1Color);
        canvas.add(points1Text);

        points2Text = new GraphicsText("Points: " + p2Points, 10, 20);
        points2Text.setPosition(player1.getWidth() + 60, player1.getY() + player1.getHeight() + 10);
        points2Text.setFillColor(p2Color);
        canvas.add(points2Text);

        turnText = new GraphicsText("It's " + player1Name + "'s turn", 10, 20);
        turnText.setPosition(CANVAS_WIDTH/2 - turnText.getWidth()/2, 350);
        turnText.setFillColor(p1Color);
        canvas.add(turnText);
        
        for (int i = 0; i < numberofdots; i++ ){
            for (int j = 0; j < numberofdots ; j++){
                Ellipse dots = new Ellipse((CANVAS_WIDTH-(numberofdots-1)*boxsize)/2+boxsize * i, CANVAS_HEIGHT/5+boxsize * j, dotsize, dotsize);
                dotsList.add(dots);
                canvas.add(dots);
                if (i < numberofdots - 1 && j < numberofdots - 1) {
                    boxes box = new boxes(canvas, (CANVAS_WIDTH-(numberofdots-1)*boxsize+dotsize)/2+boxsize * i, CANVAS_HEIGHT/5+boxsize * j + dotsize/2, boxsize, boxsize);
                    boxeslist.add(box);
                }
            }
        }
        Lines.clickonboard(canvas, dotsList, boxeslist);
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

    public static int checkWin() {
        if (p1Points + p2Points == (numberofdots-1) * (numberofdots-1)) {
            if (p1Points > p2Points) {
                return p1Points;
            } else if (p1Points < p2Points) {
                return p2Points;
            } else if (p1Points == p2Points) {
                return p1Points - p2Points;
            }
        }
        return 1;
    }

    public static int getTurnValue() {
        return turn;
    }

    public static int changeTurnValue() {
        turn = -turn;
        if (turn == 1) {
            turnText.setText("It's " + player1Name + "'s turn");
            turnText.setFillColor(p1Color);
        } else if (turn == -1) {
            turnText.setText("It's " + player2Name + "'s turn");
            turnText.setFillColor(p2Color);
        }
        return turn;
    }

    public static String getP1Name() {
        return player1Name;
    }

    public static String getP2Name() {
        return player2Name;
    }

    public static int getP1Points() {
        return p1Points;
    }

    public static int getP2Points() {
        return p2Points;
    }

    public static void setP1Points() {
        p1Points += 1;
    }

    public static void setP2Points() {
        p2Points += 1;
    }

    public static void setPointsText() {
        points1Text.setText("Points: " + p1Points);
        points2Text.setText("Points: " + p2Points);
    }

    public static GraphicsText getTurnText() {
        return turnText;
    }

    public static void main(String[] args) {
        new DotsandBoxes();
       
    }
    
}
