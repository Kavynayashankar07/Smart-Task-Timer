package com.smarttimer;

import java.io.*;
import java.util.*;

public class TaskManager {
    private List<Task> tasks = new ArrayList<>();

    public void addTask(String name) {
        tasks.add(new Task(name));
        System.out.println("Task added: " + name);
    }

    public Task getTask(String name) {
        for (Task t : tasks) {
            if (t.getName().equalsIgnoreCase(name)) {
                return t;
            }
        }
        return null;
    }

    public void saveTasks() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("tasks.csv"))) {
            for (Task t : tasks) {
                pw.println(t.getName() + "," + t.getDuration());
            }
            System.out.println("Tasks saved to tasks.csv");
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    public void displayAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to display.");
        } else {
            System.out.println("\n--- Task Summary ---");
            for (Task t : tasks) {
                System.out.println(t);
            }
        }
    }
}

