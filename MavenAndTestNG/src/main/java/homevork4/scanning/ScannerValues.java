package homevork4.scanning;

import homevork4.validator.Validator;

import java.util.Scanner;

/**
 * Класс в котором происходит считывание с консоли введенных чисел и математического знака
 */
public class ScannerValues {

    /**
     * Создание сканера, который считывает значения с консоли
     */
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Переменная для хранения первого введенного числа после валидации
     */
    private static String resultValidationFirstNumber;

    /**
     * Переменная для хранения второго введенного числа после валидации
     */
    private static String resultValidationSecondNumber;

    /**
     * Переменная для хранения введенного математического символа после валидации
     */
    private static String resultValidationSign;

    /**
     * Возвращает значение поля firstNumber
     *
     * @return значение поля firstNumber
     */
    public static String getResultValidationFirstNumber() {
        return resultValidationFirstNumber;
    }

    /**
     * Возвращает значение поля secondNumber
     *
     * @return значение поля secondNumber
     */
    public static String getResultValidationSecondNumber() {
        return resultValidationSecondNumber;
    }

    /**
     * Возвращает значение поля sign
     *
     * @return значение поля sign
     */
    public static String getResultValidationSign() {
        return resultValidationSign;
    }

    /**
     * Метод в котором сканер считывает числа и математический знак
     */
    public void scannerInput() {
        System.out.print("Введите первое число: ");
        resultValidationFirstNumber = Validator.validateInputNumbers(scanner.next());
        System.out.print("Введите математический знак: ");
        resultValidationSign = Validator.validateInputSign(scanner.next());
        System.out.print("Введите второе число: ");
        resultValidationSecondNumber = Validator.validateInputNumbers(scanner.next());
    }
}