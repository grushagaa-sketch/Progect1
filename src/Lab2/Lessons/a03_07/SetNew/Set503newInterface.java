package Lab2.Lessons.a03_07.SetNew;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public interface Set503newInterface<T> {
    int size();
    boolean isEmpty();
    boolean isElementInSet(T o);
    void add(T o);
    void remove(T o);
    void clear();
    Object[] toArray();

    <R> List<R> collect(Function<T,R> function);
    List<T> sort(Comparator<T> comparator);
    Set503newInterface<T> filter(Predicate<T> predicate);
    void forEach(Consumer<T> consumer);
}
