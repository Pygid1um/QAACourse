package ds.anosov.java.homework1.model;

import java.util.Scanner;

public class Kotik {

    private static int amountOfObjects;
    private int saturationLevel;
    private String name;
    private int age;
    private String color;
    private int weight;
    private String meow;
    Scanner scanner = new Scanner(System.in);

    //конструкторы
    public Kotik(int saturationLevel, String name, int age, String color, int weight, String meow) {
        this.saturationLevel = saturationLevel;
        this.name = name;
        this.age = age;
        this.color = color;
        this.weight = weight;
        this.meow = meow;
        amountOfObjects++;
    }

    public Kotik() {
        amountOfObjects++;
    }


    //геттеры и сеттеры
    public static int getAmountOfObjects() {
        return amountOfObjects;
    }

    public int getSaturationLevel() {
        return saturationLevel;
    }

    public void setSaturationLevel(int saturationLevel) {
        this.saturationLevel = saturationLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getMeow() {
        return meow;
    }

    public void setMeow(String meow) {
        this.meow = meow;
    }

    //методы
    public void play() {
        saturationLevel--;
        if (saturationLevel <= 0) {
            System.out.println("Котик голоден, он не может играть, надо его покормить!");
            eat();
        } else {
            System.out.println("Котик играет");
        }
    }

    public void sleep() {
        saturationLevel--;
        if (saturationLevel <= 0) {
            System.out.println("Котик голоден, он не может лечь спать, надо его покормить!");
            eat();
        } else {
            System.out.println("Котик лег спать");
        }
    }

    public void chaseMouse() {
        saturationLevel--;
        if (saturationLevel <= 0) {
            System.out.println("Котик голоден, он не может начать ловить мышей, надо его покормить!");
            eat();
        } else {
            System.out.println("Котик начал ловить мышей");
        }
    }

    public void walkOutside() {
        saturationLevel--;
        if (saturationLevel <= 0) {
            System.out.println("Котик голоден, он не может пойти на улицу гулять, надо его покормить!");
            eat();
        } else {
            System.out.println("Котик ушел гулять на улицу");
        }
    }

    public void callOwner() {
        saturationLevel--;
        if (saturationLevel <= 0) {
            System.out.println("Котик голоден, он не может мяукать и звать хозяина, надо его покормить!");
            eat();
        } else {
            System.out.println("Котик мяукает и зовет хозяина");
        }
    }

    public void eat() {
        System.out.print("Введите количество единиц сытости: ");
        int saturationLevel = scanner.nextInt();
        System.out.print("Введите название еды, которую получит котик: ");
        String nameOfFood = scanner.next();
        eat(saturationLevel, nameOfFood);
    }

    public void eat(int saturationLevel) {
        this.saturationLevel = this.saturationLevel + saturationLevel;
        System.out.println("Котику дали что-то, он всё съел!");
    }

    public void eat(int saturationLevel, String nameOfFood) {
        System.out.println("Котику дали " + nameOfFood + ", он всё съел!");
        this.saturationLevel = this.saturationLevel + saturationLevel;
        System.out.println("Уровень сытости котика равен: " + saturationLevel);
    }

    public void liveAnotherDay() {
        for (int i = 0; i < 24 ; i++) {
           int randomNumber = (int) (Math.random() * 5) + 1;
           switch (randomNumber) {
               case 1:
                   play();
                   break;
               case 2:
                   chaseMouse();
                   break;
               case 3:
                   sleep();
                   break;
               case 4:
                   walkOutside();
                   break;
               case 5:
                   callOwner();
                   break;
           }
        }

    }

}
