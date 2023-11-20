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
        if (sign.matches("[+\\-*/]")) {
            return sign;
        } else {
            throw new BadSignValue("Вы ввели не правильный математический символ: " + sign);
        }
    }

    /**
     * Метод валидирует правильность ввода чисел
     *
     * @param number число для валидации
     * @return значение параметра number
     * @throws NonNumericInputException создается исключение в случае ввода не допустимого числа
     */
    public static String validateInputNumbers(String number) {
        if (number.matches("^-?(0|[1-9]\\d{0,9})$")) {
            if (Integer.parseInt(number) >= Integer.MIN_VALUE || Integer.parseInt(number) <= Integer.MAX_VALUE) {
                return number;
            }
        } else {
            throw new NonNumericInputException("Введите целочисленное число входящее в диапазон Integer, а не: " + number);
        }
        return number;
    }
}