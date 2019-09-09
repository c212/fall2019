import java.util.Scanner; 

public class One {
  public static void main(String[] args) {
    Scanner comet;
    String line; 
    comet = new Scanner(System.in); 
    System.out.println("Enter the first time: "); 
    line = comet.nextLine();
    System.out.println("You typed: " + line); 
    
  }
}