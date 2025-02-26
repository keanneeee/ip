package chatbbg;
import Exceptions.IllegalDeadlineInput;
import Exceptions.noTaskNum;
import Exceptions.EmptyTodoException;
import Exceptions.IllegalEventInput;

public class Extractor {

    /**
     * Extracts the task number from the user input(eg. mark 1, extracts 1)
     * @param input user input
     * @return task number
     * @throws noTaskNum when the user input does not contain a task number
     */
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

    /**
     * Extracts the task name from todo input(eg. todo read book, extracts read book)
     * @param input user input
     * @return task name
     */
    public static String extractTaskNameTodo(String input) {
        String keyword = "todo";
        return input.substring(keyword.length()).trim();
    }

    /**
     * Extracts the task name from deadline input(eg. deadline return book /by 2021-09-09, extracts return book)
     * @param input user input
     * @return task name
     * @throws IllegalDeadlineInput when the user input does not contain a deadline
     */
    public static String extractTaskNameDeadline(String input) throws IllegalDeadlineInput {
        String keyword = "/by";
        String[] parts = input.split(keyword);
        if (parts.length < 2) {
            throw new IllegalDeadlineInput();
        } else if (input.substring(input.indexOf(keyword) + 4).isEmpty()||input.substring(8).isEmpty()) {
            throw new IllegalDeadlineInput();
        }
        return input.substring(9, input.indexOf(keyword));
    }
    /**
     * Extracts the task deadline from deadline input(eg. deadline return book /by 2021-09-09, extracts 2021-09-09)
     * @param input user input
     * @return task deadline
     */
    public static String extractTaskDeadline(String input) {
        String keyword = "/by";

        return input.substring(input.indexOf(keyword) + 4);
    }

    /**
     * Extracts the task name from event input(eg. event project meeting /from 2021-09-09 /to 2021-09-10, extracts project meeting)
     * @param input user input
     * @return task name
     * @throws IllegalEventInput when the user input does not contain a task name
     */
    public static String extractTaskNameEvent(String input) throws IllegalEventInput{
        String[] parts = input.split("/from|/to");
        if(parts.length < 3){
            throw new IllegalEventInput();
        }
        String keyword = "/from";
        return input.substring(6, input.indexOf(keyword));
    }

    /**
     * Extracts the start date of the event from event input(eg. event project meeting /from 2021-09-09 /to 2021-09-10, extracts 2021-09-09)
     * @param input user input
     * @return start time of the event
     */
    public static String extractTaskEventStart(String input) {
        String keyword = "/from";
        String keyword2 = "/to";
        return input.substring(input.indexOf(keyword) + 5, input.indexOf(keyword2)).trim();
    }

    /**
     * Extracts the end date of the event from event input(eg. event project meeting /from 2021-09-09 /to 2021-09-10, extracts 2021-09-10)
     * @param input user input
     * @return end time of the event
     */
    public static String extractTaskEventEnd(String input) {
        String keyword = "/to";
        return input.substring(input.indexOf(keyword) + 3).trim();
    }
}
