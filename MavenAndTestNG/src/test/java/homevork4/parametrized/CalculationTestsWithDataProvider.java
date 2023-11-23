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
        return new Integer[][]{
                {4, 6, 10},
                {-3, -6, -9},
                {11, 0, 11},
                {0, 0, 0}
        };
    }

    /**
     * DataProvider с тестовыми данными для позитивных тестов разности чисел
     *
     * @return двумерный массив чисел
     */
    @DataProvider
    public Object[][] subtractionPositiveDataProvider() {
        return new Integer[][]{
                {8, 6, 2},
                {-8, -6, -2},
                {0, -6, 6},
                {0, 0, 0}
        };
    }

    /**
     * DataProvider с тестовыми данными для позитивных тестов произведения чисел
     *
     * @return двумерный массив чисел
     */
    @DataProvider
    public Object[][] multiplicationPositiveDataProvider() {
        return new Integer[][]{
                {4, 4, 16},
                {-4, -6, 24},
                {44, 0, 0},
                {0, 0, 0}
        };
    }

    /**
     * DataProvider с тестовыми данными для позитивных тестов деления чисел
     *
     * @return двумерный массив чисел
     */
    @DataProvider
    public Object[][] divisionPositiveDataProvider() {
        return new Integer[][]{
                {4, 2, 2},
                {-8, -2, 4},
                {0, -2, 0}
        };
    }

    /**
     * DataProvider с тестовыми данными для негативных тестов деления чисел
     *
     * @return двумерный массив чисел
     */
    @DataProvider
    public Object[][] divisionNegativeDataProvider() {
        return new Integer[][]{
                {0}
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
    public void testPutDataPositiveSum(int firstNumber, int secondNumber, int expectedResult) {
        int result = calculations.sum(firstNumber, secondNumber);
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
    public void testPutDataPositiveSubtraction(int firstNumber, int secondNumber, int expectedResult) {
        int result = calculations.subtraction(firstNumber, secondNumber);
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
    public void testPutDataPositiveMultiplication(int firstNumber, int secondNumber, int expectedResult) {
        int result = calculations.multiplication(firstNumber, secondNumber);
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
    public void testPutDataPositiveDivision(int firstNumber, int secondNumber, int expectedResult) {
        int result = calculations.division(firstNumber, secondNumber);
        assertEquals(result, expectedResult);
    }

    /**
     * Параметризованный негативный тест расчета деления
     *
     * @param number число из тестовых данных DataProvider
     */
    @Test(dataProvider = "divisionNegativeDataProvider", expectedExceptions = DivisionByZero.class)
    public void testPutDataNegativeCalculation(int number) {
        calculations.division(number, number);
    }
}