package homevork4.single;

import homevork4.exceptions.BadSignValue;
import homevork4.exceptions.NonNumericInputException;
import homevork4.validator.Validator;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Набор отдельных тестов для класса Validator
 */
@Epic("Validator. Single tests")
@Owner("Будущий автотестер, Аносов Д.С.")
public class ValidatorTest {

    /**
     * Проверка валидации ввода математического знака "+"
     */
    @Feature("Проверка ввода математического знака")
    @Story("Проверка ввода знака плюс")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Тест проверяет введен ли математический знак \"плюс\" для суммы")
    @Test(description = "Проверка ввода математического знака плюс")
    public void inputSignPlus() {
        String string = "+";
        String result = Validator.validateInputSign(string);
        assertEquals(result, string);
    }

    /**
     * Проверка валидации ввода математического знака "-"
     */
    @Feature("Проверка ввода математического знака")
    @Story("Проверка ввода знака минус")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Тест проверяет введен ли математический знак \"минус\" для разности")
    @Test(description = "Проверка ввода математического знака минус")
    public void inputSignMinus() {
        String string = "-";
        String result = Validator.validateInputSign(string);
        assertEquals(result, string);
    }

    /**
     * Проверка валидации ввода математического знака "*"
     */
    @Feature("Проверка ввода математического знака")
    @Story("Проверка ввода знака звездочка")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Тест проверяет введен ли математический знак \"звездочка\" для умножения")
    @Test(description = "Проверка ввода математического знака звездочка")
    public void inputSignAterisk() {
        String string = "*";
        String result = Validator.validateInputSign(string);
        assertEquals(result, string);
    }

    /**
     * Проверка валидации ввода математического знака "/"
     */
    @Feature("Проверка ввода математического знака")
    @Story("Проверка ввода знака слэш")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Тест проверяет введен ли математический знак \"слэш\" для деления")
    @Test(description = "Проверка ввода математического знака слэш")
    public void inputSignSlash() {
        String string = "/";
        String result = Validator.validateInputSign(string);
        assertEquals(result, string);
    }

    /**
     * Проверка валидации математического знака вводом буквы
     */
    @Feature("Проверка ввода математического знака")
    @Story("Проверка ввода буквы")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Негативная проверка. Тест проверяет валидацию ввода математического символа буквой")
    @Test(expectedExceptions = BadSignValue.class, description = "Проверка ввода математического знака буквой")
    public void inputSignWithLetter() {
        String string = "r";
        Validator.validateInputSign(string);
    }

    /**
     * Проверка валидации математического знака пробелом
     */
    @Feature("Проверка ввода математического знака")
    @Story("Проверка ввода пробела")
    @Severity(SeverityLevel.MINOR)
    @Description("Негативная проверка. Тест проверяет валидацию ввода математического символа пробелом")
    @Test(expectedExceptions = BadSignValue.class, description = "Проверка ввода математического знака пробелом")
    public void inputSignWithSpace() {
        String string = " ";
        Validator.validateInputSign(string);
    }

    /**
     * Проверка валидации математического знака пустой строкой
     */
    @Feature("Проверка ввода математического знака")
    @Story("Проверка ввода пустой строки")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Негативная проверка. Тест проверяет валидацию ввода математического символа пустой строкой")
    @Test(expectedExceptions = BadSignValue.class, description = "Проверка ввода математического знака пустой строки")
    public void inputSignWithEmpty() {
        String string = "";
        Validator.validateInputSign(string);
    }

    /**
     * Проверка валидации математического знака значением null
     */
    @Feature("Проверка ввода математического знака")
    @Story("Проверка ввода null")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Негативная проверка. Тест проверяет валидацию ввода математического символа null")
    @Test(expectedExceptions = BadSignValue.class, description = "Проверка ввода математического знака значением null")
    public void inputSignWithNull() {
        String string = null;
        Validator.validateInputSign(string);
    }

    /**
     * Проверка валидации математического знака спец. символом
     */
    @Feature("Проверка ввода математического знака")
    @Story("Проверка ввода спец. символа")
    @Severity(SeverityLevel.TRIVIAL)
    @Description("Негативная проверка. Тест проверяет валидацию ввода математического символа спец. символом")
    @Test(expectedExceptions = BadSignValue.class, description = "Проверка ввода математического знака спец. символом")
    public void inputSignWithSpecialSymbol() {
        String string = "$";
        Validator.validateInputSign(string);
    }

    /**
     * Проверка валидации математического знака несколькими символами
     */
    @Feature("Проверка ввода математического знака")
    @Story("Проверка ввода нескольких знаков")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Негативная проверка. Тест проверяет валидацию ввода математического символа несколькими символами")
    @Test(expectedExceptions = BadSignValue.class, description = "Проверка ввода нескольких математический знаков")
    public void inputSomeSigns() {
        String string = "++";
        Validator.validateInputSign(string);
    }

    /**
     * Проверка валидации положительного числа
     */
    @Feature("Проверка ввода числа")
    @Story("Проверка ввода положительного числа")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Тест проверяет валидацию ввода числа положительным числом")
    @Test(description = "Проверка вводимого числа положительным числом")
    public void inputPositiveNumber() {
        long number = 5L;
        long result = Validator.validateInputNumbers(number);
        assertEquals(number, result);
    }

    /**
     * Проверка валидации отрицательного числа
     */
    @Feature("Проверка ввода числа")
    @Story("Проверка ввода отрицательного числа")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Тест проверяет валидацию ввода числа отрицательным числом")
    @Test(description = "Проверка вводимого числа отрицательным числом")
    public void inputNegativeNumber() {
        long number = -10L;
        long result = Validator.validateInputNumbers(number);
        assertEquals(number, result);
    }

    /**
     * Проверка валидации нуля
     */
    @Feature("Проверка ввода числа")
    @Story("Проверка ввода нуля")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Тест проверяет валидацию ввода числа нулем")
    @Test(description = "Проверка вводимого числа нулем")
    public void inputZeroNumber() {
        long number = 0L;
        long result = Validator.validateInputNumbers(number);
        assertEquals(number, result);
    }

    /**
     * Проверка валидации ввода максимального числа
     */
    @Feature("Проверка ввода числа")
    @Story("Проверка ввода максимального числа")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Тест проверяет валидацию ввода максимального числа")
    @Test(description = "Проверка вводимого числа максимальным числом")
    public void inputMaxNumber() {
        long number = Integer.MAX_VALUE;
        long result = Validator.validateInputNumbers(number);
        assertEquals(number, result);
    }

    /**
     * Проверка валидации ввода минимального числа
     */
    @Feature("Проверка ввода числа")
    @Story("Проверка ввода минимального числа")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Тест проверяет валидацию ввода минимального числа")
    @Test(description = "Проверка вводимого числа минимальным числом")
    public void inputMinNumber() {
        long number = Integer.MIN_VALUE;
        long result = Validator.validateInputNumbers(number);
        assertEquals(number, result);
    }

    /**
     * Проверка валидации ввода числа больше максимального
     */
    @Feature("Проверка ввода числа")
    @Story("Проверка ввода числа больше максимального")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Негативная проверка. Тест проверяет валидацию ввода числа больше максимального")
    @Test(expectedExceptions = NonNumericInputException.class, description = "Проверка вводимого числа больше максимального")
    public void inputMoreMaxNumber() {
        long number = 2147483648L;
        Validator.validateInputNumbers(number);
    }

    /**
     * Проверка валидации числа меньше минимального
     */
    @Feature("Проверка ввода числа")
    @Story("Проверка ввода числа меньше минимального")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Негативная проверка. Тест проверяет валидацию ввода числа меньше минимального")
    @Test(expectedExceptions = NonNumericInputException.class, description = "Проверка вводимого числа меньше минимального")
    public void inputMoreMinNumber() {
        long number = -2147483649L;
        Validator.validateInputNumbers(number);
    }
}