package homework4.single;

import homework4.calculations.Calculations;
import homework4.exceptions.DivisionByZero;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Набор отдельных тестов для класса Calculation
 */
@Epic("Calculation. Single tests")
@Owner("Будущий автотестер, Аносов Д.С.")
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
    @Feature("Проверка математических расчетов")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Тест проверяет сумму двух положительных чисел")
    @Test(description = "Проверка суммы двух положительных чисел")
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
    @Feature("Проверка математических расчетов")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Тест проверяет сумму двух отрицательных чисел")
    @Test(description = "Проверка суммы двух отрицательных чисел")
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
    @Feature("Проверка математических расчетов")
    @Severity(SeverityLevel.MINOR)
    @Description("Тест проверяет сумму двух нулей")
    @Test(description = "Проверка суммы двух нулей")
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
    @Feature("Проверка математических расчетов")
    @Severity(SeverityLevel.MINOR)
    @Description("Тест проверяет сумму двух чисел, положительного числа и нуля")
    @Test(description = "Проверка суммы числа и нуля")
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
    @Feature("Проверка математических расчетов")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Тест проверяет разность двух положительных чисел")
    @Test(description = "Проверка разности двух положительных чисел")
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
    @Feature("Проверка математических расчетов")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Тест проверяет разность двух отрицательных чисел")
    @Test(description = "Проверка разности двух отрицательных чисел")
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
    @Feature("Проверка математических расчетов")
    @Severity(SeverityLevel.MINOR)
    @Description("Тест проверяет разность двух нулей")
    @Test(description = "Проверка разности двух нулей")
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
    @Feature("Проверка математических расчетов")
    @Severity(SeverityLevel.MINOR)
    @Description("Тест проверяет разность двух чисел, положительного числа и нуля")
    @Test(description = "Проверка разности числа и нуля")
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
    @Feature("Проверка математических расчетов")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Тест проверяет произведение двух положительных чисел")
    @Test(description = "Проверка произведения двух положительных чисел")
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
    @Feature("Проверка математических расчетов")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Тест проверяет произведение двух отрицательных чисел")
    @Test(description = "Проверка произведения двух отрицательных чисел")
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
    @Feature("Проверка математических расчетов")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Тест проверяет произведение двух чисел, положительного числа и нуля")
    @Test(description = "Проверка произведения числа и нуля")
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
    @Feature("Проверка математических расчетов")
    @Severity(SeverityLevel.TRIVIAL)
    @Description("Тест проверяет произведение двух нулей")
    @Test(description = "Проверка произведения двух нулей")
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
    @Feature("Проверка математических расчетов")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Тест проверяет деление двух положительных чисел")
    @Test(description = "Проверка деления двух положительных чисел")
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
    @Feature("Проверка математических расчетов")
    @Severity(SeverityLevel.NORMAL)
    @Description("Тест проверяет деление двух отрицательных чисел")
    @Test(description = "Проверка деления двух отрицательных чисел")
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
     * Проверка деления нуль на число
     */
    @Feature("Проверка математических расчетов")
    @Severity(SeverityLevel.NORMAL)
    @Description("Тест проверяет деление двух чисел, нуля и отрицательного числа")
    @Test(description = "Проверка деления нуль на число")
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
    @Feature("Проверка математических расчетов")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Негативная проверка. Тест проверяет деление числа на нуль")
    @Test(expectedExceptions = DivisionByZero.class, description = "Проверка деления на нуль")
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
    @Feature("Проверка математических расчетов через метод calculation")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Тест проверяет сумму двух положительных чисел через метод calculation")
    @Test(description = "Проверка суммы метода calculation, два положительных числа")
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
    @Feature("Проверка математических расчетов через метод calculation")
    @Severity(SeverityLevel.NORMAL)
    @Description("Тест проверяет сумму двух отрицательных чисел через метод calculation")
    @Test(description = "Проверка суммы метода calculation, два отрицательных числа")
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
    @Feature("Проверка математических расчетов через метод calculation")
    @Severity(SeverityLevel.TRIVIAL)
    @Description("Тест проверяет сумму двух нулей через метод calculation")
    @Test(description = "Проверка суммы метода calculation, два числа нуль")
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
    @Feature("Проверка математических расчетов через метод calculation")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Тест проверяет разность двух положительных чисел через метод calculation")
    @Test(description = "Проверка разности метода calculation, два положительных числа")
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
    @Feature("Проверка математических расчетов через метод calculation")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Тест проверяет разность двух отрицательных чисел через метод calculation")
    @Test(description = "Проверка разности метода calculation, два отрицательных числа")
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
    @Feature("Проверка математических расчетов через метод calculation")
    @Severity(SeverityLevel.TRIVIAL)
    @Description("Тест проверяет разность двух нулей через метод calculation")
    @Test(description = "Проверка разности метода calculation, два числа нуль")
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
    @Feature("Проверка математических расчетов через метод calculation")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Тест проверяет произведение двух положительных чисел через метод calculation")
    @Test(description = "Проверка произведения метода calculation, два положительных числа")
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
    @Feature("Проверка математических расчетов через метод calculation")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Тест проверяет произведение двух отрицательных чисел через метод calculation")
    @Test(description = "Проверка произведения метода calculation, два отрицательных числа")
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
    @Feature("Проверка математических расчетов через метод calculation")
    @Severity(SeverityLevel.TRIVIAL)
    @Description("Тест проверяет произведение двух нулей через метод calculation")
    @Test(description = "Проверка произведения метода calculation, два отрицательных числа")
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
    @Feature("Проверка математических расчетов через метод calculation")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Тест проверяет деление двух положительных чисел через метод calculation")
    @Test(description = "Проверка деления метода calculation, два положительных числа")
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
    @Feature("Проверка математических расчетов через метод calculation")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Тест проверяет деление двух отрицательных чисел через метод calculation")
    @Test(description = "Проверка деления метода calculation, два отрицательных числа")
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