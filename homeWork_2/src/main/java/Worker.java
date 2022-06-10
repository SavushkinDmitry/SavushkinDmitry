import animals.Animal;
import food.Food;
import animals.interfaces.Voice;

public class Worker {

    private String nameWorker;

    public Worker(String nameWorker) {
        this.nameWorker = nameWorker;
    }

    public String getNameWorker() {
        return nameWorker;
    }

    public void feed(Animal animals, Food _food) {
        System.out.println(getNameWorker() + " trying to feed " + animals.getNameAnimals() + " the next food: " + _food.getName());
        animals.eat(_food);
    }

    public void getVoice(Voice animals) {
        System.out.println(animals.voice());
    }
}
