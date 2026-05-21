package Lab2.Lessons.a03_07.SetNew;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/*
Добавить в множество Set503 функциональность:

Метод, преобразующий элементы множества типа T в список типа R: collect
Метод, возвращающий отсортированные элементы в виде списка: sort
Метод, возвращающий отфильтрованное множество (исключаем по некоторому признаку часть элементов): filter
Метод, обрабатывающий элементы множества (вывод, ...): forEach
 */

public class Set503new<T> implements Set503newInterface<T> {
    private Object[] set;
    private int size;

    public Set503new() {
        set = new Object[3];
        size = 0;
    }

    public void forEach(Consumer<T> consumer) {
        for (int i=0; i<size; i++) {
            consumer.accept((T)set[i]);
        }
    }

    public Set503newInterface<T> filter(Predicate<T> predicate) {
        Set503newInterface<T> res = new Set503new();
        for (int i = 0; i < size; i++) {
            if (predicate.test((T) set[i])) {
                res.add((T) set[i]);
            }
        }
        return res;
    }

    public List<T> sort(Comparator<T> comparator) {
        T[] list = (T[]) toArray();
        Arrays.sort(list, comparator);
        List<T> res = new ArrayList<>(List.of(list));
        return res;
    }

    @Override
    public <R> List<R> collect(Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(function.apply((T) set[i]));
        }
        return result;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) return true;
        return false;
    }

    @Override
    public boolean isElementInSet(T o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(set[i])) return true;
        }
        return false;
    }

    @Override
    public void add(T o) {
        if (isElementInSet(o)) {
            return;
        }
        if (size == set.length) {
            Object[] temp = new Object[set.length * 2];
            for (int i = 0; i < size; i++) {
                temp[i] = set[i];
            }
            set = temp;
        }
        set[size++] = o;
    }

    @Override
    public void remove(T o) {
        for (int i = 0; i < size; i++) {
            if (set[i].equals(o)) {
                if (i == size - 1) {
                    set[i] = null;
                } else {
                    for (int j = i; j < size - 1; j++) {
                        set[j] = set[j + 1];
                    }
                    set[size - 1] = null;
                }
                size--;
                return;
            }
        }
        throw new NoSuchElementException();
    }

    @Override
    public void clear() {
        set = new Object[set.length];
        size = 0;
    }

    @Override
    public Object[] toArray() {
        Object[] temp = new Object[size];
        System.arraycopy(set, 0, temp, 0, size);
        return temp;
    }

    public T[] toArray(T clazz) {
        T[] temp = (T[]) Array.newInstance(clazz.getClass(), size);
        System.arraycopy(set, 0, temp, 0, size);
        return temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < set.length; i++) {
            sb.append(set[i]).append(", ");
        }
        return sb.toString();
    }
}
