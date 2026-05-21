package Lab2.Lessons.a02_21.Iterator;

public class TestIterebleSet {
    public static void main(String[] args) {
        Set503GenImplIter<Fruit> set = new Set503GenImplIter<>();

        set.add(new Fruit("Apple 1"));
        set.add(new Fruit("Apple 2"));
        set.add(new Fruit("Apple 3"));

        for (Fruit f : set) {
            System.out.println(f);
        }
    }
}
