package animals.herbivore;

import animals.Herbivore;
import interfaces.Run;
import interfaces.Swim;
import interfaces.Voice;

public class Duck extends Herbivore implements Swim, Voice, Run {

    private String nameAnimal = "Duck";

    @Override
    public String getAnimalName() {
        return nameAnimal;
    }

    @Override
    public String voice() {
        return "Duck quack";
    }
}
