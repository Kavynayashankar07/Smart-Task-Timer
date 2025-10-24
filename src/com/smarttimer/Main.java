package com.smarttimer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskManager manager = new TaskManager();
        int choice;

        System.out.println("=== SMART TASK TIMER ===");

        do {
            System.out.println("\n1. Add Task");
            System.out.println("2. Start Task");
            System.out.println("3. Stop Task");
            System.out.println("4. View Tasks");
            System.out.println("5. Save & Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter task name: ");
                    String name = sc.nextLine();
                    manager.addTask(name);
                }
                case 2 -> {
                    System.out.print("Enter task name to start: ");
                    String name = sc.nextLine();
                    Task t = manager.getTask(name);
                    if (t != null) t.start();
                    else System.out.println("Task not found!");
                }
                case 3 -> {
                    System.out.print("Enter task name to stop: ");
                    String name = sc.nextLine();
                    Task t = manager.getTask(name);
                    if (t != null) t.stop();
                    else System.out.println("Task not found!");
                }
                case 4 -> manager.displayAllTasks();
                case 5 -> {
                    manager.saveTasks();
                    System.out.println("Exiting... Goodbye!");
                }
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }
}
