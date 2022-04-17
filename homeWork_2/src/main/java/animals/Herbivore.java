package animals;

import food.Grass;

public class Herbivore extends Animal {

    @Override
    public String getAnimalName() {
        return super.getAnimalName();
    }

    @Override
    public void eat(Food _food) {
        Animal animals = new Herbivore();
        if (_food instanceof Grass) {
            System.out.println(getAnimalName() + " will eat " + _food.getName());
        } else {
            System.out.println(getAnimalName() + " don't will eat " + _food.getName());
        }
    }
}
