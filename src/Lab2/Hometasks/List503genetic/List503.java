package Lab2.Hometasks.List503genetic;

public interface List503<T> {
    int size();
    boolean isEmpty();
    boolean isItemInList(T o);
    void add(T o);
    void add(T o,int i);
    T remove(int i);
    void clear();
    T getItemByIndex(int i);
    Object[] toArray();

}
