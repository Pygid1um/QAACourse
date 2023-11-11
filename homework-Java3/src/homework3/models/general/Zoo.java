package homework3.models.general;

import homework3.enums.AnimalsType;
import homework3.enums.AviarySize;
import homework3.interfaces.animals.Swim;
import homework3.models.animals.*;
import homework3.models.food.*;

import java.util.ArrayList;

public class Zoo {
    public static void main(String[] args) {
        Cat cat = new Cat("Василий", 4, 3, AviarySize.SMALL, AnimalsType.DOMESTIC);
        Duck duck = new Duck("Дональд", 5, 5, AviarySize.SMALL,AnimalsType.WILD, false);
        Eagle eagle = new Eagle("Джо", 6, 7, AviarySize.LARGE);
        Elephant elephant = new Elephant("Микки", 15, 10, AviarySize.EXTRA_LARGE);
        Fish fish = new Fish("Мия", 1, 9, AviarySize.MEDIUM);
        Turtle turtle = new Turtle("Серега", 23, 8, AviarySize.LARGE);

        Hay hay = new Hay("Из клевера", "Скошенная", 10);
        Leaves leaves = new Leaves("Листья дуба", "Свежая", 4);
        Liver liver = new Liver("Печень", 10);
        Seaweed seaweed = new Seaweed("Чука", "Не свежая", 8);
        Steak steak = new Steak("Стейк", 13);
        WildAnimalMeat wildAnimalMeat = new WildAnimalMeat("Мясо оленя", 10);

        Worker worker = new Worker("Петя", 44, "Кипер");
        worker.feed(elephant, leaves);
        worker.feed(cat, steak);
        worker.feed(eagle, seaweed);
        worker.feed(duck, wildAnimalMeat);

        System.out.println(worker.getVoice(cat));
        System.out.println(worker.getVoice(duck));
        System.out.println(worker.getVoice(eagle));
        System.out.println(worker.getVoice(elephant));

        ArrayList<Swim> animalsArrayList = new ArrayList<>();
        animalsArrayList.add(fish);
        animalsArrayList.add(turtle);
        animalsArrayList.add(new Turtle("Шустрый", 19, 11, AviarySize.SMALL));
        animalsArrayList.add(new Fish("Сом", 1, 12, AviarySize.MEDIUM));

        for (Swim animalsSwim : animalsArrayList) {
            animalsSwim.swim();
        }

        Aviary<Carnivorous> carnivorousAviary = new Aviary<>("Клетка", AviarySize.LARGE);
        carnivorousAviary.putAnimal(eagle.getId(), eagle);
        carnivorousAviary.putAnimal(cat.getId(), cat);
        carnivorousAviary.putAnimal(fish.getId(), fish);
        carnivorousAviary.putAnimal(fish.getId(), fish);

        carnivorousAviary.removeAnimal(eagle.getId());
        System.out.println(carnivorousAviary);

        Carnivorous animal = carnivorousAviary.getAnimal(fish.getId());
        System.out.println(animal);
    }
}