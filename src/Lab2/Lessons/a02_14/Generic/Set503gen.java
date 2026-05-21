package Lab2.Lessons.a02_14.Generic;

public interface Set503gen<T> {
    int size();
    boolean isEmpty();
    boolean isElementInSet(T o);
    void add(T o);
    void remove(T o);
    void clear();
    Object[] toArray();

}