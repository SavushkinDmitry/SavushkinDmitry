package animals;

public abstract class Food {
    private String nameFood;

    public String getName() {
        return nameFood;
    }
    protected abstract int addSatiety();

}
