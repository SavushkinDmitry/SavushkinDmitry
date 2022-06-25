package enums;

public enum PriceCategory {
    дороже("Дороже", 1);

    String name;
    int id;

    PriceCategory(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
