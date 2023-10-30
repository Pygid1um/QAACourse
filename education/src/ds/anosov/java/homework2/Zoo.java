package ds.anosov.java.homework2;

import ds.anosov.java.homework2.animals.*;
import ds.anosov.java.homework2.food.*;

import java.util.ArrayList;

public class Zoo {
    public static void main(String[] args) {
        Cat cat = new Cat("Василий", 4, 3, "Домашний");
        Duck duck = new Duck("Дональд", 5, 5, "Дикая", "Самка");
        Eagle eagle = new Eagle("Джо", 6, 7);
        Elephant elephant = new Elephant("Микки", 15, 10);
        Fish fish = new Fish("Мия", 1, 9);
        Turtle turtle = new Turtle("Серега", 23, 8);

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
        animalsArrayList.add(new Turtle("Шустрый", 19, 11));
        animalsArrayList.add(new Fish("Сом", 1, 12));

        for (Swim animalsSwim : animalsArrayList) {
            animalsSwim.swim();
        }
    }
}