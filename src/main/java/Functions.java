import java.util.Scanner;

public class Functions extends Task{

    public Functions(String desc) {
        super(desc);
    }

    public static void readUserInput(){
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        int index = 0;
        while(!line.equalsIgnoreCase("goodbye")){
            if (line.isEmpty()){
                System.out.println("What are ya tryna say babe");
            } else if(line.equalsIgnoreCase("list")){
                Task.printTasks();
            }
            else if (line.contains("mark")||line.contains("unmark")||line.contains("delete")) {
                int indexM = Extractor.extractTaskNumber(line);//index of task to be marked
                Task.modifyTaskTick(indexM, line);
            }
              else {
                Task.tasks[index] = new Task(line);
                Task.totalTasks++;
                Deadline.printDeadline(line);
                index++;
            }
            line = in.nextLine();
        }
        chatBBG.goodbye();
    }
}
