package chatbbg;

import chatbbg.tasktypes.Deadline;
import chatbbg.tasktypes.Event;
import chatbbg.tasktypes.Todo;
import chatbbg.tasktypes.Task;
import java.util.Scanner;
import Exceptions.EmptyTodoException;
import Exceptions.noTaskNum;

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
            } else if (line.equalsIgnoreCase("list")){
                Task.printTasks();
            } else if (line.startsWith("mark")||line.startsWith("unmark")||line.startsWith("delete")) {
                try {
                    int indexM = Extractor.extractTaskNumber(line);//index of task to be marked
                    Task.modifyTaskTick(indexM - 1, line);
                } catch (IndexOutOfBoundsException e){
                    System.out.println("bro your number not even in the list");
                    System.out.println(">:(");
                } catch (NumberFormatException e){
                    System.out.println("bro you need to enter a number");
                    System.out.println(">:(");
                } catch (noTaskNum e) {
                    System.out.println(">:(");
                }
            } else if (line.startsWith("deadline")){
                Deadline.addDeadline(line);
            } else if (line.startsWith("todo")){
               try {
                   Todo.addTodo(line);
               } catch (EmptyTodoException e){
                     System.out.println(">:(");
                }
            } else if (line.startsWith("event")) {
                Event.addEvent(line);
            } else if (line.startsWith("find")) {
                Task.findTask(line);
            } else {
                System.out.println("Please enter a valid command");
            }
            line = in.nextLine();

        }
        chatBBG.goodbye();
    }
}
