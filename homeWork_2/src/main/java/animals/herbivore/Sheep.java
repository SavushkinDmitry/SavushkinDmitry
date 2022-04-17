package animals.herbivore;

import animals.Herbivore;
import interfaces.Run;
import interfaces.Voice;

public class Sheep extends Herbivore implements Run, Voice {

    private String nameAnimal = "Sheep";

    @Override
    public String getAnimalName() {
        return nameAnimal;
    }

    @Override
    public String voice() {
        return "Sheep baa";
    }
}
