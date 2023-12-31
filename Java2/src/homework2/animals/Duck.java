package homework2.animals;

public class Duck extends Herbivore implements Fly, Run, Swim, Voice {
    private String type;
    private String gender;

    public Duck(String name, int age, int hungerLevel, String type, String gender) {
        super(name, age, hungerLevel);
        this.gender = gender;
        if(type.equals("Дикая") || type.equals("Домашняя")) {
            this.type = type;
        } else {
            System.out.println("Такого типа утки не бывает");
        }
    }

    @Override
    public void fly() {
        if (this.getHungerLevel() <= 0) {
            System.out.println("Утка не может полететь так как она голодная, она должна найти еду");
        } else if (type.equals("Дикая")) {
            if (this.getAge() > 2 && this.gender.equals("Самец")) {
                System.out.println("Утра вожак, сможет пролететь 100 км");
            }  else if (this.getAge() > 2 && this.gender.equals("Самка")) {
                System.out.println("Утка самка, сможет пролететь 50 км");
            } else if (this.getAge() < 2) {
                System.out.println("Утро еще совсем ребенок, может пролететь 5 км");
            }
            this.setHungerLevel(this.getHungerLevel() - 1);
        } else {
            System.out.println("Домашняя уточка не умеет летать :(");
        }
    }

    @Override
    public void run() {
        if (this.getHungerLevel() <= 0) {
            System.out.println("Утка не может бежать так как она голодная, она должна найти еду");
        } else {
            System.out.println("Уточка бегает очень медленно..");
            this.setHungerLevel(this.getHungerLevel() - 1);
        }
    }

    @Override
    public void swim() {
        if (this.getHungerLevel() <= 0) {
            System.out.println("Утка не может плыть так как она голодная, она должна найти еду");
        } else {
            System.out.println("Уточка плавает по поверхности воды. Очень довольна!");
            this.setHungerLevel(this.getHungerLevel() - 1);
        }
    }

    @Override
    public String voice() {
        return "Кря-кря";
    }
}