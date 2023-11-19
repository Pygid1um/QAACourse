package homevork4.scanning;

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
     * Переменная для хранения первого введенного числа
     */
    private int firstNumber;

    /**
     * Переменная для хранения второго введенного числа
     */
    private int secondNumber;

    /**
     * Переменная для хранения введенного математического символа
     */
    private String sign;

    /**
     * Возвращает значение поля firstNumber
     * @return значение поля firstNumber
     */
    public int getFirstNumber() {
        return firstNumber;
    }

    /**
     * Возвращает значение поля secondNumber
     * @return значение поля secondNumber
     */
    public int getSecondNumber() {
        return secondNumber;
    }

    /**
     * Возвращает значение поля sign
     * @return значение поля sign
     */
    public String getSign() {
        return sign;
    }

    /**
     * Метод в котором сканер считывает числа и математический знак
     */
    public void scannerInput() {
        System.out.print("Введите первое число: ");
        firstNumber = scanner.nextInt();
        System.out.print("Введите математический знак: ");
        sign = scanner.next();
        System.out.print("Введите второе число: ");
        secondNumber = scanner.nextInt();
    }
}