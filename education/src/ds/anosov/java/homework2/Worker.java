package ds.anosov.java.homework2;

import ds.anosov.java.homework2.animals.Animals;
import ds.anosov.java.homework2.animals.Voice;
import ds.anosov.java.homework2.food.Food;

public class Worker {
    private String name;
    private int age;
    private String position;

    public Worker(String name, int age, String position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }

    public void feed(Animals animals, Food food) {
        animals.eat(food);
    }

    public String getVoice(Voice voice) {
      return voice.voice();
    }
}