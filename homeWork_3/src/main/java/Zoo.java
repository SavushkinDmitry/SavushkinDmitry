import animals.Carnivorous;
import animals.Food;
import animals.Herbivore;
import animals.aviary.Aviary;
import animals.aviary.Size;
import animals.carnivorous.Bird;
import animals.carnivorous.Fish;
import animals.carnivorous.Wolf;
import animals.herbivore.Duck;
import animals.herbivore.Giraffe;
import animals.herbivore.Sheep;
import animals.interfaces.Swim;
import food.Grass;
import food.Meat;
import food.WrongFoodException;

public class Zoo {
    public static void main(String[] args) throws WrongFoodException {

        Giraffe girrafe = new Giraffe("Giraffe", Size.HOUG);
        Duck duck = new Duck("Duck", Size.SMALL);
        Sheep sheep = new Sheep("Sheep", Size.MEDIUM);
        Fish fish = new Fish("Fish", Size.SMALL);
        Bird bird = new Bird("Bird", Size.LARGE);
        Wolf wolf = new Wolf("Wolf", Size.MEDIUM);

        Aviary<Carnivorous> carnivorousAviary = new Aviary<>(Size.LARGE);
        Aviary<Herbivore> herbivoreAviary = new Aviary<>(Size.MEDIUM);

        carnivorousAviary.addAnimal(wolf);
        herbivoreAviary.addAnimal(sheep);
        herbivoreAviary.addAnimal(girrafe);

        herbivoreAviary.getAnimalLink(sheep.getNameAnimals());
        herbivoreAviary.removeAnimal(girrafe);


        Food grass = new Grass();
        Food meat = new Meat();

        Worker Dmitry = new Worker("Dmitry");
        System.out.println("    --Worker Dmitry is feed animals--   ");
        Dmitry.feed(girrafe, meat);
        Dmitry.feed(girrafe, grass);
        Dmitry.feed(fish, meat);
        Dmitry.feed(wolf, grass);
        System.out.println("    --Animals make sounds--   ");
        Dmitry.getVoice(girrafe);
        Dmitry.getVoice(wolf);
        System.out.println("    --Animal methods test--   ");
        girrafe.run();
        bird.fly();
        //the next line error
        //Dmitry.feed(fish);
        Swim[] pond = new Swim[]{girrafe, fish, duck, wolf};

        System.out.println("Pond");
        for (int i = 0; i < pond.length; i++) {
            pond[i].swim();
        }


    }


}
