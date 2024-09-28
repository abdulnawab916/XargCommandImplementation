// Implementing the 'xarg' command.

// Packages being imported.
// Imports (New)
// Java program to demonstrate
// Java Runtime exec() method

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;  // Import the Scanner class

// For piping, add error handling for when the user does not enter a space between pipes
// Example:
// ls Desktop| sdsfdsfdsf
// This will not parse correctly, add error handling for this

public class xargCommand {
        public static void main(String[] args) {
            ArrayList<String> tokens = new ArrayList<String>();
            // declare std in
            Scanner stdin = new Scanner(System.in);
            System.out.println("xargCommandShell:~$"); // :)
            // string is 'command', this we store command in here.
            String command = stdin.nextLine(); // might need to change next Line

            // get length of the command.
            int lengthOfTokens = command.length();

            // Checks if user did not enter a command.
            if (lengthOfTokens == 0) {
                System.err.println("You did not write a command!, write it correctly.");
                System.exit(0);
            }

            // Handle the case for 'exit' command
            // Gets rid of the shell
            if (command.equalsIgnoreCase("exit")){
                System.out.println("Exiting xargCommandShell...");
                System.exit(0);
            }
            // after error handling, and if user wants to exit,
            // then create the token array
            // Creating an array of tokens.
            String[] arrayOfTokens = command.split(" ");
            // Summary of what I did and what I should do:

            // decalre array to store first command
            ArrayList<String> commandOne = new ArrayList<String>();

            // counter variable for seeing which index we are on
            int counter = 0;

           // keep reading a string and executing the commands until I hit a pipe
            while (counter < arrayOfTokens.length && !("|".equals(arrayOfTokens[counter]))) {
                commandOne.add(arrayOfTokens[counter]);
                counter++;
            }
            // Run the processes of whatever is in the first command
            // and then
            // for each string value in the first command
            for (String value: commandOne)
            {
                System.out.println(value);
            }
            // Print some characters
            System.out.println("******\n");
            // CommandTwo declaration
            ArrayList<String> commandTwo = new ArrayList<String>();
            // Then print whatever is the 2nd command
            //while (counter < arrayOfTokens.length && !("|".equals(arrayOfTokens[counter]))) {
            while (int middleOfCommand = startIndex; middleOfCommand < arrayOfTokens.length; middleOfCommand++)
            {
                commandTwo.add(arrayOfTokens[middleOfCommand]);
            }
            // insert pipe handler here. First, I want to check that my
            // piping parsing is working correctly

            // try catch for exception if sys call does not work
            try {
                // The path for accessing the bin variables
                String[] envp = {"PATH=/bin:/usr/bin"}; //gives us native sys calls
                Process process1 = Runtime.getRuntime().exec(arrayOfTokens, envp);

                // Grabbing the output process so that we can print it out
                BufferedReader stdInput = new BufferedReader(new InputStreamReader(process1.getInputStream()));
                // Allows us to grab the error if there is one
                BufferedReader stdError = new BufferedReader(new InputStreamReader(process1.getErrorStream()));
                String s;
                // While the input has stuff, then we print it out.
                while ((s = stdInput.readLine()) != null) {
                    System.out.println(s);
                    // fixing github
                }
            }
            // these params for catch might be able to catch the error
            // change to 'Exception e' if need be
            catch (Exception e){
                System.err.println(e.getMessage()); // getMessage prints it
           }
        }
}

/*
References:
https://www.w3schools.com/java/java_user_input.asp - Using the Scanner Package
https://www.educative.io/answers/what-is-scannernextline-in-java - using .nextLine
https://www.w3schools.com/java/java_arraylist.asp - how to use array list
https://sentry.io/answers/how-to-split-a-string-in-java/ - splitting a string
https://www.geeksforgeeks.org/java-runtime-exec-method/ - using java sys calls, Java runtime
https://www.google.com/search?q=How+to+print+out+an+error+in+a+try+catch+in+java&oq=How+to+print+out+an+error+
in+a+try+catch+in+java&gs_lcrp=EgZjaHJvbWUyCQgAEEUYORigATIHCAEQIRigATIHCAIQIRigATIHCAMQIRigAdIBCTk3NTZqMWoxNagCCLACAQ&
sourceid=chrome&ie=UTF-8:w
Use of ChatGPT 4o to help with Syntax.
Issues/Things Learned:
- Gotta use object name to access the methods in the Scanner type.

- When you run a process, you need to get the output from the process into a buffer type of thing
    and then you display it like that.
    - This basically gets the stdINput and then reads it into a buffer by allocating space for the buffer and then
    - reading it in.
      'BufferedReader stdInput = new BufferedReader(new InputStreamReader(process1.getInputStream()))'
- Line 13
- Error was cause of some null pointer type.
- while the pipe is not a thing
  while (counter < arrayOfTokens.length && !("|".equals(arrayOfTokens[counter]))) {
                // The ENVP Variable gives us to basic Unix/Linux commands such as...
                /*
                    ls: Lists files and their contents. You can use subcommands like ls -r to reverse the order in which files are displayed.
                    rm: Removes files, directories, symbolic links, device nodes, pipes, and sockets.
                    mkdir: Creates a new directory.
                    cd: Changes the current directory.
                    grep: Searches for a word or pattern within a file.
                    cp: Copies files. You can use it to copy files from one directory to another, from your default directory, or from other devices.
                    chmod: Changes file system access permissions.
                    cat: Reads a file and prints it to the standard output.
                    man: A command that can be found in most Unix tutorials.
                    These are some notes on what /bin gives us access to
*/

