package homevork4.validator;

import homevork4.exceptions.BadSignValue;
import homevork4.exceptions.NonNumericInputException;

/**
 * Класс отвечает за валидацию введенных чисел и математического знака
 */
public class Validator {

    /**
     * Метод валидирует правильность ввода математического знака
     * @param sign математический знак
     * @return значение параметра sign
     * @throws BadSignValue создается исключение в случае ввода не допустимого математического знака
     */
    public String validateInputSign(String sign) {
        if (sign.matches("[+\\-*/]")) {
            return sign;
        } else {
            throw new BadSignValue("Вы ввели не правильный математический символ: " + sign);
        }
    }

    /**
     * Метод валидирует правильность ввода чисел
     * @param number число для валидации
     * @return значение параметра number
     * @throws NonNumericInputException создается исключение в случае ввода не допустимого числа
     */
    public int validateInputNumbers(int number) {
        String numberString = String.valueOf(number);
        if (numberString.matches("[0-9]")) {
            return Integer.parseInt(numberString);
        } else {
            throw new NonNumericInputException("Вы ввели не число или нельзя вводить числа меньше 0 и больше 9: " + number);
        }
    }
}