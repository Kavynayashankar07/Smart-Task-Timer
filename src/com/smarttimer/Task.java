package com.smarttimer;

public class Task {
    private String name;
    private long startTime;
    private long endTime;
    private boolean isRunning;

    public Task(String name) {
        this.name = name;
        this.isRunning = false;
    }

    public void start() {
        if (!isRunning) {
            startTime = System.currentTimeMillis();
            isRunning = true;
            System.out.println("Started task: " + name);
        } else {
            System.out.println("Task is already running!");
        }
    }

    public void stop() {
        if (isRunning) {
            endTime = System.currentTimeMillis();
            isRunning = false;
            System.out.println("Stopped task: " + name);
        } else {
            System.out.println("Task is not running!");
        }
    }

    public long getDuration() {
        if (isRunning) {
            return System.currentTimeMillis() - startTime;
        } else {
            return endTime - startTime;
        }
    }

    public String getName() {
        return name;
    }

    public String toString() {
        long seconds = getDuration() / 1000;
        return name + " - Duration: " + seconds + " seconds";
    }
}

