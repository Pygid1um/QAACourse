package homework4;

import homework4.calculations.Calculations;

/**
 * Класс является точкой входа в приложение Калькулятор
 */
public class Run {

    public static void main(String[] args) {
        //Создание объекта класса Calculations
        Calculations calculations = new Calculations();

        //Вызов у объекта класса Calculations метода сканирования значений с консоли
        calculations.scannerInput();

        //Вызов у объекта класса Calculations метода математического расчета
        calculations.calculation();

        //Вызов у объекта класса Calculations метода вывода результата расчета в консоль
        calculations.consoleOutput();
    }
}