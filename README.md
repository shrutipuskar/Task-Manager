# Task Manager

## Description
A simple console-based task management application developed in Java. This application enables users to manage tasks with functionalities to add, edit, view, delete, and mark tasks as completed. It uses Java's `LocalDate` for handling due dates and features a text-based user interface for interaction.

## Features
- **Add Task**: Create a new task with a title, description, and due date.
- **Edit Task**: Modify the details of an existing task.
- **View All Tasks**: Display a list of all tasks with their details.
- **Delete A Task**: Remove a task from the list.
- **Mark A Task As Completed**: Mark a specific task as completed.

## Installation and Setup
1. **Clone the Repository**:
    ```bash
    git clone https://github.com/shrutipuskar/Task-Manager.git
    ```
2. **Navigate to the Project Directory**:
    ```bash
    cd Task-Manager
    ```
3. **Compile the Code**:
    ```bash
    javac -d bin src/taskmanager/*.java
    ```
4. **Run the Application**:
    ```bash
    java -cp bin taskmanager.Main
    ```

## Usage
When you run the application, you will see a menu with the following options:
1. **Add Task**: Enter the task title, description, and due date.
2. **Edit Task**: Specify the task number to edit and provide new details.
3. **View All Tasks**: Display all tasks with their details.
4. **Delete A Task**: Choose the task number to delete it.
5. **Mark A Task As Completed**: Mark a task as completed by its number.
6. **Exit**: Exit the application.

Follow the on-screen prompts to interact with the application.

## Class Overview

### `Task` Class
The `Task` class represents a task in the system with the following attributes:
- **title**: The title of the task.
- **description**: A brief description of the task.
- **dueDate**: The due date of the task.
- **completed**: Status indicating whether the task is completed or not.

#### Key Methods:
- **Constructor**: Initializes a task with the provided title, description, and due date.
- **Getters and Setters**: For accessing and modifying attributes, with data validation.

### `TaskManager` Class
The `TaskManager` class manages a list of `Task` objects and provides methods to manipulate them:
- **addTask(String title, String description, LocalDate dueDate)**: Adds a new task to the list.
- **editTask(int index, String title, String description, LocalDate dueDate)**: Edits a task at the specified index.
- **getTasks()**: Returns a list of all tasks.
- **viewTasks()**: Prints all tasks to the console.
- **deleteTask(int index)**: Removes a task at the specified index.
- **markTaskAsCompleted(int index)**: Marks a task as completed.

## Contributing
If you would like to contribute to this project:
1. Fork the repository.
2. Create a feature branch (`git checkout -b feature-branch`).
3. Commit your changes (`git commit -am 'Add new feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Open a Pull Request.


