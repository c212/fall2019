import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class BST extends JComponent implements MouseListener, MouseMotionListener {
  Point mouseLocation;
  Node current;
  ArrayList<Node> nodeList = new ArrayList<Node>();
  Node root = new Node(40);  
  
  public void send(String op, ArrayList<Integer> values) {
    if (op.equals("Insert")) {
      root.insert(values);
    } else {
      if (nodeList.size() > 1) root.remove(values);
    }
    nodeList = Node.getAllChildren(root);
    this.repaint();
  }
  public void mousePressed(MouseEvent e) {
    mouseLocation = new Point(e.getX(), e.getY());
    for (Node n : this.nodeList) {
      double d = n.location.distanceTo(mouseLocation);  
      if ( d < 20 ) {
        this.current = n;
        //System.out.println(n);
        return; 
      }
    }
  }
  public void mouseReleased(MouseEvent e) {
    this.current = null;
  }
  public void mouseClicked(MouseEvent e) { }
  public void mouseEntered(MouseEvent e) {}
  public void mouseExited(MouseEvent e) {}
  public void mouseMoved(MouseEvent e) {}
  public void mouseDragged(MouseEvent e) {
    if (this.current != null) {
      mouseLocation = new Point(e.getX(), e.getY());
      this.current.moveTo(mouseLocation);
      // this.current.moveTo(new Point(e.getX(), this.current.location.y)); // for changing only the X
      this.repaint();
    }
    //System.out.println( this.current );
  }
  
  public BST() {
    ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(40, 45, 38, 38, 34, 32, 35, 36, 
                                                                44, 48, 39, 42, 41, 43, 46, 40, 
                                                                34, 43, 56, 43, 23));
    root.insert(a);
    
    nodeList = Node.getAllChildren(root);

    System.out.println(Node.getAllChildren(root));
    this.addMouseListener(this);
    this.addMouseMotionListener(this);
  }
  
  public static void main(String[] args) {

  }
  
  public void paintComponent(Graphics g) {
    for (Node n : this.nodeList) {
      n.draw(g);  
    }
  }
}