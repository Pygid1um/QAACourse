package ds.anosov.java.homework2.food;

public class Grass extends Food {
    public Grass(String name, String freshLevel) {
        super(name);
        this.freshLevel = freshLevel;
        switch (freshLevel) {
            case "Свежая"    -> super.setSatisfyingHunger(3);
            case "Скошенная" -> super.setSatisfyingHunger(2);
            case "Не свежая" -> super.setSatisfyingHunger(1);
        }
    }

    private String freshLevel;

    public String getFreshLevel() {
        return freshLevel;
    }
}