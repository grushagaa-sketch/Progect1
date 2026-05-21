package Lab2.Lessons.a03_07;

import java.util.function.Consumer;

public class FruitPrinter implements Consumer<Fruit> {
    @Override
    public void accept(Fruit fruit) {
        System.out.println(fruit.getName()+": "+fruit.getPrice());
    }
}
