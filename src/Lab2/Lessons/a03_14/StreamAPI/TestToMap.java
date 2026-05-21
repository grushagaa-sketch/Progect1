package Lab2.Lessons.a03_14.StreamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestToMap {
    static class Fruit {
        String name;
        Integer price;

        public Fruit(String name, Integer price) {
            this.name = name;
            this.price = price;
        }
    }

    public static void main(String[] args) {
        List<Fruit> fruits =
                new ArrayList<>(List.of(new Fruit("Яблоко", 100),
                        new Fruit("Банан", 40),
                        new Fruit("Груша", 180)));

        Map<String, Integer> res = fruits.stream()
                .collect(Collectors.toMap(f -> f.name, f -> f.price, (v1,v2) -> (v1+v2)/2));
        res.entrySet().forEach(e ->System.out.println(e.getKey() + ": " + e.getValue()));
    }
}
