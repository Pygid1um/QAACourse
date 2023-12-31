package homework3.models.animals;

import homework3.enums.AviarySize;
import homework3.interfaces.animals.Swim;

public class Turtle extends Herbivore implements Swim {
    public Turtle(String name, int age, int hungerLevel, AviarySize animalSize) {
        super(name, age, hungerLevel, animalSize);
    }

    @Override
    public void swim() {
        if (getHungerLevel() <= 0) {
            System.out.println("Черепаха голодная, она должна найти еду");
        } else {
            System.out.println("Черепаха плывет по океану и радуется жизни");
            setHungerLevel(getHungerLevel() - 1);
        }
    }
}