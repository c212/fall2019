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
  public void add(Integer elem) {
    this.values.add(elem);  
  }
  public Integer get(int index) {
    return this.values.get(index);  
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
  // returns a sequence made of the longest sorted prefix
  public Sequence longest() {
    Sequence result = new Sequence(); 
    if (this.size() == 0) {
      
    } else {
      for (Integer elem : this.values) {
        // System.out.println( " --> " + elem );  
        if (result.size() == 0)  {
          result.add(elem);  
        } else {
          if (result.get(result.size()-1) <= elem) {
            result.add(elem);  
          } else {
            break;  
          }
        }
      }
    }
    return result; 
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