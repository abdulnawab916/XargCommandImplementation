// Implementing the 'xarg' command.

// Packages being imported.
import java.util.ArrayList;
import java.util.Scanner;  // Import the Scanner class

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

            // after error handling, then create the token array
            // Creating an array of tokens.
            String[] arrayOfTokens = command.split(" ");

            // Then split up the String into tokens, each component will be a value in the array.
            for (String index : arrayOfTokens) {
                System.out.println(index);

            }


    }
}

/*
References:
https://www.w3schools.com/java/java_user_input.asp - Using the Scanner Package
https://www.educative.io/answers/what-is-scannernextline-in-java - using .nextLine
https://www.w3schools.com/java/java_arraylist.asp - how to use array list
https://sentry.io/answers/how-to-split-a-string-in-java/ - splitting a string

Issues/Things Learned:
- Gotta use object name to access the methods in the Scanner type.
- Line 13
*/