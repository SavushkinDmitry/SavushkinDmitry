package animals.herbivore;

import animals.Herbivore;
import interfaces.Run;
import interfaces.Swim;
import interfaces.Voice;

public class Cow extends Herbivore implements Run, Swim, Voice {
    private String nameAnimal = "Cow";

    @Override
    public String getAnimalName() {
        return nameAnimal;
    }

    @Override
    public String voice() {
        return "Cow moo";
    }
}
