package homework3.models.general;

import homework3.enums.AviarySize;
import homework3.exceptions.AviarySizeOutOfBoundsException;
import homework3.models.animals.Animals;
import java.util.HashMap;
import java.util.Map;

public class Aviary<T extends Animals> {

    private String aviaryName;
    private AviarySize aviarySize;
    private final Map<String, T> aviary = new HashMap<>();

    public Aviary(String aviaryName, AviarySize aviarySize) {
        this.aviaryName = aviaryName;
        this.aviarySize = aviarySize;
    }

    public void putAnimal(T value) {
        try {
            if (value.getAnimalSize().ordinal() <= aviarySize.ordinal()) {
                aviary.put(value.getName(), value);
            } else {
                throw new AviarySizeOutOfBoundsException("Размер животного больше чем размер вольера!");
            }
        } catch (AviarySizeOutOfBoundsException exception) {
                exception.printStackTrace();
        }
    }

    public void removeAnimal(T value) {
        aviary.remove(value.getName());
    }

    public T getAnimal(T key) {
        return aviary.get(key.getName());
    }

    @Override
    public String toString() {
        return "Aviary{" +
                "aviaryName='" + aviaryName + '\'' +
                ", aviarySize=" + aviarySize +
                ", aviary=" + aviary +
                '}';
    }
}