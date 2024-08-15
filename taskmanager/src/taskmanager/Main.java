package taskmanager;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Task Management Application");
            System.out.println("1. Add Task");
            System.out.println("2. Edit Task");
            System.out.println("3. View All Tasks");
            System.out.println("4. Delete A Task");
            System.out.println("5. Mark A Task As Completed");
            System.out.println("0. Exit");
            System.out.print("Enter Your Choice: ");
            
            int choice = -1;
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number between 0 and 5.");
                sc.next(); // Clear invalid input
                continue;
            }

            sc.nextLine(); // Consume newline

            switch (choice) {
                case 0:
                    System.out.println("Exiting....");
                    sc.close();
                    return;

                case 1:
                    System.out.print("Enter the Task Title: ");
                    String title = sc.nextLine();
                    
                    System.out.print("Enter the Task Description: ");
                    String description = sc.nextLine();
                    
                    LocalDate dueDate = null;
                    while (dueDate == null) {
                        System.out.print("Enter the Task Due date (YYYY-MM-DD): ");
                        String dueDateString = sc.nextLine();
                        try {
                            dueDate = LocalDate.parse(dueDateString);
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date format. Please try again.");
                        }
                    }
                    
                    taskManager.addTask(title, description, dueDate);
                    System.out.println("Task added successfully!");
                    break;

                case 2:
                    System.out.print("Enter the task number to edit: ");
                    int editIndex = sc.nextInt();
                    sc.nextLine(); // Consume newline

                    if (editIndex <= 0 || editIndex > taskManager.getTasks().size()) {
                        System.out.println("Invalid task number! Please try again.");
                        break;
                    }

                    System.out.print("Enter the new Title: ");
                    String newTitle = sc.nextLine();
                    
                    System.out.print("Enter the new Description: ");
                    String newDescription = sc.nextLine();
                    
                    LocalDate newDueDate = null;
                    while (newDueDate == null) {
                        System.out.print("Enter the new Due date (YYYY-MM-DD): ");
                        String newDueDateString = sc.nextLine();
                        try {
                            newDueDate = LocalDate.parse(newDueDateString);
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date format. Please try again.");
                        }
                    }
                    
                    taskManager.editTask(editIndex - 1, newTitle, newDescription, newDueDate);
                    System.out.println("Task edited successfully!");
                    break;

                case 3:
                    taskManager.viewTasks();
                    break;

                case 4:
                    System.out.print("Enter the task number to delete: ");
                    int deleteIndex = sc.nextInt();

                    if (deleteIndex <= 0 || deleteIndex > taskManager.getTasks().size()) {
                        System.out.println("Invalid task number! Please try again.");
                        break;
                    }

                    taskManager.deleteTask(deleteIndex - 1);
                    System.out.println("Task deleted successfully!");
                    break;

                case 5:
                    System.out.print("Enter the task number to mark as completed: ");
                    int comIndex = sc.nextInt();
                    
                    if (comIndex <= 0 || comIndex > taskManager.getTasks().size()) {
                        System.out.println("Invalid task number! Please try again.");
                        break;
                    }

                    taskManager.markTaskAsCompleted(comIndex - 1);
                    System.out.println("Task marked as completed successfully!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
            System.out.println();
        }
    }
}

