/* Ball class
 * 
 * CSCI 111 Assignment #12: Graphics
 * 
 * Student Name: Huajing Lin
 * Last Modify: 12/6/2016
 */
package drawball;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
    //The attributes of the ball
    private int x;  //The X coordinate of the ball
    private int y;  //The Y coordinate of the ball
    private int xStep;      //The X coordinate movement step of the ball
    private int yStep;      //The Y coordinate movement step of the ball
    private Color color;    //The color of ball
    private int diameter;   //The diameter of the ball
    
    private static final int ColorNum = 12; //the number of Colors;
    private static final int StepNum = 5;   //the steps of moving;
    private int panelWidth;
    private int panelHeight;
    private Color[] ColorArray;             //Color array for random selection
        
    Ball(int width, int height) {
        ColorArray = new Color[ColorNum];
        ColorArray[0] = Color.BLUE;
        ColorArray[1] = Color.CYAN;
        ColorArray[2] = Color.DARK_GRAY;
        ColorArray[3] = Color.GRAY;
        ColorArray[4] = Color.GREEN;
        ColorArray[5] = Color.LIGHT_GRAY;
        ColorArray[6] = Color.MAGENTA;
        ColorArray[7] = Color.ORANGE;
        ColorArray[8] = Color.PINK;
        ColorArray[9] = Color.RED;
        ColorArray[10] = Color.WHITE;
        ColorArray[11] = Color.YELLOW;                          
        
        //Randomly initialize the color of the ball
        color = ColorArray[(int) (Math.random() * ColorNum)];
        
        //Randomly initialize the position of the ball
        panelWidth = width;
        panelHeight = height;
        int[] oneStep = {1, -1};
        x = ((int) (Math.random() * (panelWidth - 240))) + 120;
        y = ((int) (Math.random() * (panelHeight - 240))) + 120;
        diameter = (int) (Math.random() * 80 + 30);    //diameter of ball is from 30 to 110
        
        xStep = (int) (Math.random() * StepNum) - 3;
        if (xStep == 0) {
            xStep = oneStep[(int) (Math.random() * 2)];
        }
        
        yStep = (int) (Math.random() * StepNum) - 3;
        if (yStep == 0) {
            yStep = oneStep[(int) (Math.random() * 2)];
        }
    }// end Ball()
//==============================================================================
    //The method of the ball moving
    public void move() {
        x += xStep;
        y += yStep;
        if (x > panelWidth - diameter || x < 0) { //Returns if the ball exceeds the screen x bounds,
            xStep *= -1;
            this.color = ColorArray[(int) (Math.random() * ColorNum)];// and change ball's color.
        }
        if (y > panelHeight - diameter || y < 0) { //Returns if the ball exceeds the screen y bounds
            yStep *= -1;
            this.color = ColorArray[(int) (Math.random() * ColorNum)];// and change ball's color.
        }
    }// end move()
//==============================================================================
    // ball draws itself
    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval(x, y, diameter, diameter);
    }
//==============================================================================
}// end class Ball
