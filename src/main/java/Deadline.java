public class Deadline extends Task {
    protected String by;

    public Deadline(String desc, String by) {
        super(desc);
        this.by = by;
    }

    public String toString(){
        return super.toString() + "by: " + by;
    }

    public String getBy() {
        return by;
    }

    public static void printDeadline(String deadline){
        System.out.println("gotchu x, this was added to the list: " + deadline);
        System.out.println("anything else?");
    }
}
