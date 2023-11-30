package homework4.exceptions;

/**
 * Исключение в случае ввода некорректного математического знака
 */
public class BadSignValue extends RuntimeException {
    public BadSignValue(String message) {
        super(message);
    }
}