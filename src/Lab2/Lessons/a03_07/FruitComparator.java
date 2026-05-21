package Lab2.Lessons.a03_07;

import java.util.Comparator;

public class FruitComparator implements Comparator<Fruit> {
    @Override
    public int compare(Fruit a, Fruit b) {
        return a.getPrice()- b.getPrice();
    }
}
