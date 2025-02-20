package chatbbg.tasktypes;
import java.lang.Exception;
import chatbbg.Extractor;
import Exceptions.EmptyTodoException;

public class Todo extends Task {
    public Todo (String desc) {
        super(desc);
        this.type = "[T]";
    }

    public String getType() {
        return type;
    }

    public static void printTodo (String todo){
        System.out.println("got you x, this TODO task was added to the list: ");
        System.out.println("[T][ ] " + todo);
        System.out.println("anything else?");
    }

    public String toString(){
        return type + super.toString();
    }

    public static void addTodo (String input) throws EmptyTodoException {
        String description = input.substring("todo".length()).trim();
        if (description.isEmpty()) {
            throw new EmptyTodoException();
        }
        Task.tasks.add(new Todo(description));
        Task.totalTasks++;
        Todo.printTodo(Task.tasks.get(totalTasks - 1).desc);
    }
}
