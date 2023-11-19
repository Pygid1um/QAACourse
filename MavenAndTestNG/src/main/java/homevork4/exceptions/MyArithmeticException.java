package homevork4.exceptions;

/**
 * Исключение в случае деления на 0
 */
public class MyArithmeticException extends RuntimeException{
    public MyArithmeticException(String message) {
        super(message);
    }
}