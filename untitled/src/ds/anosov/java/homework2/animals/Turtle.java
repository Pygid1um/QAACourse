package ds.anosov.java.homework2.animals;

public class Turtle extends Herbivore implements Swim {
    public Turtle(String name, int age, int hungerLevel) {
        super(name, age, hungerLevel);
    }

    @Override
    public void swim() {
        if (super.getHungerLevel() <= 0) {
            System.out.println("Черепаха голодная, она должна найти еду");
        } else {
            System.out.println("Черепаха плывет по океану и радуется жизни");
            super.setHungerLevel(super.getHungerLevel() - 1);
        }
    }
}