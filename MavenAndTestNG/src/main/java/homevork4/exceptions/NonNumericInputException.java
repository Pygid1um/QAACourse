package homevork4.exceptions;

/**
 * Исключение в случае ввода чисел меньше 0 и больше 9 или ввода не числа
 */
public class NonNumericInputException extends RuntimeException {
    public NonNumericInputException(String message) {
        super(message);
    }
}