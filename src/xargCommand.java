import java.util.ArrayList;
import java.util.Scanner;

public class xargCommand {
    public static void main(String[] args) {

        // getting the tokens from
        // the cmd line
        ArrayList<String> tokens = new ArrayList<String>();

        // declare stdin
        Scanner stdin = new Scanner(System.in);
        System.out.println("xargCommandShell:~$"); // Prompt for input

        // getting user input
        String command = stdin.nextLine();

        // err handling
        while (command.length() == 0) {
            System.err.println("Error: No command written in 'xargCommandShell:~$'!!!");
            System.err.println("Let's try again.... \n");
            System.out.println("xargCommandShell:~$");
            command = stdin.nextLine();
        }

        // handling exit command
        if (command.equalsIgnoreCase("exit")) {
            System.out.println("Exiting xargCommandShell... Goodbye!");
            System.exit(0);
        }

        // using space as delimeter
        String[] arrayOfTokens = command.split(" ");

        // setOfCommands, each element holds what would be the in or out!
        ArrayList<ArrayList<String>> setOfCommands = new ArrayList<>();

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
