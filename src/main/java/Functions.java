import java.util.Scanner;
public class Functions extends Tasks{

    public static void readUserInput(){
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        while(!line.equalsIgnoreCase("goodbye")){
            if (line.isEmpty()){
                System.out.println("What are ya tryna say babe");
            } else if(line.equalsIgnoreCase("list")){
                Task.printTasks();
            } else if(line.equalsIgnoreCase("deadline")){
                Deadline.printDeadline()
            }
        }
    }

}
