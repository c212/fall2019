public class Tester {
  public static void main(String[] args) {
    Tester.testEmptySequence(); 
    Tester.basicSortCall(); 
    Tester.createSequence(); 
  }
  public static void testEmptySequence() {
    Sequence a = new Sequence(); 
    System.out.println( a.size() ); // should print 0 (zero)
  }
  public static void basicSortCall() {
    Sequence a = new Sequence(); 
    System.out.println( a.sort() ); // should print [] 
  }
  public static void reasonableSortCall() {
    Sequence a = new Sequence(new int[] {3, 2, 4, 1, 5, 2, 1, 3}); 
    System.out.println( a.sort() ); // should print [1, 1, 2, 2, 3, 3, 4, 5] 
  }
  public static void createSequence() {
    Sequence a = new Sequence(new int[] {3, 2, 4, 1, 5, 2, 1, 3}); 
    System.out.println( a ); // should print [3, 2, 4, 1, 5, 2, 1, 3] 
  }
}