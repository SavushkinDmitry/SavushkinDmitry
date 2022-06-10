package animals.aviary;

import animals.Animal;

import java.util.HashSet;
import java.util.Objects;
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

    public boolean addAnimal(T animal) {
        if (animal.getAnimalSize().getValue() <= sizeAviary.getValue()) {
            if(animalAviary.add(animal)) {
                System.out.println(animal.getNameAnimals() + " ��������� � ������ " + getSizeAviary() + " " + animal.hashCode());
                return true;
            } else {
                System.out.println(animal.getNameAnimals() + " ��� ������������ � �������. ");
                return false;
            }
        } else {
            System.out.println(animal.getNameAnimals() + " �� ��������� � ������, ��� ��� " +
                    "�������� ������� ������� ��� ������� " + getSizeAviary());
            return false;
        }
    }

    public void getAnimals() {
        System.out.println("������ �������� " + getSizeAviary() + " ����� ��������: " + animalAviary.size() + ". ");
    }

    public void removeAnimal(T animal) {
        System.out.println(animal.getNameAnimals() + " �������. ");
        animalAviary.remove(animal);
    }

    public T getAnimalLink(String nameAnimals) {
        for (T animal : animalAviary) {
            if (animal.getNameAnimals().equals(nameAnimals)) {
                System.out.println("������ �� " + animal.getNameAnimals() + ": " + animal);
            } else {
                System.out.println("������ �� ��� ������ � �������. ");
            }
        }
        return null;
    }
}
