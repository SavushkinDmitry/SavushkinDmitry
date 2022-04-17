package animals.carnivorous;

import animals.Carnivorous;
import interfaces.Swim;

public class Fish extends Carnivorous implements Swim {

    private String nameAnimal = "Piranha";

    @Override
    public String getAnimalName() {
        return nameAnimal;
    }
}
