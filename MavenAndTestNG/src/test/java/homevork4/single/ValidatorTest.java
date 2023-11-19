package homevork4.single;

import homevork4.exceptions.BadSignValue;
import homevork4.exceptions.NonNumericInputException;
import homevork4.validator.Validator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Набор отдельных тестов для класса Validator
 */
public class ValidatorTest {

    /**
     * Создание переменной с классом Validator
     */
    private Validator validator;

     /**
     * Метод, который выполняется перед каждым тестом, создает объект класса Validator
     */
    @BeforeMethod
    public void setValidator() {
        validator = new Validator();
    }

    /**
     * Проверка валидации ввода математического знака "+"
     */
    @Test
    public void validateInputSignPlus() {
        String string = "+";
        String result = validator.validateInputSign(string);
        assertEquals(result, string);
    }

    /**
     * Проверка валидации ввода математического знака "-"
     */
    @Test
    public void validateInputSignMinus() {
        String string = "-";
        String result = validator.validateInputSign(string);
        assertEquals(result, string);
    }

    /**
     * Проверка валидации ввода математического знака "*"
     */
    @Test
    public void validateInputSignAterisk() {
        String string = "*";
        String result = validator.validateInputSign(string);
        assertEquals(result, string);
    }

    /**
     * Проверка валидации ввода математического знака "/"
     */
    @Test
    public void validateInputSignSlash() {
        String string = "/";
        String result = validator.validateInputSign(string);
        assertEquals(result, string);
    }

    /**
     * Проверка валидации ввода буквы
     */
    @Test(expectedExceptions = BadSignValue.class)
    public void validateInputWithLetter() {
        String string = "r";
        validator.validateInputSign(string);
    }

    /**
     * Проверка валидации строки с пробелом
     */
    @Test(expectedExceptions = BadSignValue.class)
    public void validateInputWithSpace() {
        String string = " ";
        validator.validateInputSign(string);
    }

    /**
     * Проверка валидации строки с пустой строкой
     */
    @Test(expectedExceptions = BadSignValue.class)
    public void validateInputWithEmpty() {
        String string = "";
        validator.validateInputSign(string);
    }

    /**
     * Проверка валидации числа входящего в диапазон
     */
    @Test()
    public void validateInputNumberPositive() {
        int number = 5;
        validator.validateInputNumbers(number);
    }

    /**
     * Проверка валидации числа меньше диапазона
     */
    @Test(expectedExceptions = NonNumericInputException.class)
        public void validateInputNegativeNumber() {
        int number = -1;
        validator.validateInputNumbers(number);
    }

    /**
     * Проверка валидации числа больше диапазона
     */
    @Test(expectedExceptions = NonNumericInputException.class)
    public void validateInputBigNumber() {
        int number = 10;
        validator.validateInputNumbers(number);
    }
}