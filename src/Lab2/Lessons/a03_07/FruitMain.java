package Lab2.Lessons.a03_07;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class FruitMain {
    public static void main(String[] args) {
        List<Fruit> fruits = new ArrayList<>();
        fruits.addAll(List.of(new Fruit("Яблоко", 120),
                new Fruit("Банан", 160),
                new Fruit("Апельсин", 140),
                new Fruit("Груша", 180),
                new Fruit("Виноград", 140)));
        //fruits.sort(new FruitComparator());
        //fruits.forEach(new FruitPrinter());


        //СОЗДАЕМ АНОНИМНЫЙ ЭКЗЕМПЛЯР АНОНИМНОГО КЛАССА РЕАЛЕЗУЮЩЕГО ИНТЕРФЕЙС
        fruits.sort(new Comparator<Fruit>(){
            public int compare(Fruit a, Fruit b) {
                return a.getPrice()-b.getPrice();
            }
        });

        fruits.forEach(new Consumer<Fruit>(){
            public void accept(Fruit fruit) {
                System.out.println(fruit.getName()+": "+fruit.getPrice());
            }
        });

    }
}
