package homework2.animals;

public class Elephant extends Herbivore implements Run, Voice {
    public Elephant(String name, int age, int hungerLevel) {
        super(name, age, hungerLevel);
    }

    @Override
    public void run() {
        if (this.getHungerLevel() <= 0) {
            System.out.println("Слон не может бежать так как он голоден, он должна найти еду");
        } else if (this.getAge() < 50) {
            System.out.println("Слон бегает очень медленно..");
            this.setHungerLevel(this.getHungerLevel() - 1);
        } else {
            System.out.println("Слон не может бежать, он слишком старый!");
        }
    }

    @Override
    public String voice() {
        return "Ту-у-у";
    }
}