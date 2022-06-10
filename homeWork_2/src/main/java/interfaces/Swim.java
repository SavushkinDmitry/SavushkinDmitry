package interfaces;

import animals.Animal;

public interface Swim {
    public default void swim() {
        System.out.println("Плывёт");
    }
}
