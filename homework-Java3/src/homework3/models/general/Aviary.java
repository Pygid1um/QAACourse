package homework3.models.general;

import homework3.enams.AviarySize;
import homework3.exceptions.AviarySizeOutOfBoundsException;
import homework3.models.animals.Animals;

import java.util.HashMap;
import java.util.Map;

public class Aviary<T extends Animals> {

    private String aviaryName;
    private AviarySize aviarySize;
    private Map<String, T> aviary = new HashMap<>();

    public Aviary(String aviaryName, AviarySize aviarySize) {
        this.aviaryName = aviaryName;
        this.aviarySize = aviarySize;
    }

    public void putAnimal(String key, T value) {
        try {
            if (value.getAnimalSize().ordinal() <= this.aviarySize.ordinal()) {
                aviary.put(key, value);
            } else {
                throw new AviarySizeOutOfBoundsException("Размер животного больше чем размер вольера!");
            }
        } catch (AviarySizeOutOfBoundsException exception) {
                exception.printStackTrace();
        }
    }

    public void removeAnimal(String key) {
        aviary.remove(key);
    }

    public T getAnimal(String key) {
        return aviary.get(key);
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