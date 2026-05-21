package Lab2.Lessons.a03_07;

public class Fruit {
    private String name;
    private Integer price;

    public Fruit(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name+" , цена: "+price;
    }
}
