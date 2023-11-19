package homework3.models.animals;

import homework3.enums.AviarySize;
import homework3.interfaces.animals.Fly;
import homework3.interfaces.animals.Voice;

public class Eagle extends Carnivorous implements Fly, Voice {
    public Eagle(String name, int age, int hungerLevel, AviarySize animalSize) {
        super(name, age, hungerLevel, animalSize);
    }

    @Override
    public void fly() {
        if (getHungerLevel() <= 0) {
            System.out.println("Орел не может лететь так как он голодный, он должен найти еду");
        }else {
            System.out.println("Орел летит в поисках новой жертвы");
            setHungerLevel(getHungerLevel() - 1);
        }
    }

    @Override
    public String voice() {
        return "а-а-а-р";
    }
}