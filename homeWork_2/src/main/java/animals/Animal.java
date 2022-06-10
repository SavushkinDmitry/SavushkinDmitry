package animals;

import food.Food;

public abstract class Animal {

    private String nameAnimals;

    public Animal(String nameAnimals) {
        this.nameAnimals = nameAnimals;
    }

    public String getNameAnimals() {
        return nameAnimals;
    }


    public abstract void eat(Food food);

}
