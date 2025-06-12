import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {

    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            // Display the menu
            System.out.println("\nTo-Do List Menu:");
            System.out.println("1. Add a task");
            System.out.println("2. View all tasks");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            scanner.nextLine();  // consume newline left-over

            switch (choice) {
                case 1:
                    // Add a task
                    System.out.print("Enter the task description: ");
                    String task = scanner.nextLine();
                    tasks.add(task);
                    System.out.println("Task added successfully!");
                    break;

                case 2:
                    // View all tasks
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks to display.");
                    } else {
                        System.out.println("\nYour To-Do List:");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                    }
                    break;

                case 3:
                    // Exit
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
