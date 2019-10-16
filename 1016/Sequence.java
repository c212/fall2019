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
  public static Sequence merge(Sequence p, Sequence r) {
    // this code assumes p and r are sorted already (ascending) 
    Sequence result = new Sequence(); 
    if (p.size() == 0) {
      return r; 
    } else if (r.size() == 0) {
      return p;  
    } else {
      int pIndex = 0, rIndex = 0; 
      while ((pIndex < p.size()) || (rIndex < r.size())) { 
        if (pIndex >= p.size()-1) {
          Integer b = r.get(rIndex); 
          result.add(b); 
          rIndex += 1; 
        } else if (rIndex >= r.size()-1) { 
          Integer a = p.get(pIndex); 
          result.add(a); 
          pIndex += 1; 
        } else {
          Integer a = p.get(pIndex); 
          Integer b = r.get(rIndex); 
          if (a <= b) {
            result.add(a); 
            pIndex += 1; 
          } else { 
            result.add(b); 
            rIndex += 1; 
          }
        }
      }
    }
    return result; 
  }
  public String toString() {
    return this.values + ""; 
  }
}