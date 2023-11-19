package homevork4.parametrized;

import homevork4.exceptions.BadSignValue;
import homevork4.exceptions.NonNumericInputException;
import homevork4.validator.Validator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Набор тестов с DataProvider для класса Validator
 */
public class ValidatorDataProvider {

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
     * DataProvider с тестовыми данными для позитивных тестов
     * @return двумерный массив строк(можно выбрать любой тип данных, в зависимости от задачи)
     */
    @DataProvider
    public Object[][] getTestAndExpectedDataValidateSignPositive() {
        return new String[][] {
            {"+", "+"},
            {"-", "-"},
            {"*", "*"},
            {"/", "/"}
        };
    }

    /**
     * DataProvider с тестовыми данными для негативных тестов ввода математических символов
     * @return двумерный массив строк
     */
    @DataProvider
    public Object[][] getTestDataValidateSignNegative() {
        return new String[][] {
                {"Kurwa"},
                {" "},
                {""}
        };
    }

    /**
     * DataProvider с тестовыми данными для негативных тестов ввода чисел
     * @return двумерный массив чисел
     */
    @DataProvider
    public Object[][] getTestDataValidateNumberNegative() {
        return new Integer[][] {
                {-1},
                {10}
        };
    }

    /**
     * Параметризованный позитивный тест ввода математических символов
     * @param actual тестовые данные из DataProvider
     * @param expected ожидаемый результат из DataProvider
     */
    @Test(dataProvider = "getTestAndExpectedDataValidateSignPositive")
    public void testPutDataPositiveValidator(String actual, String expected) {
        validator.validateInputSign(actual);
        assertEquals(actual, expected);
    }

    /**
     * Параметризованный негативный тест ввода математических символов
     * @param actual тестовые данные из DataProvider
     */
    @Test(dataProvider = "getTestDataValidateSignNegative", expectedExceptions = BadSignValue.class)
    public void testPutDataSingNegativeValidator(String actual) {
        validator.validateInputSign(actual);
    }

    /**
     * Параметризованный негативный тест ввода чисел
     * @param actual тестовые данные из DataProvider
     */
    @Test(dataProvider = "getTestDataValidateNumberNegative", expectedExceptions = NonNumericInputException.class)
    public void testPutDataNumberNegativeValidator(int actual) {
        validator.validateInputNumbers(actual);
    }
}