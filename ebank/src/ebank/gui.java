package ebank;
import java.awt.*;
import javax.swing.*;
 
public class gui extends JPanel {
	Image img;
 
	public gui(){
		JFrame f = new JFrame("BrettScape");
		f.setSize(640,480);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		img = Toolkit.getDefaultToolkit().getImage("testtile.jpg"); 
	}
 
        public void updateScreen(){
		repaint();
        }
 
     public void drawMessages(){
           //TODO
     }
 
     public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(img, 0, 0, null);
   }
}