package homework3.models.animals;

import homework3.enums.AviarySize;
import homework3.interfaces.animals.Swim;

public class Fish extends Carnivorous implements Swim {
    public Fish(String name, int age, int hungerLevel, AviarySize animalSize) {
        super(name, age, hungerLevel, animalSize);
    }

    @Override
    public void swim() {
        if (getHungerLevel() <= 0) {
            System.out.println("Рыба голодная, она должна найти еду");
        } else {
            System.out.println("Рыба плывет и ищет новую добычу");
            setHungerLevel(getHungerLevel() - 1);
        }
    }
}