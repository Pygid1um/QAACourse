package homevork4.exceptions;

/**
 * Исключение в случае деления на 0
 */
public class DivisionByZero extends RuntimeException{
    public DivisionByZero(String message) {
        super(message);
    }
}