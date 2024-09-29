import java.util.ArrayList;
import java.util.Scanner;

// Now we handle all the jazz with processes
// What we do is we need to check the prev
// ...

public class xargCommand {
    public static void main(String[] args) {

        // declaring arr. to tokenize the string
        // a token is the most single individual
        // char in a command
        ArrayList<String> tokens = new ArrayList<String>();

        // declare stdin. object
        Scanner stdin = new Scanner(System.in);
        System.out.println("xargCommandShell:~$"); // Prompt for input

        // getting the entire command that the user
        // inputted so that we can parse it later
        String command = stdin.nextLine();

        // basic err. handling
        while (command.length() == 0) {
            System.err.println("Error: No command written in 'xargCommandShell:~$'!!!");
            System.err.println("Let's try again.... \n");
            System.out.println("xargCommandShell:~$");
            command = stdin.nextLine();
        }

        // handling 'exit' command!
        // stops the program, closes the shell entirely
        if (command.equalsIgnoreCase("exit")) {
            System.out.println("Exiting xargCommandShell... Goodbye!");
            System.exit(0);
        }

        // using a space as delimeter
        String[] arrayOfTokens = command.split(" ");

        // setOfCommands, each element holds what would be the in or out!
        ArrayList<ArrayList<String>> setOfCommands = new ArrayList<>();

        // declare a tokenCounter which will count tokens and
        // account for the pipes
        int tokenCounter = 0;

        // populate setOfCommands by splitting tokens based on pipes
        // part I was getting confused on was having a currentCommand counter
        // not gonna lie I used the currentCommand idea from google
        ArrayList<String> currentCommand = new ArrayList<>();
        while (tokenCounter < arrayOfTokens.length) {
            if (!arrayOfTokens[tokenCounter].equals("|")) {
                // Add token to the current command list
                currentCommand.add(arrayOfTokens[tokenCounter]);
            } else {
                // Pipe encountered, add current command to setOfCommands
                setOfCommands.add(currentCommand);
                currentCommand = new ArrayList<>(); // start a new command list
            }
            // inc. tokenCounter
            tokenCounter++;
        }

        // add last one cause we don't read it in cause
        // there wont be a pipe after the last command
        if (!currentCommand.isEmpty()) {
            setOfCommands.add(currentCommand);
        }

        // printing parsed commands to test if I am doing it right
        int setOfCommandsLength = setOfCommands.size();
        for (int x = 0; x < setOfCommandsLength; x++) {
            // (x + 1) because we have to print 1 not 0
            System.out.println("Command " + (x + 1) + "!" + ": ");

            // print each element in the inner list
            ArrayList<String> innerList = setOfCommands.get(x);
            for (int y = 0; y < innerList.size(); y++) {
                System.out.println(innerList.get(y));  // print each command in the inner list
                System.out.println("\n");
            }
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