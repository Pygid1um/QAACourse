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
    public void sumPositiveNumbers2() {
        String firstNumber = "6";
        String secondNumber = "5";
        String totalNumber = String.valueOf(Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber));
        String result = calculations.sum(firstNumber, secondNumber);
        assertEquals(result, totalNumber);
    }

    /**
     * Проверка суммы двух отрицательных чисел
     */
    @Test
    public void sumNegativeNumbers() {
        String firstNumber = "-1";
        String secondNumber = "-6";
        String totalNumber = String.valueOf(Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber));
        String result = calculations.sum(firstNumber, secondNumber);
        assertEquals(result, totalNumber);
    }

    /**
     * Проверка суммы двух нулей
     */
    @Test
    public void sumZeroNumbers() {
        String firstNumber = "0";
        String secondNumber = "0";
        String totalNumber = String.valueOf(Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber));
        String result = calculations.sum(firstNumber, secondNumber);
        assertEquals(result, totalNumber);
    }

    /**
     * Проверка разности двух положительных чисел
     */
    @Test
    public void subtractionPositiveNumbers() {
        String firstNumber = "9";
        String secondNumber = "4";
        String totalNumber = String.valueOf(Integer.parseInt(firstNumber) - Integer.parseInt(secondNumber));
        String result = calculations.subtraction(firstNumber, secondNumber);
        assertEquals(result, totalNumber);
    }

    /**
     * Проверка разности двух отрицательных чисел
     */
    @Test
    public void subtractionNegativeNumbers() {
        String firstNumber = "-9";
        String secondNumber = "-8";
        String totalNumber = String.valueOf(Integer.parseInt(firstNumber) - Integer.parseInt(secondNumber));
        String result = calculations.subtraction(firstNumber, secondNumber);
        assertEquals(result, totalNumber);
    }

    /**
     * Проверка разности двух нулей
     */
    @Test
    public void subtractionZeroNumbers() {
        String firstNumber = "0";
        String secondNumber = "0";
        String totalNumber = String.valueOf(Integer.parseInt(firstNumber) - Integer.parseInt(secondNumber));
        String result = calculations.subtraction(firstNumber, secondNumber);
        assertEquals(result, totalNumber);
    }

    /**
     * Проверка произведения двух положительных чисел
     */
    @Test
    public void multiplicationPositiveNumbers() {
        String firstNumber = "5";
        String secondNumber = "2";
        String totalNumber = String.valueOf(Integer.parseInt(firstNumber) * Integer.parseInt(secondNumber));
        String result = calculations.multiplication(firstNumber, secondNumber);
        assertEquals(result, totalNumber);
    }

    /**
     * Проверка произведения двух отрицательных чисел
     */
    @Test
    public void multiplicationNegativeNumbers() {
        String firstNumber = "-3";
        String secondNumber = "-6";
        String totalNumber = String.valueOf(Integer.parseInt(firstNumber) * Integer.parseInt(secondNumber));
        String result = calculations.multiplication(firstNumber, secondNumber);
        assertEquals(result, totalNumber);
    }

    /**
     * Проверка произведения двух нулей
     */
    @Test
    public void multiplicationZeroNumbers() {
        String firstNumber = "0";
        String secondNumber = "0";
        String totalNumber = String.valueOf(Integer.parseInt(firstNumber) * Integer.parseInt(secondNumber));
        String result = calculations.multiplication(firstNumber, secondNumber);
        assertEquals(result, totalNumber);
    }

    /**
     * Проверка деления двух положительных чисел
     */
    @Test
    public void divisionNumbers() {
        String firstNumber = "6";
        String secondNumber = "2";
        String totalNumber = String.valueOf(Integer.parseInt(firstNumber) / Integer.parseInt(secondNumber));
        String result = calculations.division(firstNumber, secondNumber);
        assertEquals(result, totalNumber);
    }

    /**
     * Проверка деления двух отрицательных чисел
     */
    @Test
    public void divisionNegativeNumbers() {
        String firstNumber = "-8";
        String secondNumber = "-4";
        String totalNumber = String.valueOf(Integer.parseInt(firstNumber) / Integer.parseInt(secondNumber));
        String result = calculations.division(firstNumber, secondNumber);
        assertEquals(result, totalNumber);
    }

    /**
     * Проверка деления на нуль
     */
    @Test(expectedExceptions = DivisionByZero.class)
    public void divisionByZeroNumber() {
        String firstNumber = "8";
        String secondNumber = "0";
        calculations.division(firstNumber, secondNumber);
    }
}