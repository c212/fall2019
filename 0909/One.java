import java.util.Scanner; 

public class One {
  public static void main(String[] args) {
    Scanner comet;
    String line; 
    comet = new Scanner(System.in); 
    System.out.println("Enter the first time: "); 
    line = comet.nextLine();
    // System.out.println("You typed: " + line); 
    int h = Integer.parseInt( line.substring(0, 2) ); 
    int m = Integer.parseInt( line.substring(3) );
    System.out.println( line + " is " + (h * 60 + m) + " in minutes " );
  }
}