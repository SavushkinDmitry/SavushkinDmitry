package animals.carnivorous;

import animals.Carnivorous;
import interfaces.Fly;
import interfaces.Voice;

public class Bird extends Carnivorous implements Fly, Voice {

    private String nameAnimal = "Bird";

    @Override
    public String getAnimalName() {
        return nameAnimal;
    }

    @Override
    public String voice() {
        return "Bird chirp";
    }
}
