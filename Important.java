import java.util.PriorityQueue;
import java.util.Scanner;

public class Important implements Comparable<Important>{ // Class Important

    private String task; // Instance variable tasks
    private int starttime; // instance variable for starttime
    private int endtime; // instance variable for endtime

    public Important(String task, int starttime, int endtime){ // Constructor
        this.task = task; // this keyword used to tell the compiler it's an instance variable
        this.starttime = starttime;// this keyword used to tell the compiler it's an instance variable
        this.endtime = endtime;// this keyword used to tell the compiler it's an instance variable
    }
    public String gettask(){ // getter method to get private instance variables
        return task; // returns the private variable
    }
    public int getstarttime(){// getter method to get private instance variables
        return starttime; // returns the private variable
    }
    public int getendtime(){// getter method to get private instance variables
        return endtime; // returns the private variable
    }
    public void settask(String task){ // Setter method to assign new values to insatnce variables
        this.task = task; 
    }
    public void setstarttime(int starttime){// Setter method to assign new values to insatnce variables
        this.starttime = starttime;
    }
    public void setendtime(int endtime){// Setter method to assign new values to insatnce variables
        this.endtime = endtime;
    }
    public static void important(){

    }
    
    public String toString(){
        return (" Task added: " + task + " from " + starttime + " to " + endtime);
    }
    
    @Override // Overrides
    public int compareTo(Important other){ // comparing with another object
        if (this.endtime > other.endtime){ // comparing two end times
            return 1; // returns 1 if greater
        }
        else if (this.endtime < other.endtime){// comparing two end times
            return -1; // returns -1 if less
        }
        else{
            return 0; // returns 0 if equal
        }
    }

    
    public static void main(String[] args){
        Scanner user_input = new Scanner(System.in); // Takes in user input
        PriorityQueue <Important>  pq = new PriorityQueue < Important >(); // Priority queue based on end times or deadlines approaching
        System.out.println("Please mention the task, Start time and End time"); // Prints out the task, start time along side end time]
        while (true) { 
            System.out.println("Enter your task or say done to exit");
            String user_input1 = user_input.nextLine().trim();
            if (user_input1.equalsIgnoreCase("Done")){ // checks if the user input matches done with the considerations of case limitiations
                break; // Exit the loop
            }
            System.out.println("Enter start time (an integer)"); // prints start time
            int starttime = user_input.nextInt(); // reads the next token of integer

            System.out.println("Enter end time (an integer)");
            int endtime = user_input.nextInt();// prints end time

            user_input.nextLine(); // Consume the newline left by nextInt()

            Important task = new Important(user_input1,starttime,endtime);
            pq.add(task);

            while (!pq.isEmpty()) {
                Important task_input = pq.poll(); // Get the task with the earliest end time
                System.out.println(task_input); // The toString() method will be automatically called
            }
    
        }
        user_input.close(); // Close the scanner
    }
}