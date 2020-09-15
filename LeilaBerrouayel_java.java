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
    // Creating a HashMap to store the machines by their id
    HashMap<String, Machine> machines = new HashMap<String, Machine>();
    while (!"q".equalsIgnoreCase(input)) {
      // System.out.print("Enter something (q to quite): ");
      input = console.readLine();
      String[] commandStr = input.split(" "); 
      String command = commandStr[0];
      String id = "";
      String val = "";
      Machine currentMachine;
      switch(command.toUpperCase()) {
        case "create":
          // Create a new machine and store its name and id
          String name = commandStr[1];
          id = commandStr[2];
          Machine newMachine = new Machine(name, id);
          machines.put(id, newMachine);
          break;
        
        case "add":
          // add the units and keeps track of the adds
          id = commandStr[1];
          val = commandStr[2];
          currentMachine = machines.get(id);
          currentMachine.add(Integer.parseInt(val));
          break;
        
        case "total":
          // display the total units
          id = commandStr[1];
          currentMachine = machines.get(id);
          currentMachine.total();
          break;
        
        case "temperature":
          id = commandStr[1];
          currentMachine = machines.get(id);
          if (commandStr.length == 2) {
            // print temperature
            currentMachine.temperature();
          }
          else {
            // set temperature
            val = commandStr[2];
            currentMachine.temperature(Integer.parseInt(val));
          }
          break;
        
        case "average":
          // print the average produced units
          id = commandStr[1];
          currentMachine = machines.get(id);
          currentMachine.average();
          break;
        default:
          System.out.println("Wrong command");
      }
    }

    // System.out.println(machines.get("2")[0]);
    // System.out.println(machines.get("2")[1]);
    // System.out.println(machines.get("2")[2]);
    // System.out.println(machines.get("2")[3]);
  }
}