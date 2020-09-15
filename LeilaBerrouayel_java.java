/** 
The application should allow the following actions:
Create a machine; A machine has a name and a unique Id
Track how many units are produced by each machine
Track machines temperature
Show total produced units
Show average produced units by machine

Example of commands:
create MACHINE1 IDX123456
add IDX123456 12
add IDX123456 40
temperature IDX123456 120
temperature IDX123456 Should output 120
total IDX123456 Should output 52
average IDX123456 Should output 26
**/

import java.io.Console;
import java.util.*;

public class LeilaBerrouayel_java {

  public static void main(String[] args) {
    Console console = System.console();
    String input = "";
    // Creating a HashMap to store the machines and their information
    HashMap<String, String[]> machines = new HashMap<String, String[]>();
    while (!"q".equalsIgnoreCase(input)) {
      // System.out.print("Enter something (q to quite): ");
      input = console.readLine();
      String[] commandStr = input.split(" "); 
      String command = commandStr[0];
      System.out.println(command);
      String id = "";
      switch(command) {
        case "create":
          // Create a new machine and store its name
          String name = commandStr[1];
          id = commandStr[2];
          String[] vals = new String[] {"", "", ""};
          vals[0] = name;
          machines.put(id,  vals);
          break;
        
        case "add":
          id = commandStr[1];
          String val = commandStr[2];
          String[] values = machines.get(id);
          System.out.println("val " + val);
          System.out.println(values);
          if (!values[1].equals("")) {
            int addVal = Integer.parseInt(val);
            int oldVal = Integer.parseInt(values[1]);
            String newVal = Integer.toString(oldVal + addVal);
            values[1] = newVal;
          }
          else {
            values[1] = val;
          }
          machines.put(id, values);
          break;
        default:
          System.out.println("Wrong command");
      }

      // Create a new machine and store its name
      // if (command.equals("create")) {
      //   String name = commandStr[1];
      //   String id = commandStr[2];
      //   machines.put(id, new String[] {name});
      // }
    }

    System.out.println(machines.get("2")[0]);
    System.out.println(machines.get("2")[1]);
  }
}