public class Tester {
  public static void main(String[] args) {
    Tester.testEmptySequence(); 
  }
  public static void testEmptySequence() {
    Sequence a = new Sequence(); 
    System.out.println( a.size() ); // should print 0 (zero)
  }
}