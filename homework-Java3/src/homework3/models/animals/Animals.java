package homework3.models.animals;

import homework3.enums.AviarySize;
import homework3.models.food.Food;

import java.util.Objects;

public abstract class Animals {
    private String name;
    private int age;
    private int hungerLevel;
    private AviarySize animalSize;
    private String id;

    public abstract void eat(Food food);

    public Animals(String name, int age, int hungerLevel, AviarySize animalSize) {
        Objects.requireNonNull(name, "Имя животного не может быть null");
        this.name = name;
        this.age = age;
        this.hungerLevel = hungerLevel;
        this.animalSize = animalSize;
    }

    protected int getAge() {
        return age;
    }

    protected int getHungerLevel() {
        return hungerLevel;
    }

    public AviarySize getAnimalSize() {
        return animalSize;
    }

    public String getId() {
        return this.id = String.valueOf(hashCode()) ;
    }

    protected void setHungerLevel(int hungerLevel) {
        this.hungerLevel = hungerLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animals animals = (Animals) o;
        return age == animals.age && hungerLevel == animals.hungerLevel && Objects.equals(name, animals.name)
                && animalSize == animals.animalSize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, hungerLevel, animalSize);
    }

    @Override
    public String toString() {
        return "Animals{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hungerLevel=" + hungerLevel +
                ", animalSize=" + animalSize +
                ", id='" + id + '\'' +
                '}';
    }
}