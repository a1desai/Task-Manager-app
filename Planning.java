import java.util.ArrayList;
import java.util.Scanner;

/**
 // the planning class helps users organize their daily plans efficiently.
 */
public class Planning {
    
    private ArrayList<String> plans; // List to store user plans
    private Scanner scanner; // Scanner for user input

    /**
     * Default Constructor: Initializes an empty list and a default scanner.
     */
    public Planning() {
        this.plans = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Constructor Overloading: Initializes with a list of pre-existing plans.
     */
    public Planning(ArrayList<String> initialPlans) {
        this.plans = new ArrayList<>(initialPlans);
        this.scanner = new Scanner(System.in);
    }

    /**
     * Constructor Overloading: Allows a custom Scanner instance for input.
     */
    public Planning(Scanner customScanner) {
        this.plans = new ArrayList<>();
        this.scanner = customScanner;
    }

    /**
     * Constructor Overloading: Initializes with both custom plans and a scanner.
     */
    public Planning(ArrayList<String> initialPlans, Scanner customScanner) {
        this.plans = new ArrayList<>(initialPlans);
        this.scanner = customScanner;
    }

    /**
     * Allows the user to add a new plan.
     */
    public void addPlan() {
        System.out.print("Enter your plan (or type 'done' to stop): ");
        String plan = scanner.nextLine().trim();

        if (plan.equalsIgnoreCase("done")) {
            return; // Exit input mode
        }
        if (plan.isEmpty()) {
            System.out.println("Plan cannot be empty! Try again.");
        } else {
            plans.add(plan);
            System.out.println("Plan added successfully: " + plan);
        }
    }

    /**
     * Displays all planned tasks.
     */
    public void displayPlans() {
        if (plans.isEmpty()) {
            System.out.println("No plans available. Start adding plans now!");
            return;
        }
        System.out.println("\nYour Plans for the Day:");
        for (int i = 0; i < plans.size(); i++) {
            System.out.println((i + 1) + ". " + plans.get(i));
        }
    }

    /**
     * Allows the user to remove a plan based on index.
     */
    public void removePlan() {
        if (plans.isEmpty()) {
            System.out.println("No plans to remove!");
            return;
        }
        displayPlans();
        System.out.print("Enter the number of the plan to remove: ");
        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            if (index >= 0 && index < plans.size()) {
                System.out.println("Removed: " + plans.remove(index));
            } else {
                System.out.println("Invalid number! No plan removed.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid number.");
        }
    }

    /**
     * The main menu where the user can interactively add, view, and remove plans.
     */
    public void startPlanning() {
        System.out.println("Welcome to Your Daily Planner!");

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1 - Add a plan");
            System.out.println("2 - View plans");
            System.out.println("3 - Remove a plan");
            System.out.println("4 - Exit");
            System.out.print("Choose an option: ");
            
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    addPlan();
                    break;
                case "2":
                    displayPlans();
                    break;
                case "3":
                    removePlan();
                    break;
                case "4":
                    System.out.println("Goodbye! Have a productive day.");
                    return; // Exit the loop
                default:
                    System.out.println("Invalid choice! Please select a valid option.");
            }
        }
    }

    /**
     * Main method to demonstrate constructor overloading.
     */
    public static void main(String[] args) {
        // Option 1: Default Constructor
        Planning myPlanner1 = new Planning();
        
        // Option 2: Constructor with predefined plans
        ArrayList<String> myTasks = new ArrayList<>();
        myTasks.add("Gym at 6 AM");
        myTasks.add("Meeting at 9 AM");
        Planning myPlanner2 = new Planning(myTasks);

        // Option 3: Constructor with custom scanner (For testing)
        Scanner testScanner = new Scanner(System.in);
        Planning myPlanner3 = new Planning(testScanner);

        // Option 4: Constructor with predefined plans and a custom scanner
        Planning myPlanner4 = new Planning(myTasks, testScanner);

        // Running the planner
        myPlanner1.startPlanning(); // Start interactive planning
    }
}
