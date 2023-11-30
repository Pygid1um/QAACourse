package homework4.parametrized;

import homework4.calculations.Calculations;
import homework4.exceptions.BadSignValue;
import homework4.exceptions.DivisionByZero;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Набор тестов с DataProvider для класса Calculation
 */
@Epic("Calculation. Parameterized tests")
@Owner("Будущий автотестер, Аносов Д.С.")
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
     * DataProvider с позитивными тестовыми данными для проверки расчета метода calculation
     *
     * @return двумерный массив объектов
     */
    @DataProvider
    public Object[][] calculationPositiveDataProvider() {
        return new Object[][]{
                {11, 3, "+", 14},
                {-13, -4, "+", -17},
                {0, 0, "+", 0},
                {56, 6, "-", 50},
                {-6, -6, "-", 0},
                {0, 0, "-", 0},
                {20, 10, "*", 200},
                {-20, -10, "*", 200},
                {0, 0, "*", 0},
                {99, 9, "/", 11},
                {-55, -5, "/", 11}
        };
    }

    /**
     * DataProvider с негативными тестовыми данными для проверки расчета метода calculation
     *
     * @return двумерный массив объектов
     */
    @DataProvider
    public Object[][] calculationNegativeDataProvider() {
        return new Object[][]{
                {11, 3, "4", 14},
                {-13, -4, "#", -17},
                {-13, -4, "фыр-фыр", -17},
                {-13, -4, "**", -17},
                {-13, -4, null, -17},
                {-13, -4, " ", -17},
                {-13, -4, "", -17},
                {-13, -4, "QWERTY123", -17}
        };
    }

    /**
     * Параметризованный позитивный тест расчета суммы
     *
     * @param firstNumber    первое число из тестовых данных DataProvider
     * @param secondNumber   второе число из тестовых данных DataProvider
     * @param expectedResult ожидаемый результат из DataProvider
     */
    @Feature("Проверка математических расчетов с Data Provider")
    @Story("Позитивные проверки расчета суммы с Data Provider")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Тест проверяет расчеты суммы с Data Provider")
    @Test(dataProvider = "sumPositiveDataProvider", description = "Параметризованный позитивный тест расчета суммы")
    public void testPutDataPositiveSum(int firstNumber, int secondNumber, int expectedResult) {
        calculations.setValidatedFirstNumber(firstNumber);
        calculations.setValidatedSecondNumber(secondNumber);
        int result = calculations.sum();
        assertEquals(result, expectedResult);
    }

    /**
     * Параметризованный позитивный тест расчета разности
     *
     * @param firstNumber    первое число из тестовых данных DataProvider
     * @param secondNumber   второе число из тестовых данных DataProvider
     * @param expectedResult ожидаемый результат из DataProvider
     */
    @Feature("Проверка математических расчетов с Data Provider")
    @Story("Позитивные проверки расчета разности с Data Provider")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Тест проверяет расчеты разности с Data Provider")
    @Test(dataProvider = "subtractionPositiveDataProvider", description = "Параметризованный позитивный тест расчета разности")
    public void testPutDataPositiveSubtraction(int firstNumber, int secondNumber, int expectedResult) {
        calculations.setValidatedFirstNumber(firstNumber);
        calculations.setValidatedSecondNumber(secondNumber);
        int result = calculations.subtraction();
        assertEquals(result, expectedResult);
    }

    /**
     * Параметризованный позитивный тест расчета произведения
     *
     * @param firstNumber    первое число из тестовых данных DataProvider
     * @param secondNumber   второе число из тестовых данных DataProvider
     * @param expectedResult ожидаемый результат из DataProvider
     */
    @Feature("Проверка математических расчетов с Data Provider")
    @Story("Позитивные проверки расчета произведения с Data Provider")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Тест проверяет расчеты произведения с Data Provider")
    @Test(dataProvider = "multiplicationPositiveDataProvider", description = "Параметризованный позитивный тест расчета произведения")
    public void testPutDataPositiveMultiplication(int firstNumber, int secondNumber, int expectedResult) {
        calculations.setValidatedFirstNumber(firstNumber);
        calculations.setValidatedSecondNumber(secondNumber);
        int result = calculations.multiplication();
        assertEquals(result, expectedResult);
    }

    /**
     * Параметризованный позитивный тест расчета деления
     *
     * @param firstNumber    первое число из тестовых данных DataProvider
     * @param secondNumber   второе число из тестовых данных DataProvider
     * @param expectedResult ожидаемый результат из DataProvider
     */
    @Feature("Проверка математических расчетов с Data Provider")
    @Story("Позитивные проверки расчета деления с Data Provider")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Тест проверяет расчеты деления с Data Provider")
    @Test(dataProvider = "divisionPositiveDataProvider", description = "Параметризованный позитивный тест расчета деления")
    public void testPutDataPositiveDivision(int firstNumber, int secondNumber, int expectedResult) {
        calculations.setValidatedFirstNumber(firstNumber);
        calculations.setValidatedSecondNumber(secondNumber);
        int result = calculations.division();
        assertEquals(result, expectedResult);
    }

    /**
     * Параметризованный негативный тест расчета деления
     *
     * @param number число из тестовых данных DataProvider
     */
    @Feature("Проверка математических расчетов с Data Provider")
    @Story("Негативные проверки расчета деления с Data Provider")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "divisionNegativeDataProvider", expectedExceptions = DivisionByZero.class,
    description = "Параметризованный негативный тест расчета деления")
    public void testPutDataNegativeCalculation(int number) {
        calculations.setValidatedFirstNumber(number);
        calculations.setValidatedSecondNumber(number);
        calculations.division();
    }

    /**
     * Параметризованный позитивный тест метода calculation
     * @param firstNumber первое число из тестовых данных DataProvider
     * @param secondNumber второе число из тестовых данных DataProvider
     * @param sign математический символ из тестовых данных DataProvider
     * @param expected ожидаемый результат из DataProvider
     */
    @Feature("Проверка математических расчетов метода calculation с Data Provider")
    @Story("Позитивные проверки расчета деления с Data Provider")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "calculationPositiveDataProvider", description = "Параметризованный позитивный тест метода calculation")
    public void testPutPositiveDataCalculation(int firstNumber, int secondNumber, String sign, int expected) {
        calculations.setValidatedFirstNumber(firstNumber);
        calculations.setValidatedSecondNumber(secondNumber);
        calculations.setValidatedSign(sign);
        calculations.calculation();
        assertEquals(calculations.getResult(), expected);
    }

    /**
     * Параметризованный негативный тест метода calculation
     * @param firstNumber первое число из тестовых данных DataProvider
     * @param secondNumber второе число из тестовых данных DataProvider
     * @param sign математический символ из тестовых данных DataProvider
     * @param expected ожидаемый результат из DataProvider
     */
    @Feature("Проверка математических расчетов метода calculation с Data Provider")
    @Story("Негативные проверки расчета деления с Data Provider")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "calculationNegativeDataProvider", expectedExceptions = BadSignValue.class,
    description = "Параметризованный негативный тест метода calculation")
    public void testPutNegativeDataCalculation(int firstNumber, int secondNumber, String sign, int expected) {
        calculations.setValidatedFirstNumber(firstNumber);
        calculations.setValidatedSecondNumber(secondNumber);
        calculations.setValidatedSign(sign);
        calculations.calculation();
    }
}