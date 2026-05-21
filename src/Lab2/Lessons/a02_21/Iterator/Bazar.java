package Lab2.Lessons.a02_21.Iterator;

import java.util.Iterator;

public class Bazar implements Iterator<Fruit>, Iterable<Fruit>{
    private Fruit[] fruits = new Fruit[5];

    // храним текущий индекс для метода next
    private int current = 0;

    public Bazar(String[] names) {
        for (int i = 0; i < names.length; ++i) {
            fruits[i] = new Fruit(names[i]);
        }
    }

    @Override
    public Iterator<Fruit> iterator() {
        current = 0;
        return this;
    }

    @Override
    public boolean hasNext() {
        return current < fruits.length;
    }

    @Override
    public Fruit next() {
        // возвращаем текущий элемент, и заранее сдвигаемся к слудующему
        return fruits[current++];
    }

    public static void main(String[] args) {
        Bazar bazar =
                new Bazar(new String[]{"Яблоко", "Груша", "Апельсин", "Лимон", "Гранат"});

/*
        if (bazar.hasNext()) System.out.println(bazar.next());
        if (bazar.hasNext()) System.out.println(bazar.next());
        if (bazar.hasNext()) System.out.println(bazar.next());
        if (bazar.hasNext()) System.out.println(bazar.next());
        if (bazar.hasNext()) System.out.println(bazar.next());
        if (bazar.hasNext()) System.out.println(bazar.next());
*/
        // типовой способ обработки итератора
/*
        while (bazar.hasNext()) {
            System.out.println(bazar.next());
        }
*/
        for(Fruit f : bazar) {
            System.out.println(f);
        }

        for(Fruit f : bazar) {
            System.out.println(f);
        }
    }
}
