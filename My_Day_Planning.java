import java.util.PriorityQueue;
import java.util.Scanner;

// Subclass My_Day_Planning that extends Important
public class My_Day_Planning extends Important {

    // Constructor that calls the superclass (Important) constructor
    public My_Day_Planning(String task, int starttime, int endtime) {
        super(task, starttime, endtime);
    }

    public static void main(String[] args) {
        Scanner user_input = new Scanner(System.in); // Scanner object to take user input
        PriorityQueue<Important> pq = new PriorityQueue<>(); // PriorityQueue to store tasks

        System.out.println("Enter your tasks for the day (or type 'done' to finish):");
        
        while (true) { // Infinite loop to take multiple tasks
            System.out.println("Enter task description or 'done' to exit:");
            String user_input1 = user_input.nextLine().trim(); // Read user input and remove extra spaces
            
            if (user_input1.equalsIgnoreCase("done")) { // Check if user wants to exit
                break;
            }
            
            System.out.println("Enter start time (an integer):");
            int starttime = user_input.nextInt(); // Read start time

            System.out.println("Enter end time (an integer):");
            int endtime = user_input.nextInt(); // Read end time
            
            user_input.nextLine(); // Consume the newline left by nextInt()

            // Create a new task and add it to the priority queue
            Important task = new My_Day_Planning(user_input1, starttime, endtime);
            pq.add(task);
        }
        
        // Display the scheduled tasks in order of priority (by end time)
        System.out.println("\nYour planned tasks in order of earliest end time:");
        while (!pq.isEmpty()) {
            Important task = pq.poll(); // Retrieve and remove the highest-priority task
            System.out.println(task); // Calls toString() method automatically
        }
        
        user_input.close(); // Close the scanner
    }
}
