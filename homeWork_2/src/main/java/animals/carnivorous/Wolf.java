package animals.carnivorous;

import animals.Carnivorous;
import interfaces.Run;
import interfaces.Swim;
import interfaces.Voice;

public class Wolf extends Carnivorous implements Run, Voice, Swim {

    private String nameAnimal = "Wolf";

    @Override
    public String getAnimalName() {
        return nameAnimal;
    }

    @Override
    public String voice() {
        return "Wolf woof";
    }
}
