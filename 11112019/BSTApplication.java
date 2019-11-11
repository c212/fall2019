import javax.swing.*; 
import java.awt.*; 

public class BSTApplication extends JFrame {
  static int WIDTH = 600;
  static int HEIGHT = 400;
  
  public static void main(String[] args) {
    BSTApplication f = new BSTApplication();
    Container c = f.getContentPane(); 
    BST b = new BST();
    c.setLayout(new BorderLayout()); 
    c.add(new Controls(b), BorderLayout.NORTH);
    c.add(b, BorderLayout.CENTER);
    
    f.setVisible(true);
    c.setBackground(Color.WHITE);
    f.setSize(WIDTH, HEIGHT); 
  }
}