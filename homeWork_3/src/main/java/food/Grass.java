package food;

import animals.Food;

public class Grass extends Food {

    @Override
    public String getName() {
        return "Grass";
    }

    @Override
    protected int addSatiety() {
        return 5;
    }


}
