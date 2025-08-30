import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Cps_209_project1{ // Cps 209 project 1 class
    public static void main(String[] args){ // Main method
       Scanner user_input = new Scanner(System.in); // Takes in user input
       System.out.println(" Welcome to the task Manager, where do you want to proceed?"); // Print messages
       System.out.println("Important"); // Terminal messages
       System.out.println("My Day planning"); // Terminal messages
       System.out.println("Planning"); //  Terminal messages
       System.out.println("Task Manager"); // Terminal messages
       System.out.println("Enter:"); // Terminal messages
       String user_input1 = user_input.nextLine().trim().toLowerCase(); // Takes the user_input and converts it to lowercase
       

       switch (user_input1) { // Switch case statement with the user input
           case "important": // Case 1 if user inputs important
               clearConsole(); // Clears the terminal before opening the file
               String filePath = "C:\\Users\\sachi\\OneDrive\\Documents\\Task_Manager_Project\\Important.java";
               openFile(filePath); // Method openfile getting called with the file path
               Important.main(args); // Calls the main function within the important class
               break; // break out of the switch statement
            case "my day planning": // Case 2 
                clearConsole(); // clears the terminal before opening the file
                openFile("C:\\Users\\sachi\\OneDrive\\Documents\\Task_Manager_Project\\My_Day_Planning.java");// Method openfile getting called with the file path
                My_Day_Planning.main(args);// Calls the main function within the important class
                break; // break
            case "planning": // case 3
                clearConsole(); // clears the terminal before opening the file
                openFile("C:\\Users\\sachi\\OneDrive\\Documents\\Task_Manager_Project\\Planning.java");// Method openfile getting called with the file path
                Planning.main(args);
                break; // break
            case "task manager": // Case 4
                clearConsole(); // clears the terminal before opening the file
                openFile("C:\\Users\\sachi\\OneDrive\\Documents\\Task_Manager_Project\\Task_Manager.java");// Method openfile getting called with the file path
                Task_Manager.main(args);
                break; // break
           default: // if none of the cases are met
               System.out.println("Invalid option, please pick a valid option"); // print invalid option, try again
       }
       user_input.close(); // Closes the running scanner
    }
    public static void openFile(String filePath){ // method for Openfile
        File file = new File(filePath); // new instance being created of the class File
        if (file.exists()){ //if file exists then it will try
            try {
                Desktop.getDesktop().open(file); // Opens the file without the default application
                System.out.println("Opening: " + filePath); // prints opening + the file path refered to 
            } 
            catch (IOException a) {
                System.out.println("Error opening the file " + a.getMessage()); // if there is an exception with the file path
            }
        }
        else{
            System.out.println("File does not exist" + filePath); // prints file does not exist if it doesn't
        }
    }

    public static void clearConsole(){ // A method to clear the terminal
        System.out.print("\033[H\033[2J");
        System.out.flush(); // Flushes the terminal out
    }
}