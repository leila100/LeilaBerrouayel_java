import java.io.Console;

public class LeilaBerrouayel_java {

  public static void main(String[] args) {
    Console console = System.console();

        String input = "";
        while (!"q".equalsIgnoreCase(input)) {

            System.out.print("Enter something (q to quite): ");

            input = console.readLine();
            String[] arrOfStr = input.split(" "); 
  
            for (String a : arrOfStr) 
                System.out.println(a); 
            System.out.println("input : " + input);
        }

        System.out.println("bye bye!");
  }
}