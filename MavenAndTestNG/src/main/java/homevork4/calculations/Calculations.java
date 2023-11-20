package homevork4.calculations;

import homevork4.exceptions.DivisionByZero;
import homevork4.scanning.ScannerValues;

/**
 * Класс в котором происходят математические расчеты
 */
public class Calculations {

    /**
     * Переменная для хранения результата вычисления
     */
    private String result;

    /**
     * Метод в котором вызываются методы математического расчета
     */
    public void calculation() {

        switch (ScannerValues.getResultValidationSign()) {
            case "+" -> {
                result = sum(ScannerValues.getResultValidationFirstNumber(),
                        ScannerValues.getResultValidationSecondNumber());
                consoleOutput(ScannerValues.getResultValidationFirstNumber(),
                        ScannerValues.getResultValidationSecondNumber(), ScannerValues.getResultValidationSign());
            }
            case "-" -> {
                result = subtraction(ScannerValues.getResultValidationFirstNumber(),
                        ScannerValues.getResultValidationSecondNumber());
                consoleOutput(ScannerValues.getResultValidationFirstNumber(),
                        ScannerValues.getResultValidationSecondNumber(), ScannerValues.getResultValidationSign());
            }
            case "*" -> {
                result = multiplication(ScannerValues.getResultValidationFirstNumber(),
                        ScannerValues.getResultValidationSecondNumber());
                consoleOutput(ScannerValues.getResultValidationFirstNumber(),
                        ScannerValues.getResultValidationSecondNumber(), ScannerValues.getResultValidationSign());
            }
            case "/" -> {
                result = division(ScannerValues.getResultValidationFirstNumber(),
                        ScannerValues.getResultValidationSecondNumber());
                consoleOutput(ScannerValues.getResultValidationFirstNumber(),
                        ScannerValues.getResultValidationSecondNumber(), ScannerValues.getResultValidationSign());
            }
        }
    }

    /**
     * Метод в котором происходит сумма чисел
     *
     * @param firstNumber  первое число
     * @param secondNumber второе число
     * @return возвращает сумму чисел
     */
    public String sum(String firstNumber, String secondNumber) {
        int result = Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber);
        return String.valueOf(result);
    }

    /**
     * Метод в котором происходит разность чисел
     *
     * @param firstNumber  первое число
     * @param secondNumber второе число
     * @return возвращает разность чисел
     */
    public String subtraction(String firstNumber, String secondNumber) {
        int result = Integer.parseInt(firstNumber) - Integer.parseInt(secondNumber);
        return String.valueOf(result);
    }

    /**
     * Метод в котором происходит произведение
     *
     * @param firstNumber  первое число
     * @param secondNumber второе число
     * @return возвращает произведение чисел
     */
    public String multiplication(String firstNumber, String secondNumber) {
        int result = Integer.parseInt(firstNumber) * Integer.parseInt(secondNumber);
        return String.valueOf(result);
    }

    /**
     * Метод в котором происходит деление чисел и вывод в консоль результата суммы
     *
     * @param firstNumber  первое число
     * @param secondNumber второе число
     * @throws DivisionByZero создается исключение в случае попытки деления на 0
     */
    public String division(String firstNumber, String secondNumber) {
        if (secondNumber.equals("0")) {
            throw new DivisionByZero("На ноль делить нельзя!");
        } else {
            int result = Integer.parseInt(firstNumber) / Integer.parseInt(secondNumber);
            return String.valueOf(result);
        }
    }

    /**
     * Метод выводит в консоль результат математической операции
     *
     * @param firstNumber  первое число
     * @param secondNumber второе число
     * @param sign         математический знак
     */
    private void consoleOutput(String firstNumber, String secondNumber, String sign) {
        System.out.println("Результат: " + firstNumber + " " + sign + " " + secondNumber + " = " + result);
    }
}