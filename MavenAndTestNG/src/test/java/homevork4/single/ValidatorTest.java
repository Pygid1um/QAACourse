package homevork4.single;

import homevork4.exceptions.BadSignValue;
import homevork4.exceptions.NonNumericInputException;
import homevork4.validator.Validator;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Набор отдельных тестов для класса Validator
 */
public class ValidatorTest {

    /**
     * Проверка валидации ввода математического знака "+"
     */
    @Test
    public void inputSignPlus() {
        String string = "+";
        String result = Validator.validateInputSign(string);
        assertEquals(result, string);
    }

    /**
     * Проверка валидации ввода математического знака "-"
     */
    @Test
    public void inputSignMinus() {
        String string = "-";
        String result = Validator.validateInputSign(string);
        assertEquals(result, string);
    }

    /**
     * Проверка валидации ввода математического знака "*"
     */
    @Test
    public void inputSignAterisk() {
        String string = "*";
        String result = Validator.validateInputSign(string);
        assertEquals(result, string);
    }

    /**
     * Проверка валидации ввода математического знака "/"
     */
    @Test
    public void inputSignSlash() {
        String string = "/";
        String result = Validator.validateInputSign(string);
        assertEquals(result, string);
    }

    /**
     * Проверка валидации математического знака вводом буквы
     */
    @Test(expectedExceptions = BadSignValue.class)
    public void inputSignWithLetter() {
        String string = "r";
        Validator.validateInputSign(string);
    }

    /**
     * Проверка валидации математического знака пробелом
     */
    @Test(expectedExceptions = BadSignValue.class)
    public void inputSignWithSpace() {
        String string = " ";
        Validator.validateInputSign(string);
    }

    /**
     * Проверка валидации математического знака пустой строкой
     */
    @Test(expectedExceptions = BadSignValue.class)
    public void inputSignWithEmpty() {
        String string = "";
        Validator.validateInputSign(string);
    }

    /**
     * Проверка валидации математического знака значением null
     */
    @Test(expectedExceptions = BadSignValue.class)
    public void inputSignWithNull() {
        String string = null;
        Validator.validateInputSign(string);
    }

    /**
     * Проверка валидации математического знака спец. символом
     */
    @Test(expectedExceptions = BadSignValue.class)
    public void inputSignWithSpecialSymbol() {
        String string = "$";
        Validator.validateInputSign(string);
    }

    /**
     * Проверка валидации математического знака несколькими символами
     */
    @Test(expectedExceptions = BadSignValue.class)
    public void inputSomeSigns() {
        String string = "++";
        Validator.validateInputSign(string);
    }

    /**
     * Проверка валидации положительного числа
     */
    @Test()
    public void inputPositiveNumber() {
        long number = 5L;
        long result = Validator.validateInputNumbers(number);
        assertEquals(number, result);
    }

    /**
     * Проверка валидации отрицательного числа
     */
    @Test()
    public void inputNegativeNumber() {
        long number = -10L;
        long result = Validator.validateInputNumbers(number);
        assertEquals(number, result);
    }

    /**
     * Проверка валидации нуля
     */
    @Test()
    public void inputZeroNumber() {
        long number = 0L;
        long result = Validator.validateInputNumbers(number);
        assertEquals(number, result);
    }

    /**
     * Проверка валидации ввода максимального числа
     */
    @Test()
    public void inputMaxNumber() {
        long number = Integer.MAX_VALUE;
        long result = Validator.validateInputNumbers(number);
        assertEquals(number, result);
    }

    /**
     * Проверка валидации ввода минимального числа
     */
    @Test()
    public void inputMinNumber() {
        long number = Integer.MIN_VALUE;
        long result = Validator.validateInputNumbers(number);
        assertEquals(number, result);
    }

    /**
     * Проверка валидации ввода числа больше максимального
     */
    @Test(expectedExceptions = NonNumericInputException.class)
    public void inputMoreMaxNumber() {
        long number = 2147483648L;
        Validator.validateInputNumbers(number);
    }

    /**
     * Проверка валидации числа меньше минимального
     */
    @Test(expectedExceptions = NonNumericInputException.class)
    public void inputMoreMinNumber() {
        long number = -2147483649L;
        Validator.validateInputNumbers(number);
    }
}