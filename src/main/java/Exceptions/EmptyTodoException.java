package Exceptions;


public class EmptyTodoException extends Exception {
    public EmptyTodoException(String message) {
        super(message);
    }
}