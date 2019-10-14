// sequence: [1, 3, 2, 4, 5, 1, 9, 7]
//            ----
// prefix: I see 8 (possibly nine)
// longest sorted (ascending) prefix: [1, 3]
// [1, 3, 5, 7, 2, 4, 6, 8] 
// ------------
// let's implement Sequence
import java.util.ArrayList; 

public class Sequence {
  private ArrayList<Integer> values; 
  public Sequence() {
    this.values = new ArrayList<Integer>();
  }
  public int size() {
    return this.values.size();  
  }
  public String toString() {
    return this.values + "";  
  }
  public void add(int n) {
    this.values.add( n );  
  }
}