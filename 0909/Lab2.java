//import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Color;
//import java.awt.Polygon;

public class Lab2  extends JComponent {
  public static void main(String[] args) {
    JFrame a = new JFrame();
    int width = 500, height = 500;
    a.setVisible(true);
    a.setSize(width+25, height+75);
    a.setDefaultCloseOperation(3);
    Lab2 b = new Lab2();
    a.add(b);
  }
    public void paintComponent(Graphics g) {
    g.drawOval(0, 0, 500, 500);
    g.setColor(Color.WHITE);
    g.fillRect(0, 0, 500, 500);
    g.setColor(Color.BLACK);
    g.fillRect(50, 50, 100, 100);
    
  }

}