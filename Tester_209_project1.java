import java.util.PriorityQueue;
import java.util.Scanner;

public class Tester_209_project1 {
    public static void main(String[] args) {
        System.out.println("Running tests for all classes...\n");

        // **Testing Important Class**
        System.out.println("=== Testing Important Class ===");
        Important task1 = new Important("Finish project", 10, 12);
        Important task2 = new Important("Workout", 6, 7);
        Important task3 = new Important("Finish project", 10, 12); // Duplicate task for comparison

        System.out.println("Task1: " + task1);
        System.out.println("Task2: " + task2);
        System.out.println("Comparing task1 and task2: " + task1.compareTo(task2)); // Should return positive
        System.out.println("Task1 equals Task3: " + task1.equals(task3)); // Should return true

        // **Testing My_Day_Planning Class**
        System.out.println("\n=== Testing My_Day_Planning Class ===");
        My_Day_Planning plan1 = new My_Day_Planning("Meeting", 9, 10);
        My_Day_Planning plan2 = new My_Day_Planning("Lunch", 12, 1);

        System.out.println("Plan1: " + plan1);
        System.out.println("Plan2: " + plan2);
        System.out.println("Comparing plans: " + plan1.compareTo(plan2));

        // **Testing Planning Class (User Input)**
        System.out.println("\n=== Testing Planning Class ===");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a plan for your day: ");
        String userPlan = scanner.nextLine();
        System.out.println("You planned: " + userPlan);

        // **Testing Task_Manager Class**
        System.out.println("\n=== Testing Task_Manager Class ===");
        Task_Manager taskManager1 = new Task_Manager("Study", "High");
        Task_Manager taskManager2 = new Task_Manager("Grocery Shopping", "Medium");
        Task_Manager taskManager3 = new Task_Manager("Study", "High"); // Duplicate task

        System.out.println("Task Manager 1: " + taskManager1);
        System.out.println("Task Manager 2: " + taskManager2);
        System.out.println("Task1 equals Task3: " + taskManager1.equals(taskManager3)); // Should return true

        // **Testing PriorityQueue (Sorting by end time)**
        System.out.println("\n=== Testing Priority Queue for Tasks ===");
        PriorityQueue<Important> pq = new PriorityQueue<>();
        pq.add(task1);
        pq.add(task2);
        pq.add(task3);

        while (!pq.isEmpty()) {
            System.out.println("Processing Task: " + pq.poll());
        }

        System.out.println("\nAll tests completed successfully!");
        scanner.close();
    }
}

