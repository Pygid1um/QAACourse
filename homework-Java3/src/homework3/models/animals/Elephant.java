package homework3.models.animals;

import homework3.enums.AviarySize;
import homework3.interfaces.animals.Run;
import homework3.interfaces.animals.Voice;

public class Elephant extends Herbivore implements Run, Voice {
    public Elephant(String name, int age, int hungerLevel, AviarySize animalSize) {
        super(name, age, hungerLevel, animalSize);
    }

    @Override
    public void run() {
        if (getHungerLevel() <= 0) {
            System.out.println("Слон не может бежать так как он голоден, он должна найти еду");
        } else if (getAge() < 50) {
            System.out.println("Слон бегает очень медленно..");
            setHungerLevel(getHungerLevel() - 1);
        } else {
            System.out.println("Слон не может бежать, он слишком старый!");
        }
    }

    @Override
    public String voice() {
        return "Ту-у-у";
    }
}