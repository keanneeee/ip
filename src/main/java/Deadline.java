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

    public static void printDeadline(String deadline, String end){
        System.out.println("gotchu x, this DEADLINE task was added to the list:");
        System.out.println("[D][ ]" + deadline + "(by: " + end + ")");
        System.out.println("anything else?");
    }

    public String toString(){
        return type + super.toString().trim() + "(by: " + by + ")";
    }

    public static void addDeadline(String input){
        String description = Extractor.extractTaskNameDeadline(input);
        String end = Extractor.extractTaskDeadline(input);
        Task.tasks[totalTasks] = new Deadline(description, end);
        Task.totalTasks++;
        Deadline.printDeadline(description, end);
    }
}
