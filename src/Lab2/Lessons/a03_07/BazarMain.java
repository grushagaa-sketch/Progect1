package Lab2.Lessons.a03_07;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class BazarMain {
    public static void main(String[] args) {
        Bazar bazar =new Bazar();
        List<Fruit> fruits = bazar.generateProductions(new FruitGenerator(), 10);

        fruits.forEach(new Consumer<Fruit>() {
            @Override
            public void accept(Fruit fruit) {
                System.out.println(fruit.getName() +": " +fruit.getPrice());
            }
        });


    }
    static class FruitGenerator implements Supplier<Fruit>{

        private Map<String, List<String>> names = new HashMap<>();

        public FruitGenerator() {
            names.put("Яблоко", List.of("Садовые", "Голд", "Грени", "Гала"));
            names.put("Груша", List.of("Конференция", "Бергамот", "Дюшес", "Чудесница"));
            names.put("Мандарины", List.of("Абхазия", "Марокко", "Япония"));
        }

        public Fruit get() {
            Random random = new Random();
            int index = random.nextInt(names.size());//индекс случайное имя фрукта
            String name = (String) names.keySet().toArray()[index];
            List<String> sorts = names.get(name);
            int indexSort = random.nextInt(sorts.size());//случайный индекс названия сорта
            //names.get(name) - извлекаем значение из map по ключу name, get(indexSort) - достаем случайный сорт
            String sort = sorts.get(indexSort);

            int price = random.nextInt(500);

            return new Fruit(name + " - "+ sort, price);
        }
    }
}
