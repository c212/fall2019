//import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;
//import java.awt.Polygon;

public class Lab2 {
  public static void main(String[] args) {
    JFrame a = new JFrame();
    int width = 500, height = 500;
    a.setVisible(true);
    a.setSize(width+25, height+75);
    a.setDefaultCloseOperation(3);
  }
  public void paintComponent(Graphics g) {
    g.drawOval(0, 0, 500, 500);
    g.setColor(Color.WHITE);
    g.fillRect(0, 0, 500, 500);
    g.setColor(Color.BLACK);
    g.fillRect(50, 50, 100, 100);
    
  }
}