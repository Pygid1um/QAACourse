package ds.anosov.java.homework2.animals;

public class Fish extends Carnivorous implements Swim {
    public Fish(String name, int age, int hungerLevel) {
        super(name, age, hungerLevel);
    }

    @Override
    public void swim() {
        if (this.getHungerLevel() <= 0) {
            System.out.println("Рыба голодная, она должна найти еду");
        } else {
            System.out.println("Рыба плывет и ищет новую добычу");
            this.setHungerLevel(this.getHungerLevel() - 1);
        }
    }
}