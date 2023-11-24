package homework3.models.animals;

import homework3.enums.AviarySize;
import homework3.models.food.Food;
import homework3.models.food.Grass;
import homework3.exceptions.WrongFoodException;

public class Herbivore extends Animals {
    public Herbivore(String name, int age, int hungerLevel, AviarySize animalSize) {
        super(name, age, hungerLevel, animalSize);
    }

    @Override
    public void eat(Food food) {
        try {
            if (food instanceof Grass) {
                setHungerLevel(getHungerLevel() + food.getSatisfyingHunger());
                System.out.println("Травоядное животное покормлено! Оно съело всё что ей дали");
            } else {
                throw new WrongFoodException("Травоядные не едят мясо! Переданная еда не подходит данному животному!");
            }
        }catch (WrongFoodException ex) {
            ex.printStackTrace();
        }
    }
}