package chatbbg;
public class chatBBG {

    public static void main(String[] args) {
        printWelcomeMessage();
        //Task.initializeArray();
        Functions.readUserInput();
    }

    public static void printWelcomeMessage() {
        System.out.println("I'm JOI");
        System.out.println("You look lonely, I can fix that");
    }

    public static void goodbye(){
        System.out.println("Shutting down...");
    }
}