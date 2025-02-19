package Exceptions;

public class EmptyTodoException extends Exception {
    public EmptyTodoException() {
        System.out.println("Todo cannot be empty! Please key in input in this format [Todo] [task]");
        System.out.println("example: todo hang clothes");

    }
}