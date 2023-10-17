package ds.anosov.java.homework2.animals;

import ds.anosov.java.homework2.food.Food;
import ds.anosov.java.homework2.food.Grass;

public class Carnivorous extends Animals {
    public Carnivorous(String name, int age, int hungerLevel) {
        super(name, age, hungerLevel);
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Grass) {
            System.out.println("Хищники не едят траву! Переданная еда не подходит данному животному!");
        } else {
            this.setHungerLevel(this.getHungerLevel() + food.getSatisfyingHunger());
            System.out.println("Хищное животное покормлено! Оно съело всё что ей дали");
        }
    }
}