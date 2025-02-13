public class Todo extends Task {
    public Todo (String desc) {
        super(desc);
        this.type = "[T]";
    }

    public String getType() {
        return type;
    }

    public static void printTodo (String todo){
        System.out.println("gotchu x, this TODO task was added to the list: ");
        System.out.println("[T][ ] " + todo);
        System.out.println("anything else?");
    }

    public String toString(){
        return type + super.toString();
    }

    public static void addTodo (String input){
        String description = input.substring("todo".length()).trim();
        Task.tasks[totalTasks] = new Todo(description);
        Task.totalTasks++;
        Todo.printTodo(Task.tasks[totalTasks - 1].desc);
    }
}
