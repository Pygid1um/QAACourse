package homework2;

import homework2.animals.Animals;
import homework2.animals.Voice;
import homework2.food.Food;

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