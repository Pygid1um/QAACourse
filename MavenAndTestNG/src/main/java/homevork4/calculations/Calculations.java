package homevork4.calculations;

import homevork4.exceptions.MyArithmeticException;
import homevork4.validator.Validator;

/**
 * Класс в котором происходят математические расчеты
 */
public class Calculations {

    /**
     * Переменная для хранения результата вычисления
     */
    private int result;

    /**
     * Переменная для хранения объекта класса Validator
     */
    private final Validator validator = new Validator();

    /**
     * Метод в котором вызываются методы валидации и математического расчета
     * @param firstNumber первое число
     * @param secondNumber второе число
     * @param sign математический знак
     */
    public void calculation(int firstNumber, int secondNumber, String sign) {

        String resultValidationSign = validator.validateInputSign(sign);
        int resultValidationFirstNumber = validator.validateInputNumbers(firstNumber);
        int resultValidationSecondNumber = validator.validateInputNumbers(secondNumber);

        switch (resultValidationSign) {
            case "+" -> {
                result = sum(resultValidationFirstNumber, resultValidationSecondNumber);
                consoleOutput(resultValidationFirstNumber, resultValidationSecondNumber, resultValidationSign);
            }
            case "-" -> {
                result = subtraction(resultValidationFirstNumber, resultValidationSecondNumber);
                consoleOutput(resultValidationFirstNumber, resultValidationSecondNumber, resultValidationSign);
            }
            case "*" -> {
                result = multiplication(resultValidationFirstNumber, resultValidationSecondNumber);
                consoleOutput(resultValidationFirstNumber, resultValidationSecondNumber, resultValidationSign);
            }
            case "/" -> {
                result = division(resultValidationFirstNumber, resultValidationSecondNumber);
                consoleOutput(resultValidationFirstNumber, resultValidationSecondNumber, resultValidationSign);
            }
        }
    }

    /**
     * Метод в котором происходит сумма чисел
     * @param firstNumber первое число
     * @param secondNumber второе число
     * @return возвращает сумму чисел
     */
    public int sum(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    /**
     * Метод в котором происходит разность чисел
     * @param firstNumber первое число
     * @param secondNumber второе число
     * @return возвращает разность чисел
     */
    public int subtraction(int firstNumber, int secondNumber) {
       return firstNumber - secondNumber;
    }

    /**
     * Метод в котором происходит произведение
     * @param firstNumber первое число
     * @param secondNumber второе число
     * @return возвращает произведение чисел
     */
    public int multiplication(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }

    /**
     * Метод в котором происходит деление чисел и вывод в консоль результата суммы
     * @param firstNumber первое число
     * @param secondNumber второе число
     * @throws MyArithmeticException создается исключение в случае попытки деления на 0
     */
    public int division(int firstNumber, int secondNumber) {
        if (secondNumber == 0) {
            throw new MyArithmeticException("На ноль делить нельзя!");
        } else {
            return firstNumber / secondNumber;
        }
    }

    /**
     * Метод выводит в консоль результат математической операции
     * @param firstNumber первое число
     * @param secondNumber второе число
     * @param sign математический знак
     */
    private void consoleOutput(int firstNumber, int secondNumber, String sign) {
        System.out.println("Результат: " + firstNumber + " " + sign + " " + secondNumber + " = " + result);
    }
}