public class Example {
  public static void main(String[] args) {
    Sequence a = new Sequence(); 
    System.out.println( a ); // []
    a.add(1);
    System.out.println( a ); // [1]
    a.add(3); 
    System.out.println( a ); // [1, 3]
    a.add(2); 
    System.out.println( a ); // [1, 3, 2]
  }
}