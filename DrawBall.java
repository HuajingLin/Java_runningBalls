/* Main class
 * 
 * CSCI 111 Assignment #12: Graphics
 * 
 * Student Name: Huajing Lin
 * Last Modify: 12/6/2016
 */
package drawball;
import javax.swing.JFrame;

public class DrawBall {

    private static final int frameWidth = 1024;
    private static final int frameHeight = 768;
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Graphics - Moving balls (by Huajing Lin)");
        frame.setSize(frameWidth, frameHeight);
        frame.setResizable(false);
        MyPanel mp = new MyPanel(frameWidth, frameHeight - 20);
        frame.add(mp);        
        Thread drawThread = new Thread(mp);
        drawThread.start();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }// end main()

}// end class DrawBall

