package homevork4.parametrized;

import homevork4.exceptions.BadSignValue;
import homevork4.exceptions.NonNumericInputException;
import homevork4.validator.Validator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Набор тестов с DataProvider для класса Validator
 */
public class ValidatorTestsWithDataProvider {

    /**
     * DataProvider с тестовыми данными для позитивных тестов
     *
     * @return двумерный массив строк(можно выбрать любой тип данных, в зависимости от задачи)
     */
    @DataProvider
    public Object[][] signPositiveDataProvider() {
        return new String[][]{
                {"+"},
                {"-"},
                {"*"},
                {"/"}
        };
    }

    /**
     * DataProvider с тестовыми данными для негативных тестов ввода математических символов
     *
     * @return двумерный массив строк
     */
    @DataProvider
    public Object[][] signNegativeDataProvider() {
        return new String[][]{
                {"Kurwa"},
                {" "},
                {""}
        };
    }

    /**
     * DataProvider с тестовыми данными для позитивных тестов ввода чисел
     *
     * @return двумерный массив строк
     */
    @DataProvider
    public Object[][] numberPositiveDataProvider() {
        return new String[][]{
                {"-1"},
                {"10"},
                {"0"}
        };
    }

    /**
     * DataProvider с тестовыми данными для негативных тестов ввода чисел
     *
     * @return двумерный массив строк
     */
    @DataProvider
    public Object[][] numberNegativeDataProvider() {
        return new String[][]{
                {"9.1"},
                {""},
                {" "},
                {"Hello there!"}
        };
    }

    /**
     * Параметризованный позитивный тест ввода математических символов
     *
     * @param actual тестовые данные из DataProvider
     */
    @Test(dataProvider = "signPositiveDataProvider")
    public void testPutDataPositiveSing(String actual) {
        String expected = Validator.validateInputSign(actual);
        assertEquals(actual, expected);
    }

    /**
     * Параметризованный негативный тест ввода математических символов
     *
     * @param actual тестовые данные из DataProvider
     */
    @Test(dataProvider = "signNegativeDataProvider", expectedExceptions = BadSignValue.class)
    public void testPutDataNegativeSing(String actual) {
        Validator.validateInputSign(actual);
    }

    /**
     * Параметризованный позитивный тест ввода чисел
     *
     * @param actual тестовые данные из DataProvider
     */
    @Test(dataProvider = "numberPositiveDataProvider")
    public void testPutDataPositiveNumbers(String actual) {
        String expected = Validator.validateInputNumbers(actual);
        assertEquals(actual, expected);
    }

    /**
     * Параметризованный негативный тест ввода чисел
     *
     * @param actual тестовые данные из DataProvider
     */
    @Test(dataProvider = "numberNegativeDataProvider", expectedExceptions = NonNumericInputException.class)
    public void testPutDataNumberNegativeValidator(String actual) {
        Validator.validateInputNumbers(actual);
    }
}