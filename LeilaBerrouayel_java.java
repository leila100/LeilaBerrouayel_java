
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

  public static void startTests() {
    System.out.println("***************************************");
    System.out.println("Running tests");
    HashMap<String, Machine> machines = new HashMap<String, Machine>();
    String[] commands = new String[] { "create MACHINE1 IDX123456", "add IDX123456 12", "add IDX123456 40",
        "temperature IDX123456 120", "temperature IDX123456", "total IDX123456", "average IDX123456",
        "create MACHINE2 IDX123456", "create MACHINE3" };
    for (String str : commands) {
      System.out.println("Executing command: " + str);
      String[] commandStr = str.split(" ");
      runCommands(commandStr, machines);
      switch (commandStr[0].toLowerCase()) {
        case "create":
          if (commandStr.length != 3) {
            System.out
                .println("*** since the create command requires two parameters, it will print a message saying so.");
          } else if (commandStr[1].equalsIgnoreCase("MACHINE2")) {
            System.out.println(
                "*** since a machine with the id IDX123456 already exists, it will print a message saying so.");
          } else {
            System.out.println("*** a machine with name MACHINE1 and id IDX123456 should have been created");
            System.out.println(machines.get("IDX123456").id.equals("IDX123456"));
          }
          break;

        case "add":
          if (commandStr[2].equalsIgnoreCase("12")) {
            System.out.println("*** The machine with id IDX123456 should have 12 units");
            System.out.println(machines.get("IDX123456").units == 12);
          }
          if (commandStr[2].equalsIgnoreCase("40")) {
            System.out.println("*** The machine with id IDX123456 should have 12 units");
            System.out.println(machines.get("IDX123456").units == 52);
          }
          break;

        case "temperature":
          if (commandStr.length == 3) {
            System.out.println("*** The machine with id IDX123456 should have a temperature of 120");
            System.out.println(machines.get("IDX123456").temperature == 120.0);
          } else {
            System.out.println("*** The machine with id IDX123456 should have a temperature of 120.0 printed out");
          }
          break;

        case "total":
          System.out.println("*** The machine with id IDX123456 should have a total unit number of 52 printed out");
          break;

        case "average":
          System.out.println("*** The machine with id IDX123456 should have an average unit number of 26 printed out");
          break;

        default:
          System.out.println("*** the message wrong command should be printed out.");
          break;
      }
      // if (commandStr[0].equalsIgnoreCase("create")) {
      // if (commandStr[1].equalsIgnoreCase("MACHINE2")) {
      // System.out
      // .println("*** since a machine with the id IDX123456 already exists, it will
      // print a message saying so.");
      // } else {
      // System.out.println("*** a machine with name MACHINE1 and id IDX123456 should
      // have been created");
      // System.out.println(machines.get("IDX123456").id.equals("IDX123456"));
      // }
      // } else if (commandStr[0].equalsIgnoreCase("add")) {
      // if (commandStr[2].equalsIgnoreCase("12")) {
      // System.out.println("*** The machine with id IDX123456 should have 12 units");
      // System.out.println(machines.get("IDX123456").units == 12);
      // }
      // if (commandStr[2].equalsIgnoreCase("40")) {
      // System.out.println("*** The machine with id IDX123456 should have 12 units");
      // System.out.println(machines.get("IDX123456").units == 52);
      // }
      // } else if (commandStr[0].equalsIgnoreCase("temperature")) {
      // if (commandStr.length == 3) {
      // System.out.println("*** The machine with id IDX123456 should have a
      // temperature of 120");
      // System.out.println(machines.get("IDX123456").temperature == 120.0);
      // } else {
      // System.out.println("*** The machine with id IDX123456 should have a
      // temperature of 120.0 printed out");
      // }
      // } else if (commandStr[0].equalsIgnoreCase("total")) {
      // System.out.println("*** The machine with id IDX123456 should have a total
      // unit number of 52 printed out");
      // } else if (commandStr[0].equalsIgnoreCase("average")) {
      // System.out.println("*** The machine with id IDX123456 should have an average
      // unit number of 26 printed out");
      // }
    }
    System.out.println("***************************************");
  }

  public static void main(String[] args) {
    if (args.length == 1 && args[0].equals("test")) {
      startTests();
      return;
    }
    Console console = System.console();
    String input = "";
    // Creating a HashMap to store the machines by their id
    HashMap<String, Machine> machines = new HashMap<String, Machine>();
    while (!"q".equalsIgnoreCase(input)) {
      input = console.readLine();
      String[] commandStr = input.split(" ");
      runCommands(commandStr, machines);
    }

  }

  public static void runCommands(String[] commandStr, HashMap<String, Machine> machines) {
    String command = commandStr[0];
    String id = "";
    String val = "";
    Machine currentMachine;
    switch (command.toLowerCase()) {
      case "create":
        if (commandStr.length != 3) {
          System.out.println("**** Please use the create command in this format - create name id -");
          return;
        }
        String name = commandStr[1];
        id = commandStr[2];
        if (machines.containsKey(id)) {
          System.out.println("**** Sorry, a machine with the id " + id + " already exists.");
          return;
        }
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
        } else {
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
      case "q":
        System.out.println("exit");
        break;
      default:
        System.out.println("wrong command");
    }
  }

}