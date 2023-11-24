package homework2.food;

public class Grass extends Food {
    private String freshLevel;

    public Grass(String name, String freshLevel, int satisfyingHunger) {
        super(name, satisfyingHunger);
        this.freshLevel = freshLevel;
    }
}