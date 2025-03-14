package chatbbg.tasktypes;
import chatbbg.Extractor;
import Exceptions.IllegalEventInput;
public class Event extends Task{

    protected String start;
    protected String end;

    public Event(String desc, String start, String end) {
        super(desc);
        this.start = start;
        this.end = end;
        this.type = "[E]";
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    /**
     * Prints the Event task that was added to the list
     * @param Event the Event task that was added
     * @param start the start date of the Event task
     * @param end the end date of the Event task
     */
    public static void printEvent(String Event, String start, String end){
        System.out.println("gotcha x, this EVENT task was added to the list:");
        System.out.println("[E][ ] " + Event + "(from: " + start + " to " + end + ")");
        System.out.println("anything else?");
    }

    public String toString(){
        return type + super.toString().trim() + "(from: " + start + " to " + end + ")";
    }

    /**
     * Adds an Event task to the list of tasks
     * @param input user input
     */
    public static void addEvent(String input){
        try {
            String description = Extractor.extractTaskNameEvent(input);
            String start = Extractor.extractTaskEventStart(input);
            String end = Extractor.extractTaskEventEnd(input);
            Task.tasks.add(new Event(description, start, end));
            Task.totalTasks++;
            Event.printEvent(description, start, end);
        } catch (IllegalEventInput e) {
            System.out.println("Invalid Input for Event. Ensure that format follows " +
            "event [task] [/from] [/to]");
        }
    }
}
