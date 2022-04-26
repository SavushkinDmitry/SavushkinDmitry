package food;

public class WrongFoodException extends Throwable {
    public WrongFoodException(String name) {
        System.out.println("Exception: " + name);
    }
}
