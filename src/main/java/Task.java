import java.util.ArrayList;

public class Task {
    protected static ArrayList<Task> tasks; //stores objects of type Task
    public static int totalTasks;
    protected String desc;
    protected boolean isDone;

    protected String type;

    public static void initializeArray(){
        tasks = new ArrayList<>();
    }

    public Task(String desc){
        this.desc = desc;
        isDone = false;
        //this.type = "T";
    }

    public String getMark(){
        return isDone ? "X" : " ";
    }

    public static void printTasks() {
        for (Task task : tasks){
            System.out.println(task.desc);
        }
    }


}
