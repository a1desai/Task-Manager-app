import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 // Task_Manager class helpssers organize their tasks effectively.
 // Users can add, view, remove, and search for tasks.
 */
public class Task_Manager {
    
    private String taskName; // Name of the task
    private String priority; // Priority level (High, Medium, Low)
    private static ArrayList<Task_Manager> taskList = new ArrayList<>(); // List to store tasks
    private static Scanner scanner = new Scanner(System.in); // Scanner for user input

    /**
     * Constructor initializes a task with a name and priority.
     */
    public Task_Manager(String taskName, String priority) {
        this.taskName = taskName;
        this.priority = priority;
    }

    /**
     * Overrides equals method to compare tasks based on name and priority.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Same memory reference
        if (obj == null || getClass() != obj.getClass()) return false; // Null or different class
        
        Task_Manager task = (Task_Manager) obj; // Type casting
        return Objects.equals(taskName, task.taskName) && Objects.equals(priority, task.priority);
    }

    /**
     * Overrides hashCode to ensure proper comparison.
     */
    @Override
    public int hashCode() {
        return Objects.hash(taskName, priority);
    }

    /**
     * Returns a string representation of the task.
     */
    @Override
    public String toString() {
        return "Task: " + taskName + " | Priority: " + priority;
    }

    /**
     * Adds a new task to the list.
     */
    public static void addTask() {
        System.out.print("Enter task name: ");
        String name = scanner.nextLine().trim();
        
        System.out.print("Enter priority (High, Medium, Low): ");
        String priority = scanner.nextLine().trim();

        Task_Manager newTask = new Task_Manager(name, priority);
        
        if (taskList.contains(newTask)) {
            System.out.println("Task already exists! Duplicate entries are not allowed.");
        } else {
            taskList.add(newTask);
            System.out.println("Task added successfully!");
        }
    }

    /**
     * Displays all tasks in the list.
     */
    public static void viewTasks() {
        if (taskList.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("\nYour Tasks:");
            for (int i = 0; i < taskList.size(); i++) {
                System.out.println((i + 1) + ". " + taskList.get(i));
            }
        }
    }

    /**
     * Removes a task from the list.
     */
    public static void removeTask() {
        if (taskList.isEmpty()) {
            System.out.println("No tasks to remove.");
            return;
        }
        viewTasks();
        System.out.print("Enter the task number to remove: ");
        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            if (index >= 0 && index < taskList.size()) {
                System.out.println("Removed: " + taskList.remove(index));
            } else {
                System.out.println("Invalid task number!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid number.");
        }
    }

    /**
     * Searches for a task based on its name.
     */
    public static void searchTask() {
        System.out.print("Enter task name to search: ");
        String searchName = scanner.nextLine().trim();
        
        boolean found = false;
        for (Task_Manager task : taskList) {
            if (task.taskName.equalsIgnoreCase(searchName)) {
                System.out.println("Found: " + task);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Task not found.");
        }
    }

    /**
     * The main menu where users can interact with the Task Manager.
     */
    public static void taskMenu() {
        System.out.println("Welcome to Task Manager!");

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1 - Add Task");
            System.out.println("2 - View Tasks");
            System.out.println("3 - Remove Task");
            System.out.println("4 - Search Task");
            System.out.println("5 - Exit");
            System.out.print("Choose an option: ");
            
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    addTask();
                    break;
                case "2":
                    viewTasks();
                    break;
                case "3":
                    removeTask();
                    break;
                case "4":
                    searchTask();
                    break;
                case "5":
                    System.out.println("Exiting Task Manager. Have a productive day!");
                    return; // Exit the program
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    /**
     * Main method to start the Task Manager.
     */
    public static void main(String[] args) {
        taskMenu(); // Start the interactive task manager
    }
}
