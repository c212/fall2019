import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Font;

public class Node {
  Node rightChild, leftChild, parent;
  int data;
  static final int RADIUS = 15;
  static final Color outlineColor = new Color(0.2f, 0.2f, 0.2f);
  
  // default values for a root
  NodeType type = NodeType.ROOT;
  Point location = new Point(BSTApplication.WIDTH / 2, 20);
  int depth = 0;
  
  public enum NodeType {ROOT, LEFT, RIGHT}
  
  public Node(int data) {
    this.data = data;
  }
  
  public Node() {
    
  }
  
  public void setChildren(Node left, Node right) {
    this.setLeftChild(left);
    this.setRightChild(right);
  }
  
  public void setLocations(int depth) {
    if (this.type == NodeType.LEFT) {
      this.location.x = parent.location.x - (int) (BSTApplication.WIDTH / Math.pow(2, depth + 1));
      this.location.y = parent.location.y + 3 * RADIUS;
    } else if (this.type == NodeType.RIGHT) {
      this.location.x = parent.location.x + (int) (BSTApplication.WIDTH / Math.pow(2, depth + 1));
      this.location.y = parent.location.y + 3 * RADIUS;
    }
    
    if (this.rightChild != null) {
      this.rightChild.setLocations(depth + 1);
    }
    if (this.leftChild != null) {
      this.leftChild.setLocations(depth + 1);
    }
  }
  
  public void setLeftChild(Node child) {
    this.leftChild = child;
    if (child != null) {
      child.type = NodeType.LEFT;
      child.depth = this.depth + 1;
      child.location.x = this.location.x - (int) (BSTApplication.WIDTH / Math.pow(2, child.depth + 1));
      child.location.y = this.location.y + 3 * RADIUS;
      child.parent = this;
    }
  }
  
  public void setRightChild(Node child) {
    this.rightChild = child;
    if (child != null) {
      child.type = NodeType.RIGHT;
      child.depth = this.depth + 1;
      child.location.x = this.location.x + (int) (BSTApplication.WIDTH / Math.pow(2, child.depth + 1));
      child.location.y = this.location.y + 3 * RADIUS;
      child.parent = this;
    }
  }
  
  public static ArrayList<Node> getAllChildren(Node n) {
    
    ArrayList<Node> rightTotal, leftTotal;
    
    if (n.rightChild != null && n.leftChild != null) {
      
      leftTotal = getAllChildren(n.rightChild);
      rightTotal = getAllChildren(n.leftChild);
      leftTotal.addAll(rightTotal);
      leftTotal.add(0, n);
      return leftTotal;
      
    } else if (n.leftChild != null) {
      
      leftTotal = getAllChildren(n.leftChild);
      leftTotal.add(0, n);
      return leftTotal;
      
    } else if (n.rightChild != null) {
      
      rightTotal = getAllChildren(n.rightChild);
      rightTotal.add(0, n);
      return rightTotal;
      
    } else {
      
      ArrayList<Node> arr = new ArrayList<Node>();
      arr.add(n);
      return arr;
      
    }
  }
  
  public Node search(int n) {
    if (this.data == n) {
      return this;
    } else if (n < this.data && this.leftChild != null) {
      return this.leftChild.search(n);
    } else if (n > this.data && this.rightChild != null){
      return this.rightChild.search(n);
    } else {
      return null; // unique identifier for none found
    }
  }
  
  private Node sliceLeastNode() {
    if (this.leftChild == null) {
      this.delete();
      return this;
    } else {
      return this.leftChild.sliceLeastNode();
    }
  }
  
  private void replaceWith(Node node) {
    if (this.type == NodeType.RIGHT)     this.parent.setRightChild(node);
    else if (this.type == NodeType.LEFT) this.parent.setLeftChild(node);
    else {
      this.data = node.data;
      this.setRightChild(node.rightChild);
      this.setLeftChild(node.leftChild);
      node.delete();
    }
  }
  
  // for removing a node
  private void delete() {
    if (this.leftChild != null && this.rightChild != null) 
      this.data = this.rightChild.sliceLeastNode().data;
    else if (this.rightChild != null) 
      this.replaceWith(this.rightChild);
    else if (this.leftChild != null)
      this.replaceWith(this.leftChild);
    else
      this.replaceWith(null);
    // delete??
  }
  
  public void remove(ArrayList<Integer> arr) {
    for (int n : arr) this.remove(n);
  }
  
  // for searching for a value and removing the node
  private void remove(int n) {
    Node foundNode = this.search(n);
    if (foundNode == null) {
      return; // not found, do nothing
    } else {
      foundNode.delete();
    }
    //this.setLocations(0);
  }
  
  public void insert(ArrayList<Integer> arr) {
    for (int n : arr) this.insert(n);
  }
  
  private void insert(int n) {
    if (n == this.data) {
      
    } else if (n < this.data) {
      if (this.leftChild == null) {
        this.setLeftChild(new Node(n));
      } else {
        this.leftChild.insert(n);
      }
    } else {
      if (this.rightChild == null) {
        this.setRightChild(new Node(n));
      } else {
        this.rightChild.insert(n);
      }
    }
  }
  
  public void moveTo(Point p) {
    this.location = p;
  }
  
  public String toString() {
    return "" + this.data;
  }
  
  public void draw(Graphics g) {
    Color nodeColor;
    if (this.type == NodeType.ROOT) {
      nodeColor = new Color(0.8f, 1f, 0.8f);
    } else if (this.type == NodeType.LEFT) {
      nodeColor = new Color(1f, 1f, 0.8f);
    } else {
      nodeColor = new Color(0.8f, 0.8f, 1f);
    }
    
    // draw lines
    g.setColor(Node.outlineColor);
    if (this.rightChild != null) {
      g.drawLine(this.location.x,
                 this.location.y,
                 rightChild.location.x,
                 rightChild.location.y);
    }
    if (this.leftChild != null) {
      g.drawLine(this.location.x,
                 this.location.y,
                 leftChild.location.x,
                 leftChild.location.y);
    }
    
    // draw node fill
    g.setColor(nodeColor);
    g.fillOval(this.location.x - Node.RADIUS, 
               this.location.y - Node.RADIUS, 
               Node.RADIUS * 2, 
               Node.RADIUS * 2);
    
    // draw node outline
    g.setColor(Node.outlineColor);
    g.drawOval(this.location.x - Node.RADIUS, 
               this.location.y - Node.RADIUS, 
               Node.RADIUS * 2, 
               Node.RADIUS * 2);
    g.setFont(new Font("Arial", Font.PLAIN, 12));
    g.drawString("" + this.data, 
                 this.location.x - 9,
                 this.location.y + 5);
  }
}