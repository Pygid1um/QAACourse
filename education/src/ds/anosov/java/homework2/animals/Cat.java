package ds.anosov.java.homework2.animals;

public class Cat extends Carnivorous implements Run, Voice {
    private String type;

    public Cat(String name, int age, int hungerLevel, String type) {
        super(name, age, hungerLevel);
        if (type.equals("Дикий") || type.equals("Домашний")) {
            this.type = type;
        } else {
            System.out.println("Такого типа котика не бывает");
        }
    }

    @Override
    public void run() {
        if (this.getHungerLevel() <= 0) {
            System.out.println("Кот не может бежать так как он голоден, он должен найти еду");
        } else if (type.equals("Дикий")) {
            System.out.println("Кот может бежать со скоростью 20 км/ч");
        } else {
            System.out.println("Домашние коты практически не бегают, они толстые");
        }
    }

        @Override
        public String voice() {
            return type.equals("Домашний") ? "мяу" : "р-р-р";
        }
}