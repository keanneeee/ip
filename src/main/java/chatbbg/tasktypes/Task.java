package chatbbg.tasktypes;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import Exceptions.noTaskNum;
import java.io.FileWriter;
import java.io.IOException;

public class Task {
    protected static ArrayList<Task> tasks; //stores objects of type Task
    //protected static Task[] tasks = new Task[100];
    public static int totalTasks = 0;
    protected String desc;
    protected boolean isDone;
    protected String type;

    public static void initializeArray() {
        tasks = new ArrayList<>();
    }

    public Task(String desc) {
        this.desc = desc;
        this.isDone = false;
        //this.type = "T";
    }

    public String getMark() {
        return isDone ? "X" : " ";
    }

    public static void printTasks() {
        System.out.println("here are your tasks: ");
        int index = 1;
        for (int i = 0; i < totalTasks; i++) {
            System.out.println(index + ". " + tasks.get(i).toString());
            index++;
        }
    }

    /**
     * Modifies the isDone attribute of the task at the specified index and handles the deletion of the tasks
     * @param index index of the task to be modified
     * @param line user input
     * @throws IndexOutOfBoundsException if user inputs an index that is out of bounds
     */
    public static void modifyTaskTick(int index, String line) throws IndexOutOfBoundsException {

        if (line.startsWith("mark")) {
            tasks.get(index).isDone = true;
            printMarked(index, line);
        } else if (line.startsWith("unmark")) {
            tasks.get(index).isDone = false;
            printMarked(index, line);
        } else if (line.startsWith("delete")) {
            if (totalTasks < index) {
                throw new IndexOutOfBoundsException();
            } else {
                printDelete(index);
            }
        }
    }

    /**
     * removes the task from the list and updates the total number of tasks
     * @param index index of the task to be removed
     */
    public static void printDelete(int index) {
        System.out.println("deleted it for ya :)");
        System.out.println(tasks.get(index).toString());
        tasks.remove(index);
        totalTasks--;
        System.out.println("Now there are " + totalTasks + " tasks in the list.");
    }

    /**
     * Prints the task that is modified
     * @param index index of the task to be modified
     * @param line user input
     */
    public static void printMarked(int index, String line) {
        if (line.startsWith("mark")) {
            System.out.println("marked it for ya <3");
            System.out.println(tasks.get(index).toString());
        } else if (line.startsWith("unmark")) {
            System.out.println("unmarked it for ya ;)");
            System.out.println(tasks.get(index).toString());
        }
    }

    /**
     * detects and print the tasks containing the keyword after the command "find"
     * if there is no matching task, print the sentence "No matching tasks found."
     * @param line: user input
     */
    public static void findTask(String line){
        boolean found = false;
        String value = line.substring(5).trim();
        for (int i = 0; i < totalTasks; i++){
            if (tasks.get(i).desc.contains(value)){
                found = true;
                break;
            }
        }
        if (!found){
            System.out.println("No matching tasks found.");
        } else {
            System.out.println("Here are the matching tasks in your list:");
            for (int i = 0; i < totalTasks; i++) {
                if (tasks.get(i).desc.contains(value)) {
                    System.out.println(tasks.get(i).toString());
                }
            }
        }
    }

    public String toString() {
        return ("[" + getMark() + "] " + desc);
    }

    /**
     * writes the tasks in the list to a file
     * @throws IOException
     */
    public static void writeToFile() throws IOException {
        File file = new File("data/output.txt");
        file.getParentFile().mkdirs(); // Ensure directory exists

        try (FileWriter fw = new FileWriter(file)) {
            for (int i = 0; i < totalTasks; i++) {
                String taskType = tasks.get(i).type;
                int isMark = tasks.get(i).isDone ? 1 : 0;

                switch (taskType) {
                case "[T]":
                    fw.write("T | " + isMark + " | " + tasks.get(i).desc);
                    break;
                case "[D]":
                    Deadline deadline = (Deadline) tasks.get(i);
                    fw.write("D | " + isMark + " | " + tasks.get(i).desc + " | " + deadline.getBy());
                    break;
                case "[E]":
                    Event event = (Event) tasks.get(i);
                    fw.write("E | " + isMark + " | " + tasks.get(i).desc + " | " + event.getStart() + " | " + event.getEnd());
                    break;
                }
                fw.write(System.lineSeparator());
            }
        }
    }

}
