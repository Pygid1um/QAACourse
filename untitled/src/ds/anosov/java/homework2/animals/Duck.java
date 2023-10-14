package ds.anosov.java.homework2.animals;

public class Duck extends Herbivore implements Fly, Run, Swim, Voice {
    public Duck(String name, int age, int hungerLevel, String type) {
        super(name, age, hungerLevel);
        if(type.equals("Дикая") || type.equals("Домашняя")) {
            this.type = type;
        } else {
            System.out.println("Такого типа утки не бывает");
        }
    }

    private String type;

    private String gender() {
        String gender = null;
        int randomNumber = (int) (Math.random() * 2) + 1;
        switch (randomNumber) {
            case 1 -> gender = "Самка";
            case 2 -> gender = "Самец";
        }
        return gender;
    }

    @Override
    public void fly() {
        if (super.getHungerLevel() <= 0) {
            System.out.println("Утка не может полететь так как она голодная, она должна найти еду");
        } else if (type.equals("Дикая")) {
            if (super.getAge() > 2 && gender().equals("Самец")) {
                System.out.println("Утра вожак, сможет пролететь 100 км");
            }  else if (super.getAge() > 2 && gender().equals("Самка")) {
                System.out.println("Утка самка, сможет пролететь 50 км");
            } else if (super.getAge() < 2) {
                System.out.println("Утро еще совсем ребенок, может пролететь 5 км");
            }
            super.setHungerLevel(super.getHungerLevel() - 1);
        } else {
            System.out.println("Домашняя уточка не умеет летать :(");
        }
    }

    @Override
    public void run() {
        if (super.getHungerLevel() <= 0) {
            System.out.println("Утка не может бежать так как она голодная, она должна найти еду");
        } else {
            System.out.println("Уточка бегает очень медленно..");
            super.setHungerLevel(super.getHungerLevel() - 1);
        }
    }

    @Override
    public void swim() {
        if (super.getHungerLevel() <= 0) {
            System.out.println("Утка не может плыть так как она голодная, она должна найти еду");
        } else {
            System.out.println("Уточка плавает по поверхности воды. Очень довольна!");
            super.setHungerLevel(super.getHungerLevel() - 1);
        }
    }

    @Override
    public String voice() {
        return "Кря-кря";
    }
}