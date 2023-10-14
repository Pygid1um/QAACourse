package ds.anosov.java.homework2.animals;

import ds.anosov.java.homework2.food.Food;

public abstract class Animals {
    private String name;
    private int age;
    private int hungerLevel;

    public abstract void eat(Food food);

    public Animals(String name, int age, int hungerLevel) {
        if (name != null && age > 0 && hungerLevel > 0) {
            this.name = name;
            this.age = age;
            this.hungerLevel = hungerLevel;
        }
    }

    public int getAge() {
        return age;
    }

    public int getHungerLevel() {
        return hungerLevel;
    }

    public void setHungerLevel(int hungerLevel) {
        this.hungerLevel = hungerLevel;
    }
}