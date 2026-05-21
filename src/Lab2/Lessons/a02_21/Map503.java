package Lab2.Lessons.a02_21;

import Lab2.Hometasks.List503genetic.List503;
import Lab2.Lessons.a02_14.Generic.Set503gen;

public interface Map503<K,V> {

    interface Entry<K,V> {
        K getKey();
        V getValue();
    }
    void put(K key, V value);
    Object get(K key);
    int size();
    V remove(K key);
    void clear();
    Set503gen<Entry<K,V>> entrySet();
    Set503gen<K>  keySet();
    List503<V>  valueList();
}
