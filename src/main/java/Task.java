import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;

public class Task {
    //protected static ArrayList<Task> tasks; //stores objects of type Task
    protected static Task[] tasks = new Task[100];
    public static int totalTasks;
    protected String desc;
    protected boolean isDone;

    protected String type;

//    public static void initializeArray(){
//        tasks = new ArrayList<>();
//    }

    public Task(String desc){
        this.desc = desc;
        isDone = false;
        //this.type = "T";
    }

    public String getMark(){
        return isDone ? "X" : " ";
    }

    public static void printTasks() {
        System.out.println("here are your tasks: ");
        int index = 1;
        for (int i = 0; i < totalTasks;  i ++){
            System.out.println(index + ". " + Task.tasks[i]);
            index++;
        }
    }

    public static void modifyTaskTick(int index, String line){
        if (line.startsWith("mark")){
            tasks[index - 1].isDone = true;
            printMarked(index, line);
        }
    }

    public static void printMarked(int index, String line){
        if (line.startsWith("mark")){
            System.out.println("marked it for ya <3");
            System.out.println(tasks[index - 1].toString());
        }
        else {
            System.out.println("unmarked it for ya ;)");
            System.out.println(tasks[index - 1].toString());
        }
    }

    public String toString(){
        return ("[" + getMark() + "] " + desc);
    }
}
