import edu.macalester.graphics.*;

import java.util.ArrayList;
import java.util.Scanner;

import java.awt.Color;

public class DotsandBoxes {
    private static final int CANVAS_WIDTH = 300;
    private static final int CANVAS_HEIGHT = 500;
    private final double boxSize = 30;
    private double dotSize = 5;
    private static int numberOfDots = 2;
    public static ArrayList<Ellipse> dotsList = new ArrayList<>();
    public static ArrayList<Boxes> boxesList = new ArrayList<>();
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
        
        for (int i = 0; i < numberOfDots; i++ ){
            for (int j = 0; j < numberOfDots ; j++){
                Ellipse dots = new Ellipse((CANVAS_WIDTH-(numberOfDots-1)*boxSize)/2+boxSize * i, CANVAS_HEIGHT/5+boxSize * j, dotSize, dotSize);
                dotsList.add(dots);
                canvas.add(dots);
                if (i < numberOfDots - 1 && j < numberOfDots - 1) {
                    Boxes box = new Boxes(canvas, (CANVAS_WIDTH-(numberOfDots-1)*boxSize+dotSize)/2+boxSize * i, CANVAS_HEIGHT/5+boxSize * j + dotSize/2, boxSize, boxSize);
                    boxesList.add(box);
                }
            }
        }
        Lines.clickonboard(canvas, dotsList, boxesList);
    }

    /**
     * Read the name entered, representing the first player.
     * @return a String
     */
    public static String playerOneName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Player 1's name: ");
        return scanner.nextLine();
    }

    /**
     * Read the name entered, representing the second player.
     * @return a String
     */
    public static String playerTwoName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Player 2's name: ");
        return scanner.nextLine();
    }

    /**
     * Checks if the number of points is equal to the number of boxes, then returns
     * the number of points of the player with more points.
     * @return an int
     */
    public static int checkWin() {
        if (p1Points + p2Points == (numberOfDots-1) * (numberOfDots-1)) {
            if (p1Points > p2Points) {
                return p1Points;
            } else if (p1Points < p2Points) {
                return p2Points;
            } else if (p1Points == p2Points) {
                return p1Points - p2Points;
            }
        }
        return 10000;
    }

    public static int getTurnValue() {
        return turn;
    }

    /**
     * Switches from one player's turn to the other and changes the text on the canvas
     * to tell whose turn it is.
     * @return an int
     */
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

    /**
     * The main method, runs the Dots and Boxes game.
     */
    public static void main(String[] args) {
        new DotsandBoxes();
       
    }
    
}
