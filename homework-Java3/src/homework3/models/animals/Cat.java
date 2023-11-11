package homework3.models.animals;

import homework3.enums.AnimalsType;
import homework3.enums.AviarySize;
import homework3.exceptions.WrongAnimalsTypeException;
import homework3.interfaces.animals.Run;
import homework3.interfaces.animals.Voice;

public class Cat extends Carnivorous implements Run, Voice {
    private AnimalsType catType;

    public Cat(String name, int age, int hungerLevel, AviarySize animalSize, AnimalsType catType) {
        super(name, age, hungerLevel, animalSize);
        try {
            if (catType.equals(AnimalsType.WILD) || catType.equals(AnimalsType.DOMESTIC)) {
                this.catType = catType;
            } else {
            throw new WrongAnimalsTypeException("Такого типа котика не бывает");
            }
        } catch (WrongAnimalsTypeException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void run() {
        if (getHungerLevel() <= 0) {
            System.out.println("Кот не может бежать так как он голоден, он должен найти еду");
        } else if (catType.equals(AnimalsType.WILD)) {
            System.out.println("Кот может бежать со скоростью 20 км/ч");
        } else {
            System.out.println("Домашние коты практически не бегают, они толстые");
        }
    }

        @Override
        public String voice() {
            return catType.equals(AnimalsType.DOMESTIC) ? "мяу" : "р-р-р";
        }
}