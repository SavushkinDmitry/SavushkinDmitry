package animals.carnivorous;

import animals.Carnivorous;
import animals.interfaces.Swim;

public class Fish extends Carnivorous implements Swim {

    private String nameAnimal;

    public Fish(String nameAnimal) {
        super(nameAnimal);
    }


    @Override
    public void swim() {
        System.out.println(getNameAnimals() + " swims");
    }
}
