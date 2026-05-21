package Lab2.Lessons.a03_14.StreamAPI;

import java.util.ArrayList;
import java.util.List;

public class TestStream {
    public static void main(String[] args) {
        List<String> task1 = new ArrayList<>(List.of("Владимир", "Суздаль", "Казань", "Владивосток"));

        task1.stream().
                filter(s -> s.startsWith("Вл"))
                .map(s -> s.length())
                .mapToInt(a -> a)
                .average();

        List<Integer> task2 = new ArrayList<>(List.of(11,23,43,61,12,9));
        task2.stream()
                .sorted((o1,o2) -> o2-o1)
                .map(s -> Math.sqrt(s))
                .forEach(s -> System.out.println(s));

        List<String> task3 = new ArrayList<>(List.of("Арбуз", "Помидор"));
        task3.stream()
                .filter(s -> s.length()==5)
                .sorted((a,b) -> a.compareTo(b))
                .toList().forEach(s -> System.out.println(s));
    }
}
