package chatbbg;

import java.io.IOException;

import chatbbg.tasktypes.Task;

public class chatBBG {

    public static void main(String[] args) {
        Storage.createFileDirectory();
        Storage.createOrReadOutputFile();
        printWelcomeMessage();
        if(Task.totalTasks == 0) {
            Task.initializeArray();
        }
        Functions.readUserInput();
    }

    public static void printWelcomeMessage() {
        System.out.println("I'm JOI");
        System.out.println("You look lonely, I can fix that");
    }

    public static void goodbye(){
        System.out.println("Shutting down...");
        try {
            System.out.println("Saving tasks to file...");
            Task.writeToFile();
            System.out.println("Tasks saved successfully");
        } catch (IOException e) {
            System.out.println("Error writing to file" + e.getMessage());
        }
    }
}