package chatbbg.tasktypes;
import Exceptions.IllegalDeadlineInput;
import chatbbg.Extractor;

public class Deadline extends Task {
    protected String by;

    public Deadline(String desc, String end) {
        super(desc);
        this.by = end;
        this.type = "[D]";
    }


    public String getBy() {
        return by;
    }

    /**
     * Prints the Deadline task that was added to the list
     * @param deadline the Deadline task that was added
     * @param end the end date of the Deadline task
     */
    public static void printDeadline(String deadline, String end){
        System.out.println("gotchu x, this DEADLINE task was added to the list:");
        System.out.println("[D][ ] " + deadline + "(by: " + end + ")");
        System.out.println("anything else?");
    }

    public String toString(){
        return type + super.toString().trim() + "(by: " + by + ")";
    }

    /**
     * Adds a Deadline task to the list of tasks
     * @param input user input
     */
    public static void addDeadline(String input){
        try {
            String description = Extractor.extractTaskNameDeadline(input);
            String end = Extractor.extractTaskDeadline(input);
            Task.tasks.add(new Deadline(description, end));
            Task.totalTasks++;
            Deadline.printDeadline(description, end);
        } catch (IllegalDeadlineInput e){
            System.out.println("Invalid Input for Deadline. Ensure that format follows " +
                    "deadline [task] [/by]");
        }
    }
}
