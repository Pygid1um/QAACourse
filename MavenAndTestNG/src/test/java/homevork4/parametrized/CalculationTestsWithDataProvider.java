package homevork4.parametrized;

import homevork4.calculations.Calculations;
import homevork4.exceptions.DivisionByZero;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Набор тестов с DataProvider для класса Calculation
 */
public class CalculationTestsWithDataProvider {

    /**
     * Создание переменной с классом Calculations
     */
    private Calculations calculations;

    /**
     * Метод, который выполняется перед каждым тестом, создает объект класса Calculations
     */
    @BeforeMethod
    public void setCalculations() {
        calculations = new Calculations();
    }

    /**
     * DataProvider с тестовыми данными для позитивных тестов суммы чисел
     *
     * @return двумерный массив чисел
     */
    @DataProvider
    public Object[][] sumPositiveDataProvider() {
        return new String[][]{
                {"4", "6", "10"},
                {"-3", "-6", "-9"},
                {"0", "0", "0"}
        };
    }

    /**
     * DataProvider с тестовыми данными для позитивных тестов разности чисел
     *
     * @return двумерный массив чисел
     */
    @DataProvider
    public Object[][] subtractionPositiveDataProvider() {
        return new String[][]{
                {"8", "6", "2"},
                {"-8", "-6", "-2"},
                {"0", "0", "0"}
        };
    }

    /**
     * DataProvider с тестовыми данными для позитивных тестов произведения чисел
     *
     * @return двумерный массив чисел
     */
    @DataProvider
    public Object[][] multiplicationPositiveDataProvider() {
        return new String[][]{
                {"4", "4", "16"},
                {"-4", "-6", "24"},
                {"0", "0", "0"}
        };
    }

    /**
     * DataProvider с тестовыми данными для позитивных тестов деления чисел
     *
     * @return двумерный массив чисел
     */
    @DataProvider
    public Object[][] divisionPositiveDataProvider() {
        return new String[][]{
                {"4", "2", "2"},
                {"-8", "-2", "4"}
        };
    }

    /**
     * DataProvider с тестовыми данными для негативных тестов деления чисел
     *
     * @return двумерный массив чисел
     */
    @DataProvider
    public Object[][] divisionNegativeDataProvider() {
        return new String[][]{
                {"0", "0"}
        };
    }

    /**
     * Параметризованный позитивный тест расчета суммы
     *
     * @param firstNumber    первое число из тестовых данных DataProvider
     * @param secondNumber   второе число из тестовых данных DataProvider
     * @param expectedResult ожидаемый результат из DataProvider
     */
    @Test(dataProvider = "sumPositiveDataProvider")
    public void testPutDataPositiveSum(String firstNumber, String secondNumber, String expectedResult) {
        String result = calculations.sum(firstNumber, secondNumber);
        assertEquals(result, expectedResult);
    }

    /**
     * Параметризованный позитивный тест расчета разности
     *
     * @param firstNumber    первое число из тестовых данных DataProvider
     * @param secondNumber   второе число из тестовых данных DataProvider
     * @param expectedResult ожидаемый результат из DataProvider
     */
    @Test(dataProvider = "subtractionPositiveDataProvider")
    public void testPutDataPositiveSubtraction(String firstNumber, String secondNumber, String expectedResult) {
        String result = calculations.subtraction(firstNumber, secondNumber);
        assertEquals(result, expectedResult);
    }

    /**
     * Параметризованный позитивный тест расчета произведения
     *
     * @param firstNumber    первое число из тестовых данных DataProvider
     * @param secondNumber   второе число из тестовых данных DataProvider
     * @param expectedResult ожидаемый результат из DataProvider
     */
    @Test(dataProvider = "multiplicationPositiveDataProvider")
    public void testPutDataPositiveMultiplication(String firstNumber, String secondNumber, String expectedResult) {
        String result = calculations.multiplication(firstNumber, secondNumber);
        assertEquals(result, expectedResult);
    }

    /**
     * Параметризованный позитивный тест расчета деления
     *
     * @param firstNumber    первое число из тестовых данных DataProvider
     * @param secondNumber   второе число из тестовых данных DataProvider
     * @param expectedResult ожидаемый результат из DataProvider
     */
    @Test(dataProvider = "divisionPositiveDataProvider")
    public void testPutDataPositiveDivision(String firstNumber, String secondNumber, String expectedResult) {
        String result = calculations.division(firstNumber, secondNumber);
        assertEquals(result, expectedResult);
    }

    /**
     * Параметризованный негативный тест расчета деления
     *
     * @param firstNumber  первое число из тестовых данных DataProvider
     * @param secondNumber второе число из тестовых данных DataProvider
     */
    @Test(dataProvider = "divisionNegativeDataProvider", expectedExceptions = DivisionByZero.class)
    public void testPutDataNegativeCalculation(String firstNumber, String secondNumber) {
        calculations.division(firstNumber, secondNumber);
    }
}