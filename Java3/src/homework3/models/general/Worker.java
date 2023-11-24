package homework3.models.general;

import homework3.models.animals.Animals;
import homework3.models.food.Food;
import homework3.interfaces.animals.Voice;

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