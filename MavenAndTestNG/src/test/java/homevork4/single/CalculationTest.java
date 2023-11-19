package homevork4.single;

import homevork4.calculations.Calculations;
import homevork4.exceptions.MyArithmeticException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

/**
 * Набор отдельных тестов для класса Calculation
 */
public class CalculationTest {

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
     * Проверка суммы двух чисел
     */
    @Test
    public void testCalculationSumNumbers() {
        int firstNumber = 6;
        int secondNumber = 5;
        int totalNumber = firstNumber + secondNumber;
        int result = calculations.sum(firstNumber, secondNumber);
        assertEquals(result, totalNumber);
    }

    /**
     * Проверка суммы двух нулей
     */
    @Test
    public void testCalculationSumZeroNumbers() {
        int firstNumber = 0;
        int secondNumber = 0;
        int totalNumber = firstNumber + secondNumber;
        int result = calculations.sum(firstNumber, secondNumber);
        assertEquals(result, totalNumber);
    }

    /**
     * Проверка разности двух чисел
     */
    @Test
    public void testCalculationSubtractionNumbers() {
        int firstNumber = 9;
        int secondNumber = 4;
        int totalNumber = firstNumber - secondNumber;
        int result = calculations.subtraction(firstNumber, secondNumber);
        assertEquals(result, totalNumber);
    }

    /**
     * Проверка разности двух нулей
     */
    @Test
    public void testCalculationSubtractionZeroNumbers() {
        int firstNumber = 0;
        int secondNumber = 0;
        int totalNumber = firstNumber - secondNumber;
        int result = calculations.subtraction(firstNumber, secondNumber);
        assertEquals(result, totalNumber);
    }

    /**
     * Проверка произведения двух чисел
     */
    @Test
    public void testCalculationMultiplicationNumbers() {
        int firstNumber = 5;
        int secondNumber = 2;
        int totalNumber = firstNumber * secondNumber;
        int result = calculations.multiplication(firstNumber, secondNumber);
        assertEquals(result, totalNumber);
    }

    /**
     * Проверка произведения двух нулей
     */
    @Test
    public void testCalculationMultiplicationZeroNumbers() {
        int firstNumber = 0;
        int secondNumber = 0;
        int totalNumber = firstNumber * secondNumber;
        int result = calculations.multiplication(firstNumber, secondNumber);
        assertEquals(result, totalNumber);
    }

    /**
     * Проверка деления двух чисел
     */
    @Test
    public void testCalculationDivisionNumbers() {
        int firstNumber = 6;
        int secondNumber = 2;
        int totalNumber = firstNumber / secondNumber;
        int result = calculations.division(firstNumber, secondNumber);
        assertEquals(result, totalNumber);
    }

    /**
     * Проверка деления на нуль
     */
    @Test(expectedExceptions = MyArithmeticException.class)
    public void testCalculationDivisionZeroNumbers() {
        int firstNumber = 8;
        int secondNumber = 0;
        calculations.division(firstNumber, secondNumber);
    }
}