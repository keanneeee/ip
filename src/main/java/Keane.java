import java.util.Scanner;

public class Keane {

    private void goodbye(String[] arg){
        System.out.println("Bye! Hope to see you again soon!");
    }

    public static void main(String[] args) {
        String bye = "bye";
        System.out.println("Hello! I'm Keane.");
        System.out.println("What can I do for you?");
        Scanner in = new Scanner(System.in);
        while (true){
            String line = in.nextLine();

            if (line.equalsIgnoreCase(bye)){
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else {
                System.out.println(line);
            }
        }
        in.close();
    }
}
