package animals;

public abstract class Animal {

    private String nameAnimal;

    public String getAnimalName() {
        return nameAnimal;
    }

    public abstract void eat(Food food);

}
