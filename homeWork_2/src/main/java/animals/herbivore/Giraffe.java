package animals.herbivore;

import animals.Herbivore;
import animals.interfaces.Run;
import animals.interfaces.Swim;
import animals.interfaces.Voice;

public class Giraffe extends Herbivore implements Run, Swim, Voice {

    public Giraffe(String nameAnimal) {
        super(nameAnimal);
    }


    @Override
    public String voice() {
        return getNameAnimals() + "makes is sound: UAAAAAAAAAA";
    }

    @Override
    public void swim() {
        System.out.println(getNameAnimals() + " swims");
    }

    @Override
    public void run() {
        System.out.println("The " + getNameAnimals() + " is running");
    }
}
