import model.Kotik;

public class Application {
    public static void main(String[] args) {
        Kotik bars = new Kotik();
        Kotik murz = new Kotik(23, "Murzik", 15, "Meow");

        System.out.println("------------Информация о котике-----------");
        bars.setKotik(18, "Barsik", 18, "Meow");

        System.out.println("Имя котика " + bars.getName() + " и его вес " + bars.getWeight());

        System.out.println("------------Сравнение meow котиков-----------");
        if (murz.getMeow().equals(bars.getMeow())) {
            System.out.println("Meow одинаково");
        } else {
            System.out.println("Meow " + murz.getMeow() + murz.getName());
            System.out.println("Meow " + bars.getMeow() + bars.getName());
        }

        System.out.println("------------Заниатия котика в течении дня-----------");
        murz.liveAnotherDay();


        System.out.println("------------Информация о количестве котиков-----------");
        System.out.println("Количество котиков: " + Kotik.getKotikCounter());


    }
}
