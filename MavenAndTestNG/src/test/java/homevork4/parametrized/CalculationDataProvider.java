package homevork4.parametrized;

import homevork4.calculations.Calculations;
import homevork4.exceptions.MyArithmeticException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Набор тестов с DataProvider для класса Calculation
 */
public class CalculationDataProvider {

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
     * @return двумерный массив чисел
     */
    @DataProvider
    public Object[][] getTestAndExpectedDataCalculationSumPositive() {
        return new Integer[][] {
                {4, 6, 10},
                {0, 0, 0}
        };
    }

    /**
     * DataProvider с тестовыми данными для позитивных тестов разности чисел
     * @return двумерный массив чисел
     */
    @DataProvider
    public Object[][] getTestAndExpectedDataCalculationSubtractionPositive() {
        return new Integer[][] {
                {8, 6, 2},
                {0, 0, 0}
        };
    }

    /**
     * DataProvider с тестовыми данными для позитивных тестов произведения чисел
     * @return двумерный массив чисел
     */
    @DataProvider
    public Object[][] getTestAndExpectedDataCalculationMultiplicationPositive() {
        return new Integer[][] {
                {4, 4, 16},
                {0, 0, 0}
        };
    }

    /**
     * DataProvider с тестовыми данными для негативных тестов деления чисел
     * @return двумерный массив чисел
     */
    @DataProvider
    public Object[][] getTestAndExpectedDataCalculationDivisionNegative() {
        return new Integer[][] {
                {0, 0},
        };
    }

    /**
     * Параметризованный позитивный тест расчета суммы
     * @param firstNumber первое число из тестовых данных DataProvider
     * @param secondNumber второе число из тестовых данных DataProvider
     * @param expectedResult ожидаемый результат из DataProvider
     */
    @Test(dataProvider = "getTestAndExpectedDataCalculationSumPositive")
    public void testPutDataPositiveSumCalculation(int firstNumber, int secondNumber, int expectedResult) {
        int result = calculations.sum(firstNumber, secondNumber);
        assertEquals(result, expectedResult);
    }

    /**
     * Параметризованный позитивный тест расчета разности
     * @param firstNumber первое число из тестовых данных DataProvider
     * @param secondNumber второе число из тестовых данных DataProvider
     * @param expectedResult ожидаемый результат из DataProvider
     */
    @Test(dataProvider = "getTestAndExpectedDataCalculationSubtractionPositive")
    public void testPutDataPositiveSubtractionCalculation(int firstNumber, int secondNumber, int expectedResult) {
        int result = calculations.subtraction(firstNumber, secondNumber);
        assertEquals(result, expectedResult);
    }

    /**
     * Параметризованный позитивный тест расчета произведения
     * @param firstNumber первое число из тестовых данных DataProvider
     * @param secondNumber второе число из тестовых данных DataProvider
     * @param expectedResult ожидаемый результат из DataProvider
     */
    @Test(dataProvider = "getTestAndExpectedDataCalculationMultiplicationPositive")
    public void testPutDataPositiveMultiplicationCalculation(int firstNumber, int secondNumber, int expectedResult) {
        int result = calculations.multiplication(firstNumber, secondNumber);
        assertEquals(result, expectedResult);
    }

    /**
     * Параметризованный негативный тест расчета деления
     * @param firstNumber первое число из тестовых данных DataProvider
     * @param secondNumber второе число из тестовых данных DataProvider
     */
    @Test(dataProvider = "getTestAndExpectedDataCalculationDivisionNegative", expectedExceptions = MyArithmeticException.class)
    public void testPutDataNegativeCalculationCalculation(int firstNumber, int secondNumber) {
        calculations.division(firstNumber, secondNumber);
    }
}