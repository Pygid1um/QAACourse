package homevork4.validator;

import homevork4.exceptions.BadSignValue;
import homevork4.exceptions.NonNumericInputException;

/**
 * Класс отвечает за валидацию введенных чисел и математического знака
 */
public class Validator {

    /**
     * Метод валидирует правильность ввода математического знака
     *
     * @param sign математический знак
     * @return значение параметра sign
     * @throws BadSignValue создается исключение в случае ввода не допустимого математического знака
     */
    public static String validateInputSign(String sign) {
        if (sign == null || !sign.matches("^[+\\-*/]$")) {
            throw new BadSignValue("Вы ввели не правильный математический символ: " + sign);
        }
            return sign;
    }

    /**
     * Метод валидирует правильность ввода чисел
     *
     * @param number число для валидации
     * @return значение параметра number
     * @throws NonNumericInputException создается исключение в случае ввода не допустимого числа
     */
    public static int validateInputNumbers(Long number) {
        if (number == null || !String.valueOf(number).matches("^-?\\d+$")) {
            throw new NonNumericInputException("Введите целочисленное число, а не: " + number);
        }
        if (number < Integer.MIN_VALUE || number > Integer.MAX_VALUE) {
            throw new NonNumericInputException("Введите целочисленное число в диапазоне Integer, а не: " + number);
        }
            return Math.toIntExact(number);
    }
}