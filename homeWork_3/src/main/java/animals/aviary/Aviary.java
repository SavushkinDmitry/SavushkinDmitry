package animals.aviary;

import animals.Animal;

import java.util.HashSet;
import java.util.Set;

public class Aviary<T extends Animal> {
    private Size sizeAviary;

    public Size getSizeAviary() {
        return sizeAviary;
    }

    public Aviary(Size sizeAviary) {
        this.sizeAviary = sizeAviary;
    }

    private Set<T> animalAviary = new HashSet<>();

    public void addAnimal(T animal) {
        if (animal.getAnimalSize().getValue() <= sizeAviary.getValue()) {
            System.out.println(animal.getNameAnimals() + " добавлено в вольер " + getSizeAviary());
            animalAviary.add(animal);
        } else {
            System.out.println(animal.getNameAnimals() + " не добавлено в вольер " + getSizeAviary());
        }
    }

    public void removeAnimal(T animal) {
        System.out.println(animal.getNameAnimals() + " удалено. ");
        animalAviary.remove(animal);
    }

    public T getAnimalLink(String nameAnimals) {
        for (T t : animalAviary) {
            if (t.getNameAnimals().equals(nameAnimals)) {
                System.out.println("—сылка на " + t.getNameAnimals() + ": " + t);
            } else {
                System.out.println("ќбъект не был найден в вольере. ");
            }
        }
        return null;
    }

}
