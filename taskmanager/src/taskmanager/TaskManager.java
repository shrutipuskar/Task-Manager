package taskmanager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(String title, String description, LocalDate dueDate) {
        Task task = new Task(title, description, dueDate);
        tasks.add(task);
    }

    public void editTask(int index, String title, String description, LocalDate dueDate) {
        if (index < 0 || index >= tasks.size()) {
            System.out.println("Invalid task index.");
            return;
        }
        Task task = tasks.get(index);
        task.setTitle(title);
        task.setDescription(description);
        task.setDueDate(dueDate);
    }

    public List<Task> getTasks() {
        return new ArrayList<>(tasks); // Return a copy to prevent external modification
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("Task #" + (i + 1));
            System.out.println(tasks.get(i));
            System.out.println();
        }
    }

    public void deleteTask(int index) {
        if (index < 0 || index >= tasks.size()) {
            System.out.println("Invalid task index.");
            return;
        }
        tasks.remove(index);
    }

    public void markTaskAsCompleted(int index) {
        if (index < 0 || index >= tasks.size()) {
            System.out.println("Invalid task index.");
            return;
        }
        Task task = tasks.get(index);
        task.setCompleted(true);
    }
}
