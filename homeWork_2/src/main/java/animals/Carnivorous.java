package animals;

import food.Food;
import food.Meat;

public class Carnivorous extends Animal {

    private int satiety = 0;
    public Carnivorous(String nameAnimal) {
        super(nameAnimal);
    }

    @Override
    public void eat(Food _food) {
        if(_food instanceof Meat) {
            System.out.println(getNameAnimals() + " will eat " + _food.getName());
            addSatiety(_food);
            System.out.println("Прибавлено сытости: " + getSatiety());
        } else {
            System.out.println(getNameAnimals() + " don't will eat " + _food.getName());
            System.out.println("Сытость " + getNameAnimals() + ": " + getSatiety());

        }
    }

    public void addSatiety(Food _food) {
        satiety += _food.addSatiety();
    }

    public int getSatiety() {
        return satiety;
    }
}
