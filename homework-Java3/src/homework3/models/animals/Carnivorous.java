package homework3.models.animals;

import homework3.enums.AviarySize;
import homework3.models.food.Food;
import homework3.exceptions.WrongFoodException;
import homework3.models.food.Meat;

public class Carnivorous extends Animals {
    public Carnivorous(String name, int age, int hungerLevel, AviarySize animalSize) {
        super(name, age, hungerLevel, animalSize);
    }

    @Override
    public void eat(Food food) {
        try {
            if (food instanceof Meat) {
                setHungerLevel(getHungerLevel() + food.getSatisfyingHunger());
                System.out.println("Хищное животное покормлено! Оно съело всё что ей дали");
            } else {
                throw new WrongFoodException("Хищники не едят траву! Переданная еда не подходит данному животному!");
            }
        } catch (WrongFoodException exception) {
            exception.printStackTrace();
        }
    }
}