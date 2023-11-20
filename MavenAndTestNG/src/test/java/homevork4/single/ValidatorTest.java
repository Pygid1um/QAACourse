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
     * Проверка валидации положительного числа
     */
    @Test()
    public void inputPositiveNumber() {
        String number = "5";
        String result = Validator.validateInputNumbers(number);
        assertEquals(number, result);
    }

    /**
     * Проверка валидации отрицательного числа
     */
    @Test()
    public void inputNegativeNumber() {
        String number = "-1";
        String result = Validator.validateInputNumbers(number);
        assertEquals(number, result);
    }

    /**
     * Проверка валидации нуля
     */
    @Test()
    public void inputZeroNumber() {
        String number = "0";
        String result = Validator.validateInputNumbers(number);
        assertEquals(number, result);
    }

    /**
     * Проверка валидации ввода дробного число
     */
    @Test(expectedExceptions = NonNumericInputException.class)
    public void inputFloatNumber() {
        String number = "4.3";
        Validator.validateInputNumbers(number);
    }

    /**
     * Проверка валидации ввода пустой строки вместо числа
     */
    @Test(expectedExceptions = NonNumericInputException.class)
    public void inputNumberWithEmpty() {
        String number = "";
        Validator.validateInputNumbers(number);
    }

    /**
     * Проверка валидации ввода пробела вместо числа
     */
    @Test(expectedExceptions = NonNumericInputException.class)
    public void inputNumberWithSpase() {
        String number = " ";
        Validator.validateInputNumbers(number);
    }

    /**
     * Проверка валидации ввода пробела вместо числа
     */
    @Test(expectedExceptions = NonNumericInputException.class)
    public void inputNumberWithLetter() {
        String number = "I'am an autotOster";
        Validator.validateInputNumbers(number);
    }
}