package ds.anosov.java.homework2.animals;

public class Elephant extends Herbivore implements Run, Voice {
    public Elephant(String name, int age, int hungerLevel) {
        super(name, age, hungerLevel);
    }

    @Override
    public void run() {
        if (super.getHungerLevel() <= 0) {
            System.out.println("Слон не может бежать так как он голоден, он должна найти еду");
        } else if (super.getAge() < 50) {
            System.out.println("Слон бегает очень медленно..");
            super.setHungerLevel(super.getHungerLevel() - 1);
        } else {
            System.out.println("Слон не может бежать, он слишком старый!");
        }
    }

    @Override
        public String voice() {
        return "Ту-у-у";
    }
}