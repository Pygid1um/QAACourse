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
         if (sign == null) {
            throw new BadSignValue("Вы ввели не правильный математический символ: " + sign);
        } else if (!sign.matches("^[+\\-*/]$")){
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
    public static int validateInputNumbers(long number) {
        String numberString = String.valueOf(number);
        if (numberString.matches("^-?\\d+$")) {
            long validatedNumber = Long.parseLong(numberString);
            if (validatedNumber >= Integer.MIN_VALUE && validatedNumber <= Integer.MAX_VALUE) {
                return (int) number;
            } else {
                throw new NonNumericInputException("Введите целочисленное число входящее в диапазон Integer, а не: " + number);
            }
        } else {
            throw new NonNumericInputException("Введите целочисленное число входящее в диапазон Integer, а не: " + number);
        }
    }
}