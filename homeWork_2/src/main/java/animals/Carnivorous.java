package animals;

import food.Meat;

public class Carnivorous extends Animal {

    @Override
    public String getAnimalName() {
        return super.getAnimalName();
    }

    @Override
    public void eat(Food _food) {
        Animal animals = new Carnivorous();
        if(_food instanceof Meat) {
            System.out.println(getAnimalName() + " will eat " + _food.getName());
        } else {
            System.out.println(getAnimalName() + " don't will eat " + _food.getName());
        }
    }

}
