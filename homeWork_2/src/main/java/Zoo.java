import food.Food;
import animals.carnivorous.Bird;
import animals.carnivorous.Fish;
import animals.carnivorous.Wolf;
import animals.herbivore.Duck;
import animals.herbivore.Giraffe;
import animals.herbivore.Sheep;
import food.Grass;
import food.Meat;
import animals.interfaces.Swim;

public class Zoo {
    public static void main(String[] args) {
        /*Animal cow = new Cow();
        Animal duck = new Duck();
        Animal sheep = new Sheep();
        Animal fish = new Fish();
        Animal bird = new Bird();
        Animal wolf = new Wolf();*/
        Giraffe girrafe = new Giraffe("Girrafe");
        Duck duck = new Duck("Duck");
        Sheep sheep = new Sheep("Sheep");
        Fish fish = new Fish("Fish");
        Bird bird = new Bird("Bird");
        Wolf wolf = new Wolf("Wolf");


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

        Swim[] pond = new Swim[] {girrafe, fish, duck, wolf};

        System.out.println("Pond");
        for (int i = 0; i < pond.length; i++) {
            pond[i].swim();
        }



    }




}
