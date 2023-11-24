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
        calculations.setValidatedFirstNumber(firstNumber);
        calculations.setValidatedSecondNumber(secondNumber);
        int result = calculations.sum();
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
        calculations.setValidatedFirstNumber(firstNumber);
        calculations.setValidatedSecondNumber(secondNumber);
        int result = calculations.sum();
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
        calculations.setValidatedFirstNumber(firstNumber);
        calculations.setValidatedSecondNumber(secondNumber);
        int result = calculations.sum();
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
        calculations.setValidatedFirstNumber(firstNumber);
        calculations.setValidatedSecondNumber(secondNumber);
        int result = calculations.sum();
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
        calculations.setValidatedFirstNumber(firstNumber);
        calculations.setValidatedSecondNumber(secondNumber);
        int result = calculations.subtraction();
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
        calculations.setValidatedFirstNumber(firstNumber);
        calculations.setValidatedSecondNumber(secondNumber);
        int result = calculations.subtraction();
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
        calculations.setValidatedFirstNumber(firstNumber);
        calculations.setValidatedSecondNumber(secondNumber);
        int result = calculations.subtraction();
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
        calculations.setValidatedFirstNumber(firstNumber);
        calculations.setValidatedSecondNumber(secondNumber);
        int result = calculations.subtraction();
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
        calculations.setValidatedFirstNumber(firstNumber);
        calculations.setValidatedSecondNumber(secondNumber);
        int result = calculations.multiplication();
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
        calculations.setValidatedFirstNumber(firstNumber);
        calculations.setValidatedSecondNumber(secondNumber);
        int result = calculations.multiplication();
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
        calculations.setValidatedFirstNumber(firstNumber);
        calculations.setValidatedSecondNumber(secondNumber);
        int result = calculations.multiplication();
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
        calculations.setValidatedFirstNumber(firstNumber);
        calculations.setValidatedSecondNumber(secondNumber);
        int result = calculations.multiplication();
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
        calculations.setValidatedFirstNumber(firstNumber);
        calculations.setValidatedSecondNumber(secondNumber);
        int result = calculations.division();
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
        calculations.setValidatedFirstNumber(firstNumber);
        calculations.setValidatedSecondNumber(secondNumber);
        int result = calculations.division();
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
        calculations.setValidatedFirstNumber(firstNumber);
        calculations.setValidatedSecondNumber(secondNumber);
        int result = calculations.division();
        assertEquals(result, totalNumber);
    }

    /**
     * Проверка деления на нуль
     */
    @Test(expectedExceptions = DivisionByZero.class)
    public void divisionByZeroNumber() {
        int firstNumber = 8;
        int secondNumber = 0;
        calculations.setValidatedFirstNumber(firstNumber);
        calculations.setValidatedSecondNumber(secondNumber);
        calculations.division();
    }

    /**
     * Проверка суммы метода calculation, два положительных числа
     */
    @Test
    public void calculationPositiveSum() {
        int firstNumber = 11;
        int secondNumber = 3;
        String sign = "+";
        int totalNumber = firstNumber + secondNumber;
        calculations.setValidatedFirstNumber(firstNumber);
        calculations.setValidatedSecondNumber(secondNumber);
        calculations.setValidatedSign(sign);
        calculations.calculation();
        assertEquals(calculations.getResult(), totalNumber);
    }

    /**
     * Проверка суммы метода calculation, два отрицательных числа
     */
    @Test
    public void calculationNegativeSum() {
        int firstNumber = -11;
        int secondNumber = -4;
        String sign = "+";
        int totalNumber = firstNumber + secondNumber;
        calculations.setValidatedFirstNumber(firstNumber);
        calculations.setValidatedSecondNumber(secondNumber);
        calculations.setValidatedSign(sign);
        calculations.calculation();
        assertEquals(calculations.getResult(), totalNumber);
    }

    /**
     * Проверка суммы метода calculation, два числа нуль
     */
    @Test
    public void calculationZeroSum() {
        int firstNumber = 0;
        int secondNumber = 0;
        String sign = "+";
        int totalNumber = firstNumber + secondNumber;
        calculations.setValidatedFirstNumber(firstNumber);
        calculations.setValidatedSecondNumber(secondNumber);
        calculations.setValidatedSign(sign);
        calculations.calculation();
        assertEquals(calculations.getResult(), totalNumber);
    }

    /**
     * Проверка разности метода calculation, два положительных числа
     */
    @Test
    public void calculationPositiveSubtraction() {
        int firstNumber = 56;
        int secondNumber = 6;
        String sign = "-";
        int totalNumber = firstNumber - secondNumber;
        calculations.setValidatedFirstNumber(firstNumber);
        calculations.setValidatedSecondNumber(secondNumber);
        calculations.setValidatedSign(sign);
        calculations.calculation();
        assertEquals(calculations.getResult(), totalNumber);
    }

    /**
     * Проверка разности метода calculation, два отрицательных числа
     */
    @Test
    public void calculationNegativeSubtraction() {
        int firstNumber = -16;
        int secondNumber = -9;
        String sign = "-";
        int totalNumber = firstNumber - secondNumber;
        calculations.setValidatedFirstNumber(firstNumber);
        calculations.setValidatedSecondNumber(secondNumber);
        calculations.setValidatedSign(sign);
        calculations.calculation();
        assertEquals(calculations.getResult(), totalNumber);
    }

    /**
     * Проверка разности метода calculation, два числа нуль
     */
    @Test
    public void calculationZeroSubtraction() {
        int firstNumber = 0;
        int secondNumber = 0;
        String sign = "-";
        int totalNumber = firstNumber - secondNumber;
        calculations.setValidatedFirstNumber(firstNumber);
        calculations.setValidatedSecondNumber(secondNumber);
        calculations.setValidatedSign(sign);
        calculations.calculation();
        assertEquals(calculations.getResult(), totalNumber);
    }

    /**
     * Проверка произведения метода calculation, два положительных числа
     */
    @Test
    public void calculationPositiveMultiplication() {
        int firstNumber = 20;
        int secondNumber = 10;
        String sign = "*";
        int totalNumber = firstNumber * secondNumber;
        calculations.setValidatedFirstNumber(firstNumber);
        calculations.setValidatedSecondNumber(secondNumber);
        calculations.setValidatedSign(sign);
        calculations.calculation();
        assertEquals(calculations.getResult(), totalNumber);
    }

    /**
     * Проверка произведения метода calculation, два отрицательных числа
     */
    @Test
    public void calculationNegativeMultiplication() {
        int firstNumber = -23;
        int secondNumber = -3;
        String sign = "*";
        int totalNumber = firstNumber * secondNumber;
        calculations.setValidatedFirstNumber(firstNumber);
        calculations.setValidatedSecondNumber(secondNumber);
        calculations.setValidatedSign(sign);
        calculations.calculation();
        assertEquals(calculations.getResult(), totalNumber);
    }

    /**
     * Проверка произведения метода calculation, два числа нуль
     */
    @Test
    public void calculationZeroMultiplication() {
        int firstNumber = 0;
        int secondNumber = 0;
        String sign = "*";
        int totalNumber = firstNumber * secondNumber;
        calculations.setValidatedFirstNumber(firstNumber);
        calculations.setValidatedSecondNumber(secondNumber);
        calculations.setValidatedSign(sign);
        calculations.calculation();
        assertEquals(calculations.getResult(), totalNumber);
    }

    /**
     * Проверка деления метода calculation, два положительных числа
     */
    @Test
    public void calculationPositiveDivision() {
        int firstNumber = 88;
        int secondNumber = 8;
        String sign = "/";
        int totalNumber = firstNumber / secondNumber;
        calculations.setValidatedFirstNumber(firstNumber);
        calculations.setValidatedSecondNumber(secondNumber);
        calculations.setValidatedSign(sign);
        calculations.calculation();
        assertEquals(calculations.getResult(), totalNumber);
    }

    /**
     * Проверка деления метода calculation, два отрицательных числа
     */
    @Test
    public void calculationNegativeDivision() {
        int firstNumber = -55;
        int secondNumber = -5;
        String sign = "/";
        int totalNumber = firstNumber / secondNumber;
        calculations.setValidatedFirstNumber(firstNumber);
        calculations.setValidatedSecondNumber(secondNumber);
        calculations.setValidatedSign(sign);
        calculations.calculation();
        assertEquals(calculations.getResult(), totalNumber);
    }
}