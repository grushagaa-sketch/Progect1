package Lab2.Lessons.a02_14.NoGeneric;

public class TestSet {
    public static void main(String[] args) {
        Set503Impl set = new Set503Impl();
        for(int i=0; i<10; i++) {
            set.add(i);
        }
        set.remove(5);
        System.out.println(set);
        for(Object i: set.toArray()) {
            System.out.print(i+", ");
        }
    }
}
