package homework3.models.animals;

import homework3.enums.AnimalsType;
import homework3.enums.AviarySize;
import homework3.interfaces.animals.Fly;
import homework3.interfaces.animals.Run;
import homework3.interfaces.animals.Swim;
import homework3.interfaces.animals.Voice;

public class Duck extends Herbivore implements Fly, Run, Swim, Voice {
    private final AnimalsType duckType;
    private final boolean isMale;

    public Duck(String name, int age, int hungerLevel, AviarySize animalSize, AnimalsType duckType, boolean isMale) {
        super(name, age, hungerLevel, animalSize);
        this.isMale = isMale;
        this.duckType = duckType;
    }

    @Override
    public void fly() {
        if (getHungerLevel() <= 0) {
            System.out.println("Утка не может полететь так как она голодная, она должна найти еду");
        } else if (duckType.equals(AnimalsType.WILD)) {
            if (getAge() > 2 && isMale) {
                System.out.println("Утра вожак, сможет пролететь 100 км");
            }  else if (getAge() > 2 && !(isMale)) {
                System.out.println("Утка самка, сможет пролететь 50 км");
            } else if (getAge() < 2) {
                System.out.println("Утро еще совсем ребенок, может пролететь 5 км");
            }
            setHungerLevel(getHungerLevel() - 1);
        } else {
            System.out.println("Домашняя уточка не умеет летать :(");
        }
    }

    @Override
    public void run() {
        if (getHungerLevel() <= 0) {
            System.out.println("Утка не может бежать так как она голодная, она должна найти еду");
        } else {
            System.out.println("Уточка бегает очень медленно..");
            setHungerLevel(getHungerLevel() - 1);
        }
    }

    @Override
    public void swim() {
        if (getHungerLevel() <= 0) {
            System.out.println("Утка не может плыть так как она голодная, она должна найти еду");
        } else {
            System.out.println("Уточка плавает по поверхности воды. Очень довольна!");
            setHungerLevel(getHungerLevel() - 1);
        }
    }

    @Override
    public String voice() {
        return "Кря-кря";
    }
}