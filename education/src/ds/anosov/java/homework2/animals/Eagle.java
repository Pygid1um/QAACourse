package ds.anosov.java.homework2.animals;

public class Eagle extends Carnivorous implements Fly, Voice {
    public Eagle(String name, int age, int hungerLevel) {
        super(name, age, hungerLevel);
    }

    @Override
    public void fly() {
        if (this.getHungerLevel() <= 0) {
            System.out.println("Орел не может лететь так как он голодный, он должен найти еду");
        }else {
            System.out.println("Орел летит в поисках новой жертвы");
            this.setHungerLevel(this.getHungerLevel() - 1);
        }
    }

    @Override
    public String voice() {
        return "а-а-а-р";
    }
}