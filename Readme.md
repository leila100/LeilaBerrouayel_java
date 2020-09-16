# Technical Assignment for a Full Stack Developer Candidate

This technical assignment aims to assess your ability to solve technical problems, to design
software, and to write code. Please do not use any external libraries except to build the project
and run the unit tests. For the solution, please use one of the following programming languages:
Java, C#

## Here are the instructions:
Develop a command line application to monitor the status of a manufacturing facility by tracking all the system events emitted by all the machines.
The application should allow the following actions:

- Create a machine; A machine has a name and a unique Id
- Track how many units are produced by each machine
- Track machines temperature
- Show total produced units
- Show average produced units by machine

### Example of commands:

- create MACHINE1 IDX123456
- add IDX123456 12
- add IDX123456 40
- temperature IDX123456 120
- temperature IDX123456 Should output 120
- total IDX123456 Should output 52
- average IDX123456 Should output 26

## How to run the program:

- The program is composed of two files: LeilaBerrouayel_java.java and Machine.java.
- You would compile the program by typing **javac LeilaBerrouayel_java.java***
- You would run the program by typing **java LeilaBerrouayel_java** or **java LeilaBerrouayel_java test** to run the tests.

## How the program works:

- The LeilaBerrouayel_java.java contains the main method to start reading the user's commands.
- Depending on the command, the program will make sure that the command is valid.
- If the command is not valid, it will show an error message
- If the command is valid, the program will run the appropriate function on the corresponding machine.
- To run predefined tests, type **java LeilaBerrouayel_java test** that will run the function startTests that will test specific commands (valid and not valid) and display what the program should output.
