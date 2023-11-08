package homework1;

import homework1.model.Kotik;

public class Application {
    public static void main(String[] args) {
        Kotik firstKotik = new Kotik(25, "Василий", 6, "Рыжий", 2, "хочу жрать!");
        Kotik secondKotik = new Kotik();
        secondKotik.setSaturationLevel(25);
        secondKotik.setName("Мурка");
        secondKotik.setAge(5);
        secondKotik.setColor("Белая");
        secondKotik.setWeight(3);
        secondKotik.setMeow("мяу");

        firstKotik.liveAnotherDay();
        System.out.println("Имя котика: " + firstKotik.getName());
        System.out.println(firstKotik.getMeow().equals(secondKotik.getMeow()));
        System.out.println("Количество объектов класса Kotik: " + Kotik.getCountOfObjects());
    }

}
