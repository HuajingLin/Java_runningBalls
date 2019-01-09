/* MyPanel class
 * 
 * CSCI 111 Assignment #12: Graphics
 * 
 * Student Name: Huajing Lin
 * Last Modify: 12/6/2016
 */
package drawball;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

// Execute drawing thread by the Runnable interface. 
public class MyPanel extends JPanel implements Runnable {

    private static final int count = 30;    //the number of balls    
    private Ball[] balls;
    private int panelWidth;
    private int panelHeight;
    public MyPanel(int width, int height) {
        panelWidth = width;
        panelHeight = height;
        //Create balls array
        balls = new Ball[count];
        for (int i = 0; i < balls.length; i++) {
            balls[i] = new Ball(panelWidth, panelHeight);
        }
    }// end MyPanel()
//==============================================================================
    public void paint(Graphics g) {
        //Sets the color of the brush
        g.setColor(Color.BLACK);
        
        //Fill the background
        g.fillRect(0, 0, panelWidth, panelHeight);
        
        for (int i = 0; i < balls.length; i++) {
            balls[i].draw(g);
        }
    }// end paint()
//==============================================================================
    //Thread run
    public void run() {
        
        while (true) {
            //every ball move
            for (int i = 0; i < balls.length; i++) {
                balls[i].move();
            }
            //Threed sleep 10 millisecond 
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //repaint the panel
            repaint();
        }
    }// end run()
//==============================================================================    
}// end class MyPanel
