package ds.anosov.java.homework2.food;

public abstract class Food {
    private String name;
    private int satisfyingHunger;

    public Food(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    public void setSatisfyingHunger(int satisfyingHunger) {
        this.satisfyingHunger = satisfyingHunger;
    }

    public int getSatisfyingHunger() {
        return satisfyingHunger;
    }
}