import animals.carnivorous.Bird;
import animals.carnivorous.Fish;
import animals.carnivorous.Wolf;
import animals.herbivore.Duck;
import animals.herbivore.Sheep;
import food.Grass;
import food.Meat;
import animals.herbivore.Cow;

public class Zoo {
    public static void main(String[] args) {
        /*Animal cow = new Cow();
        Animal duck = new Duck();
        Animal sheep = new Sheep();
        Animal fish = new Fish();
        Animal bird = new Bird();
        Animal wolf = new Wolf();*/
        Cow cow = new Cow();
        Duck duck = new Duck();
        Sheep sheep = new Sheep();
        Fish fish = new Fish();
        Bird bird = new Bird();
        Wolf wolf = new Wolf();


        Grass grass = new Grass();
        Meat meat = new Meat();

        Worker Dmitry = new Worker("Dmitry");

        Dmitry.feed(cow, meat);
        Dmitry.feed(cow, grass);
        Dmitry.feed(fish, meat);
        Dmitry.feed(wolf, grass);

        Dmitry.getVoice(cow);
        Dmitry.getVoice(wolf);

        //Next error
        //Dmitry.feed(fish);

    }




}
