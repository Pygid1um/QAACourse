package homevork4.single;

import homevork4.calculations.Calculations;
import homevork4.exceptions.DivisionByZero;
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
     * Проверка суммы двух положительных чисел
     */
    @Test
    public void sumPositiveNumbers() {
        int firstNumber = 6;
        int secondNumber = 5;
        int totalNumber = firstNumber + secondNumber;
        int result = calculations.sum(firstNumber, secondNumber);
        assertEquals(result, totalNumber);
    }


    /**
     * Проверка суммы двух отрицательных чисел
     */
    @Test
    public void sumNegativeNumbers() {
        int firstNumber = -10;
        int secondNumber = -6;
        int totalNumber = firstNumber + secondNumber;
        int result = calculations.sum(firstNumber, secondNumber);
        assertEquals(result, totalNumber);
    }

    /**
     * Проверка суммы двух нулей
     */
    @Test
    public void sumZeroNumbers() {
        int firstNumber = 0;
        int secondNumber = 0;
        int totalNumber = firstNumber + secondNumber;
        int result = calculations.sum(firstNumber, secondNumber);
        assertEquals(result, totalNumber);
    }

    /**
     * Проверка суммы числа и нуля
     */
    @Test
    public void sumWithZeroNumber() {
        int firstNumber = 10;
        int secondNumber = 0;
        int totalNumber = firstNumber + secondNumber;
        int result = calculations.sum(firstNumber, secondNumber);
        assertEquals(result, totalNumber);
    }

    /**
     * Проверка разности двух положительных чисел
     */
    @Test
    public void subtractionPositiveNumbers() {
        int firstNumber = 9;
        int secondNumber = 4;
        int totalNumber = firstNumber - secondNumber;
        int result = calculations.subtraction(firstNumber, secondNumber);
        assertEquals(result, totalNumber);
    }

    /**
     * Проверка разности двух отрицательных чисел
     */
    @Test
    public void subtractionNegativeNumbers() {
        int firstNumber = -9;
        int secondNumber = -8;
        int totalNumber = firstNumber - secondNumber;
        int result = calculations.subtraction(firstNumber, secondNumber);
        assertEquals(result, totalNumber);
    }

    /**
     * Проверка разности двух нулей
     */
    @Test
    public void subtractionZeroNumbers() {
        int firstNumber = 0;
        int secondNumber = 0;
        int totalNumber = firstNumber - secondNumber;
        int result = calculations.subtraction(firstNumber, secondNumber);
        assertEquals(result, totalNumber);
    }

    /**
     * Проверка разности числа и нуля
     */
    @Test
    public void subtractionWithZeroNumber() {
        int firstNumber = 0;
        int secondNumber = 30;
        int totalNumber = firstNumber - secondNumber;
        int result = calculations.subtraction(firstNumber, secondNumber);
        assertEquals(result, totalNumber);
    }

    /**
     * Проверка произведения двух положительных чисел
     */
    @Test
    public void multiplicationPositiveNumbers() {
        int firstNumber = 6;
        int secondNumber = 2;
        int totalNumber = firstNumber * secondNumber;
        int result = calculations.multiplication(firstNumber, secondNumber);
        assertEquals(result, totalNumber);
    }

    /**
     * Проверка произведения двух отрицательных чисел
     */
    @Test
    public void multiplicationNegativeNumbers() {
        int firstNumber = -3;
        int secondNumber = -6;
        int totalNumber = firstNumber * secondNumber;
        int result = calculations.multiplication(firstNumber, secondNumber);
        assertEquals(result, totalNumber);
    }

    /**
     * Проверка произведения числа и нуля
     */
    @Test
    public void multiplicationWithZeroNumber() {
        int firstNumber = 46;
        int secondNumber = 0;
        int totalNumber = firstNumber * secondNumber;
        int result = calculations.multiplication(firstNumber, secondNumber);
        assertEquals(result, totalNumber);
    }

    /**
     * Проверка произведения двух нулей
     */
    @Test
    public void multiplicationZeroNumbers() {
        int firstNumber = 0;
        int secondNumber = 0;
        int totalNumber = firstNumber * secondNumber;
        int result = calculations.multiplication(firstNumber, secondNumber);
        assertEquals(result, totalNumber);
    }


    /**
     * Проверка деления двух положительных чисел
     */
    @Test
    public void divisionNumbers() {
        int firstNumber = 6;
        int secondNumber = 2;
        int totalNumber = firstNumber / secondNumber;
        int result = calculations.division(firstNumber, secondNumber);
        assertEquals(result, totalNumber);
    }

    /**
     * Проверка деления двух отрицательных чисел
     */
    @Test
    public void divisionNegativeNumbers() {
        int firstNumber = -8;
        int secondNumber = -4;
        int totalNumber = firstNumber / secondNumber;
        int result = calculations.division(firstNumber, secondNumber);
        assertEquals(result, totalNumber);
    }

    /**
     * Проверка деления числа на нуль
     */
    @Test
    public void divisionNumberByZero() {
        int firstNumber = 0;
        int secondNumber = -4;
        int totalNumber = firstNumber / secondNumber;
        int result = calculations.division(firstNumber, secondNumber);
        assertEquals(result, totalNumber);
    }

    /**
     * Проверка деления на нуль
     */
    @Test(expectedExceptions = DivisionByZero.class)
    public void divisionByZeroNumber() {
        int firstNumber = 8;
        int secondNumber = 0;
        calculations.division(firstNumber, secondNumber);
    }

    @Test
    public void calculationPositiveSum() {
        calculations.setValidatedFirstNumber(11);
        calculations.setValidatedSecondNumber(3);
        calculations.setValidatedSign("+");
        calculations.calculation();
        assertEquals(calculations.getResult(), 14);
    }

    @Test
    public void calculationNegativeSum() {
        calculations.setValidatedFirstNumber(-11);
        calculations.setValidatedSecondNumber(-4);
        calculations.setValidatedSign("+");
        calculations.calculation();
        assertEquals(calculations.getResult(), -15);
    }

    @Test
    public void calculationFirstNegativeSum() {
        calculations.setValidatedFirstNumber(-18);
        calculations.setValidatedSecondNumber(5);
        calculations.setValidatedSign("+");
        calculations.calculation();
        assertEquals(calculations.getResult(), -13);
    }

    @Test
    public void calculationSecondNegativeSum() {
        calculations.setValidatedFirstNumber(156);
        calculations.setValidatedSecondNumber(-33);
        calculations.setValidatedSign("+");
        calculations.calculation();
        assertEquals(calculations.getResult(), 123);
    }

    @Test
    public void calculationFirstZeroSum() {
        calculations.setValidatedFirstNumber(0);
        calculations.setValidatedSecondNumber(23);
        calculations.setValidatedSign("+");
        calculations.calculation();
        assertEquals(calculations.getResult(), 23);
    }

    @Test
    public void calculationSecondZeroSum() {
        calculations.setValidatedFirstNumber(12);
        calculations.setValidatedSecondNumber(0);
        calculations.setValidatedSign("+");
        calculations.calculation();
        assertEquals(calculations.getResult(), 12);
    }

    @Test
    public void calculationZeroSum() {
        calculations.setValidatedFirstNumber(0);
        calculations.setValidatedSecondNumber(0);
        calculations.setValidatedSign("+");
        calculations.calculation();
        assertEquals(calculations.getResult(), 0);
    }

    @Test
    public void calculationPositiveSubtraction() {
        calculations.setValidatedFirstNumber(56);
        calculations.setValidatedSecondNumber(6);
        calculations.setValidatedSign("-");
        calculations.calculation();
        assertEquals(calculations.getResult(), 50);
    }

    @Test
    public void calculationFirstNegativeSubtraction() {
        calculations.setValidatedFirstNumber(-16);
        calculations.setValidatedSecondNumber(5);
        calculations.setValidatedSign("-");
        calculations.calculation();
        assertEquals(calculations.getResult(), -9);
    }

    @Test
    public void calculationSecondNegativeSubtraction() {
        calculations.setValidatedFirstNumber(16);
        calculations.setValidatedSecondNumber(-9);
        calculations.setValidatedSign("-");
        calculations.calculation();
        assertEquals(calculations.getResult(), 25);
    }

    @Test
    public void calculationNegativeSubtraction() {
        calculations.setValidatedFirstNumber(-16);
        calculations.setValidatedSecondNumber(-9);
        calculations.setValidatedSign("-");
        calculations.calculation();
        assertEquals(calculations.getResult(), -7);
    }

    @Test
    public void calculationMultiplication() {
        calculations.setValidatedFirstNumber(20);
        calculations.setValidatedSecondNumber(10);
        calculations.setValidatedSign("*");
        calculations.calculation();
        assertEquals(calculations.getResult(), 200);
    }

    @Test
    public void calculationDivision() {
        calculations.setValidatedFirstNumber(88);
        calculations.setValidatedSecondNumber(8);
        calculations.setValidatedSign("/");
        calculations.calculation();
        assertEquals(calculations.getResult(), 11);
    }
}