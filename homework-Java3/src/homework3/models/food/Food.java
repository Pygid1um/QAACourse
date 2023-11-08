package homework3.models.food;

import java.util.Objects;

public abstract class Food {
    private String name;
    private int satisfyingHunger;

    public Food(String name, int satisfyingHunger) {
        Objects.requireNonNull(name, "Имя не может быть null!");
            this.name = name;
            this.satisfyingHunger = satisfyingHunger;
    }

    public int getSatisfyingHunger() {
        return satisfyingHunger;
    }
}