package homevork4.exceptions;

/**
 * Исключение в случае ввода числа выходящего за переделы диапазона Integer или ввода не числа
 */
public class NonNumericInputException extends RuntimeException {
    public NonNumericInputException(String message) {
        super(message);
    }
}