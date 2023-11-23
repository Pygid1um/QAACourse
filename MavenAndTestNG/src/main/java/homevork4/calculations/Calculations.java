package homevork4.calculations;

import homevork4.exceptions.DivisionByZero;
import homevork4.validator.Validator;

import java.util.Scanner;

/**
 * Класс в котором происходят математические расчеты и сканирование введенных значений с консоли
 */
public class Calculations {

    /**
     * Переменная для хранения первого введенного числа после валидации
     */
    private int validatedFirstNumber;

    /**
     * Переменная для хранения второго введенного числа после валидации
     */
    private int validatedSecondNumber;

    /**
     * Переменная для хранения введенного математического символа после валидации
     */
    private String validatedSign;

    /**
     * Переменная для хранения результата вычисления
     */
    private int result;

    /**
     * Создание сканера, который считывает значения с консоли
     */
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Возвращает значение параметра result
     *
     * @return значение параметра result
     */
    public int getResult() {
        return result;
    }

    /**
     * Устанавливает значение параметра validatedFirstNumber
     *
     * @param validatedFirstNumber первое число
     */
    public void setValidatedFirstNumber(int validatedFirstNumber) {
        this.validatedFirstNumber = validatedFirstNumber;
    }

    /**
     * Устанавливает значение параметра validatedSecondNumber
     *
     * @param validatedSecondNumber второе число
     */
    public void setValidatedSecondNumber(int validatedSecondNumber) {
        this.validatedSecondNumber = validatedSecondNumber;
    }

    /**
     * Устанавливает значение параметра validatedSign
     *
     * @param validatedSign математический знак
     */
    public void setValidatedSign(String validatedSign) {
        this.validatedSign = validatedSign;
    }

    /**
     * Метод в котором сканер считывает числа и математический знак
     */
    public void scannerInput() {
        System.out.print("Введите первое число: ");
        validatedFirstNumber = Validator.validateInputNumbers(scanner.nextLong());
        System.out.print("Введите математический знак: ");
        validatedSign = Validator.validateInputSign(scanner.next());
        System.out.print("Введите второе число: ");
        validatedSecondNumber = Validator.validateInputNumbers(scanner.nextLong());
    }

    /**
     * Метод в котором вызываются методы математического расчета
     */
    public void calculation() {
        switch (validatedSign) {
            case "+" -> result = sum();
            case "-" -> result = subtraction();
            case "*" -> result = multiplication();
            case "/" -> result = division();
        }
    }

    /**
     * Метод в котором происходит сумма чисел
     *
     * @return возвращает сумму чисел
     */
    public int sum() {
        return validatedFirstNumber + validatedSecondNumber;
    }

    /**
     * Метод в котором происходит разность чисел
     *
     * @return возвращает разность чисел
     */
    public int subtraction() {
        return validatedFirstNumber - validatedSecondNumber;
    }

    /**
     * Метод в котором происходит произведение чисел
     *
     * @return возвращает произведение чисел
     */
    public int multiplication() {
        return validatedFirstNumber * validatedSecondNumber;
    }

    /**
     * Метод в котором происходит деление чисел
     *
     * @throws DivisionByZero создается исключение в случае попытки деления на 0
     */
    public int division() {
        if (validatedSecondNumber == 0) {
            throw new DivisionByZero("На ноль делить нельзя!");
        } else {
            return validatedFirstNumber / validatedSecondNumber;
        }
    }

    /**
     * Метод выводит в консоль результат математической операции
     */
    public void consoleOutput() {
        System.out.println("Результат: " + validatedFirstNumber + " " + validatedSign + " " + validatedSecondNumber +
                " = " + result);
    }
}