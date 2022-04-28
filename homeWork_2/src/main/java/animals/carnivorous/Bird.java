package animals.carnivorous;

import animals.Carnivorous;
import animals.interfaces.Fly;
import animals.interfaces.Voice;

public class Bird extends Carnivorous implements Fly, Voice {

    private String nameAnimal;

    public Bird(String nameAnimal) {
        super(nameAnimal);
    }


    @Override
    public String voice() {
        return getNameAnimals() + "makes is sound: ChikChirik";
    }

    @Override
    public void fly() {
        System.out.println(getNameAnimals() + " flying");
    }
}
