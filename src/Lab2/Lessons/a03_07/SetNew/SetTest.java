package Lab2.Lessons.a03_07.SetNew;

import java.util.Comparator;
import java.util.List;
import java.util.SimpleTimeZone;
import java.util.function.*;

public class SetTest {
    public static void main(String[] args) {
        Set503new<Integer> set = new Set503new<>();
        set.add(10);
        set.add(3);
        set.add(50);
        set.add(17);
        List<String> list = set.collect(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return String.valueOf(integer);
            }
        });
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.print(s+" ");
            }
        });
        System.out.println();


        List<Integer> list1 = set.sort(new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                return a-b;
            }
        });
        list1.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer s) {
                System.out.print(s+" ");
            }
        });
        System.out.println();


        Set503newInterface<Integer> set1 = set.filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer%2==0;
            }
        });
        for (Object i: set1.toArray()) {
            System.out.print(i+" ");
        }
        System.out.println();

        set.forEach(new Consumer<Integer>() {
            public void accept(Integer integer) {
                System.out.print(integer+" ");
            }
        });
    }
}
