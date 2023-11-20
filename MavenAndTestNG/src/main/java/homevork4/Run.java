package homevork4;

import homevork4.calculations.Calculations;
import homevork4.scanning.ScannerValues;

/**
 * Класс является точкой входа в приложение Калькулятор, в нем создаются объекты ключевых классов и вызываются
 * основные методы для проведения расчетов.
 */
public class Run {

    public static void main(String[] args) {
        //Создание объекта класса Calculations
        Calculations calculations = new Calculations();

        //Создание объекта класса Scanner
        ScannerValues scannerValues = new ScannerValues();

        //Вызов у объекта класса Scanner метода сканирования введенных чисел и математического оператора
        scannerValues.scannerInput();

        //Вызов у объекта класса Calculations метода математического расчета
        calculations.calculation();
    }
}