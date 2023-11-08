package homework3.models.animals;

import homework3.enams.AviarySize;
import homework3.interfaces.animals.Run;
import homework3.interfaces.animals.Voice;

public class Cat extends Carnivorous implements Run, Voice {
    private String type;

    public Cat(String name, int age, int hungerLevel, AviarySize animalSize, String type) {
        super(name, age, hungerLevel, animalSize);
        try {
            if (type.equals("Дикий") || type.equals("Домашний")) {
                this.type = type;
            } else {
            throw new Exception("Такого типа котика не бывает");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void run() {
        if (this.getHungerLevel() <= 0) {
            System.out.println("Кот не может бежать так как он голоден, он должен найти еду");
        } else if (type.equals("Дикий")) {
            System.out.println("Кот может бежать со скоростью 20 км/ч");
        } else {
            System.out.println("Домашние коты практически не бегают, они толстые");
        }
    }

        @Override
        public String voice() {
            return type.equals("Домашний") ? "мяу" : "р-р-р";
        }
}