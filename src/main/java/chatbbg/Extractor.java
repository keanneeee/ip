package chatbbg;
import Exceptions.IllegalDeadlineInput;
import Exceptions.noTaskNum;
import Exceptions.EmptyTodoException;
import Exceptions.IllegalEventInput;

public class Extractor {


    public static int extractTaskNumber(String input) throws noTaskNum {
        String keyword;
        if (input.startsWith("mark")) {
            keyword = "mark";
        } else if (input.startsWith("unmark")) {
            keyword = "unmark";
        } else {
            keyword = "delete";
        }
        String numberString = input.substring(keyword.length()).trim();
        if (numberString.isEmpty()) {
            throw new noTaskNum();
        }
        return Integer.parseInt(numberString);
    }

    public static String extractTaskNameTodo(String input) {
        String keyword = "todo";
        return input.substring(keyword.length()).trim();
    }

    public static String extractTaskNameDeadline(String input) throws IllegalDeadlineInput {
        String keyword = "/by";
        String[] parts = input.split(keyword);
        if (parts.length < 2) {
            throw new IllegalDeadlineInput();
        } else if (input.substring(input.indexOf(keyword) + 4).isEmpty()||input.substring(8).isEmpty()) {
            throw new IllegalDeadlineInput();
        }
        return input.substring(8, input.indexOf(keyword));
    }

    public static String extractTaskDeadline(String input) {
        String keyword = "/by";

        return input.substring(input.indexOf(keyword) + 4);
    }

    public static String extractTaskNameEvent(String input) throws IllegalEventInput{
        String[] parts = input.split("/from|/to");
        if(parts.length < 3){
            throw new IllegalEventInput();
        }
        String keyword = "/from";
        return input.substring(6, input.indexOf(keyword));
    }

    public static String extractTaskEventStart(String input) {
        String keyword = "/from";
        String keyword2 = "/to";
        return input.substring(input.indexOf(keyword) + 5, input.indexOf(keyword2)).trim();
    }

    public static String extractTaskEventEnd(String input) {
        String keyword = "/to";
        return input.substring(input.indexOf(keyword) + 3).trim();
    }
}
