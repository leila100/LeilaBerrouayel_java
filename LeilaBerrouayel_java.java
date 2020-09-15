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
      String val = "";
      String[] values = new String[4];
      switch(command) {
        case "create":
          // Create a new machine and store its name
          String name = commandStr[1];
          id = commandStr[2];
          // Store information for each machine [name, total units, number of adds, temperature]
          String[] vals = new String[] {"", "", "", ""};
          vals[0] = name;
          machines.put(id,  vals);
          break;
        
        case "add":
          id = commandStr[1];
          val = commandStr[2];
          values = machines.get(id);
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
        
        case "total":
          id = commandStr[1];
          System.out.println(machines.get(id)[1]);
          break;
        
        case "temperature":
          id = commandStr[1];
          // get temperature
          if (commandStr.length == 2) {
            System.out.println(machines.get(id)[3]);
          }
          else {
            // set temperature
            val = commandStr[2];
            values = machines.get(id);
            values[3] = val;
            machines.put(id, values);
          }
          break;

        default:
          System.out.println("Wrong command");
      }
    }

    System.out.println(machines.get("2")[0]);
    System.out.println(machines.get("2")[1]);
    System.out.println(machines.get("2")[2]);
    System.out.println(machines.get("2")[3]);
  }
}