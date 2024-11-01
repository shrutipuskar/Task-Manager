package taskmanager;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a TaskManager instance to manage the list of tasks
        TaskManager taskManager = new TaskManager();
        Scanner sc = new Scanner(System.in); // Scanner to handle user input

        // Main loop for the task management application
        while (true) {
            // Display menu options
            System.out.println("Task Management Application");
            System.out.println("1. Add Task");
            System.out.println("2. Edit Task");
            System.out.println("3. View All Tasks");
            System.out.println("4. Delete A Task");
            System.out.println("5. Mark A Task As Completed");
            System.out.println("0. Exit");
            System.out.print("Enter Your Choice: ");
            
            int choice = -1; // Initialize choice variable to store user's selection
            try {
                choice = sc.nextInt(); // Get user input
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number between 0 and 5.");
                sc.next(); // Clear invalid input
                continue; // Restart the loop
            }

            sc.nextLine(); // Consume newline after integer input

            switch (choice) {
                case 0: // Exit the application
                    System.out.println("Exiting....");
                    sc.close(); // Close scanner to release resources
                    return;

                case 1: // Add a new task
                    System.out.print("Enter the Task Title: ");
                    String title = sc.nextLine(); // Get task title from user
                    
                    System.out.print("Enter the Task Description: ");
                    String description = sc.nextLine(); // Get task description from user
                    
                    LocalDate dueDate = null;
                    // Loop until a valid date is entered
                    while (dueDate == null) {
                        System.out.print("Enter the Task Due date (YYYY-MM-DD): ");
                        String dueDateString = sc.nextLine();
                        try {
                            dueDate = LocalDate.parse(dueDateString); // Parse date from input
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date format. Please try again.");
                        }
                    }
                    
                    // Add task to task manager
                    taskManager.addTask(title, description, dueDate);
                    System.out.println("Task added successfully!");
                    break;

                case 2: // Edit an existing task
                    System.out.print("Enter the task number to edit: ");
                    int editIndex = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    
                    // Check if task number is valid
                    if (editIndex <= 0 || editIndex > taskManager.getTasks().size()) {
                        System.out.println("Invalid task number! Please try again.");
                        break;
                    }

                    System.out.print("Enter the new Title: ");
                    String newTitle = sc.nextLine(); // Get new title for the task
                    
                    System.out.print("Enter the new Description: ");
                    String newDescription = sc.nextLine(); // Get new description
                    
                    LocalDate newDueDate = null;
                    // Loop until a valid new due date is entered
                    while (newDueDate == null) {
                        System.out.print("Enter the new Due date (YYYY-MM-DD): ");
                        String newDueDateString = sc.nextLine();
                        try {
                            newDueDate = LocalDate.parse(newDueDateString); // Parse new due date
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date format. Please try again.");
                        }
                    }
                    
                    // Edit the task in task manager
                    taskManager.editTask(editIndex - 1, newTitle, newDescription, newDueDate);
                    System.out.println("Task edited successfully!");
                    break;

                case 3: // View all tasks
                    taskManager.viewTasks(); // Display list of tasks
                    break;

                case 4: // Delete a specific task
                    System.out.print("Enter the task number to delete: ");
                    int deleteIndex = sc.nextInt();
                    
                    // Validate task number
                    if (deleteIndex <= 0 || deleteIndex > taskManager.getTasks().size()) {
                        System.out.println("Invalid task number! Please try again.");
                        break;
                    }

                    // Delete task from task manager
                    taskManager.deleteTask(deleteIndex - 1);
                    System.out.println("Task deleted successfully!");
                    break;

                case 5: // Mark a specific task as completed
                    System.out.print("Enter the task number to mark as completed: ");
                    int comIndex = sc.nextInt();
                    
                    // Validate task number
                    if (comIndex <= 0 || comIndex > taskManager.getTasks().size()) {
                        System.out.println("Invalid task number! Please try again.");
                        break;
                    }

                    // Mark task as completed in task manager
                    taskManager.markTaskAsCompleted(comIndex - 1);
                    System.out.println("Task marked as completed successfully!");
                    break;

                default: // Handle invalid menu choice
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
            System.out.println(); // Blank line for formatting
        }
    }
}
