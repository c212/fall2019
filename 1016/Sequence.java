import java.util.ArrayList; 

public class Sequence {
  private ArrayList<Integer> values; 
  public Sequence() {
    this.values = new ArrayList<Integer>();    
  }
  public Sequence(int[] values) {
    this(); 
    for (int v : values)
      this.values.add(v); 
  }
  public int size() {
    return this.values.size();  
  }
  public Sequence sort() {
    if (this.size() == 0) {
      return new Sequence();  
    } else {
      Sequence a = this.longest(); 
      Sequence b = this.rest(); 
      return merge(a, b); 
    }
  }
  public Sequence longest() {
    return null;  
  }
  public Sequence rest() {
    return null;  
  }
  public Sequence merge(Sequence p, Sequence r) {
    return null;  
  }
  public String toString() {
    return this.values + ""; 
  }
}