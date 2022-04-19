package model;

import java.util.Scanner;

public class Kotik {

    //переменные
    private int satiety = 5;
    private int prettines;
    private int weight;
    private String nameFood;
    private String name;
    private String meow;

    //количество созданных котиков counter++
    private static int counter = 0;

    public static int getKotikCounter() {
        return counter;
    }

    //конструктор Kotik с параметрами
    public Kotik(int prettiness, String name, int weight, String meow) {
        counter++;
        this.prettines = prettiness;
        this.name = name;
        this.weight = weight;
        this.meow = meow;
    }

    //конструктор Kotik без параметров
    public Kotik() {
        counter++;
    }

    public void setKotik(int prettiness, String name, int weight, String meow) {
        this.prettines = prettiness;
        this.name = name;
        this.weight = weight;
        this.meow = meow;
    }

    /*
    Методы get и set для переменных Kotik
     */

    public int getSatiety() {
        return satiety;
    }

    public String getNameFood() {
        return nameFood;
    }

    public int getPrettines() {
        return prettines;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String getMeow() {
        return meow;
    }

    public void setSatiety(int satiety) {
        this.satiety = satiety;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }

    public void setPrettines(int prettines) {
        this.prettines = prettines;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setMeow(String meow) {
        this.meow = meow;
    }

    /*
            Методы поведения котика: play() - играть, sleep() - спать,
            chaseMouse() - ловить мышей, go() - ходить, sit() - сидеть.
             */
    public boolean play() {
        if (satiety <= 0) {
            System.out.println("Котик " + name + " хочет есть!");
            eat();
            return false;
        } else {
            System.out.println("Котик " + name + " играет");
            System.out.println("Сытость котика: " + satiety + "\n ");
            satiety--;
            return true;
        }

    }

    public boolean sleep() {
        if (satiety <= 0) {
            System.out.println("Котик " + name + " хочет есть!");
            eat();
            return false;
        } else {
            System.out.println("Котик " + name + " спит");
            System.out.println("Сытость котика: " + satiety + "\n ");
            satiety--;
            return true;
        }
    }

    public boolean sit() {
        if (satiety <= 0) {
            System.out.println("Котик " + name + " хочет есть!");
            eat();
            return false;
        } else {
            System.out.println("Котик " + name + " сидит");
            System.out.println("Сытость котика: " + satiety + "\n ");
            satiety--;
            return true;
        }
    }

    public boolean chaseMouse() {
        if (satiety <= 0) {
            System.out.println("Котик " + name + " хочет есть!");
            eat();
            return false;
        } else {
            System.out.println("Котик " + name + " ловит мышей");
            System.out.println("Сытость котика: " + satiety + "\n ");
            satiety -= 2;
            return true;
        }
    }

    public boolean go() {
        if (satiety <= 0) {
            System.out.println("Котик " + name + " хочет есть!");
            eat();
            return false;
        } else {
            System.out.println("Котик " + name + " ходит");
            System.out.println("Сытость котика: " + satiety + "\n ");
            satiety--;
            return true;
        }
    }

    public boolean eat(int satiety) {
        this.satiety += satiety;
        return true;
    }

    public boolean eat(int satiety, String nameFood) {
        eat(satiety);
        System.out.println("Котик " + name + " хочет " + nameFood + ". Прибавлено сытости: " + this.satiety + "\n");
        return true;
    }

    Scanner scanner = new Scanner(System.in);

    public void eat() {
        System.out.print("Введите Fish или Cat food: ");
        String food = scanner.nextLine();

        if (food.equals("Fish")) {
            eat(4, "Fish");
        } else if (food.equals("Cat food")) {
            eat(2, "Cat food");
        }
    }

    public int liveAnotherDay() {
        for (int i = 0; i <= 24; i++) {
            int method = getRandomMethod();

            switch (method) {
                case 1:
                    play();
                    break;
                case 2:
                    sleep();
                    break;
                case 3:
                    chaseMouse();
                    break;
                case 4:
                    sit();
                    break;
                case 5:
                    go();
                    break;
                default:
            }
        }
        return 0;
    }

    public int getRandomMethod() {
        return (int) (Math.random() * 5) + 1;
    }

}
