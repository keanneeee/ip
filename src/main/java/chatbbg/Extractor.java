public class Extractor {


    public static int extractTaskNumber(String input) {
        String keyword;
        if (input.startsWith("mark")) {
            keyword = "mark";
        } else if (input.startsWith("unmark")) {
            keyword = "unmark";
        } else {
            keyword = "delete";
        }
        String numberString = input.substring(keyword.length()).trim();
        return Integer.parseInt(numberString);
    }

    public static String extractTaskNameTodo(String input) {
        String keyword = "todo";
        return input.substring(keyword.length()).trim();
    }

    public static String extractTaskNameDeadline(String input) {
        String keyword = "/by";
        return input.substring(8, input.indexOf(keyword));
    }

    public static String extractTaskDeadline(String input) {
        String keyword = "/by";
        return input.substring(input.indexOf(keyword) + 4);
    }

    public static String extractTaskNameEvent(String input) {
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
