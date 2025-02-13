import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;

public class Task {
    //protected static ArrayList<Task> tasks; //stores objects of type Task
    protected static Task[] tasks = new Task[100];
    public static int totalTasks = 0;
    protected  String desc;
    protected static boolean isDone;
    protected String type;

//    public static void initializeArray(){
//        tasks = new ArrayList<>();
//    }

    public Task(String desc){
        this.desc = desc;
        isDone = false;
        //this.type = "T";
    }

    public static String getMark(){
        return isDone ? "X" : " ";
    }

    public static void printTasks() {
        System.out.println("here are your tasks: ");
        int index = 1;
        for (int i = 0; i < totalTasks;  i++){
            System.out.println(index + ". " + tasks[i].toString());
            index++;
        }
    }

    public static void modifyTaskTick(int index, String line){
        if (line.startsWith("mark")){
            tasks[index].isDone = true;
            printMarked(index, line);
        } else if (line.startsWith("unmark")){
            tasks[index].isDone = false;
            printMarked(index, line);
        } else if (line.startsWith("delete")){
            System.out.println("deleted it for ya :)");
            System.out.println(tasks[index].toString());
            tasks[index] = null;
            totalTasks--;
        }
    }

    public static void printMarked(int index, String line){
        if (line.startsWith("mark")){
            System.out.println("marked it for ya <3");
            System.out.println(tasks[index].toString());
        } else if (line.startsWith("unmark")){
            System.out.println("unmarked it for ya ;)");
            System.out.println(tasks[index].toString());
        }
    }

    public String toString(){
        return ("[" + getMark() + "] " + desc);
    }
}
