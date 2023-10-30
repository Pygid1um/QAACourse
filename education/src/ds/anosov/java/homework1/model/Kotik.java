package ds.anosov.java.homework1.model;


public class Kotik {

    private static int countOfObjects;
    private int saturationLevel;
    private String name;
    private int age;
    private String color;
    private int weight;
    private String meow;

    //конструкторы
    public Kotik(int saturationLevel, String name, int age, String color, int weight, String meow) {
        this.saturationLevel = saturationLevel;
        this.name = name;
        this.age = age;
        this.color = color;
        this.weight = weight;
        this.meow = meow;
        countOfObjects++;
    }

    public Kotik() {
        countOfObjects++;
    }

    //геттеры и сеттеры
    public static int getCountOfObjects() {
        return countOfObjects;
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
        if (saturationLevel <= 0) {
            System.out.println("Котик голоден, он не может играть, надо его покормить!");
            eat();
        } else {
            System.out.println("Котик играет");
            saturationLevel--;
        }
    }

    public void sleep() {
        if (saturationLevel <= 0) {
            System.out.println("Котик голоден, он не может лечь спать, надо его покормить!");
            eat();
        } else {
            System.out.println("Котик лег спать");
            saturationLevel--;
        }
    }

    public void chaseMouse() {
        if (saturationLevel <= 0) {
            System.out.println("Котик голоден, он не может начать ловить мышей, надо его покормить!");
            eat();
        } else {
            System.out.println("Котик начал ловить мышей");
            saturationLevel--;
        }
    }

    public void walkOutside() {
        if (saturationLevel <= 0) {
            System.out.println("Котик голоден, он не может пойти на улицу гулять, надо его покормить!");
            eat();
        } else {
            System.out.println("Котик ушел гулять на улицу");
            saturationLevel--;
        }
    }

    public void callOwner() {
        if (saturationLevel <= 0) {
            System.out.println("Котик голоден, он не может мяукать и звать хозяина, надо его покормить!");
            eat();
        } else {
            System.out.println("Котик мяукает и зовет хозяина");
            saturationLevel--;
        }
    }

    public void eat() {
        eat(20, "Колбаса");
    }

    public void eat(int saturationLevel) {
        eat(saturationLevel, "Сосиска");
    }

    public void eat(int saturationLevel, String nameOfFood) {
        System.out.println("Котику дали " + nameOfFood + ", он всё съел!");
        this.saturationLevel = saturationLevel;
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