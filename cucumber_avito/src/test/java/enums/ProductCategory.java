package enums;

public enum ProductCategory {
    оргтехника("Оргтехника и расходники", 1);

    String name;
    int id;

    ProductCategory(String name, int id) {
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
