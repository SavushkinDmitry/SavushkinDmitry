package food;

import animals.Food;

public class Meat extends Food {

    @Override
    public String getName() {
        return "Meat";
    }

    @Override
    protected int addSatiety() {
        return 5;
    }

}
