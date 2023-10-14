package ds.anosov.java.homework2.animals;

import ds.anosov.java.homework2.food.Food;
import ds.anosov.java.homework2.food.Meat;

public class Herbivore extends Animals {
    public Herbivore(String name, int age, int hungerLevel) {
        super(name, age, hungerLevel);
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            System.out.println("Травоядные не едят мясо! Переданная еда не подходит данному животному!");
        } else {
           super.setHungerLevel(food.getSatisfyingHunger());
            System.out.println("Травоядное животное покормлено! Оно съело всё что ей дали");
        }
    }
}
