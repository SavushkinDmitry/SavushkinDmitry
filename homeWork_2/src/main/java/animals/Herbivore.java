package animals;

import food.Food;
import food.Grass;

public class Herbivore extends Animal {

    private int satiety = 0;

    public Herbivore(String nameAnimal) {
        super(nameAnimal);
    }

    @Override
    public void eat(Food _food) {
        if (_food instanceof Grass) {
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
