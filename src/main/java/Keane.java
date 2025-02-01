import java.util.Arrays;
import java.util.Scanner;

public class Keane {

    private void goodbye(String[] arg){
        System.out.println("Bye! Hope to see you again soon!");
    }

    public static void main(String[] args) {
        String bye = "bye";
        String[] words = new String[100];
        System.out.println("Hello! I'm Keane.");
        System.out.println("What is up fella?");
        Scanner in = new Scanner(System.in);
        int count = 0;


        while (true){
            String line = in.nextLine();
            if (line.equalsIgnoreCase(bye)){
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else if (line.equalsIgnoreCase("list")){
                for (String word : words) {
                    if (word != null) {
                        System.out.println(word);
                    }
                }
            }
            else {
                words[count] = count+1 + ". " + line;
                count++;
                System.out.println("Added: "+ line);
            }
        }
        in.close();
    }
}
