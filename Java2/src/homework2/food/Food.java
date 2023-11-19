package homework2.food;

public abstract class Food {
    private String name;
    private int satisfyingHunger;

    public Food(String name, int satisfyingHunger) {
        if (name != null) {
            this.name = name;
            this.satisfyingHunger = satisfyingHunger;
        }
    }

    public int getSatisfyingHunger() {
        return satisfyingHunger;
    }
}