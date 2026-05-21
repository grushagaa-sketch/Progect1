package Lab2.Lessons.a02_21;

import Lab2.Hometasks.List503genetic.List503;
import Lab2.Hometasks.List503genetic.List503Impl;
import Lab2.Lessons.a02_14.Generic.Set503gen;
import Lab2.Lessons.a02_21.Iterator.Set503GenImplIter;

import java.util.Objects;

public class Map503Impl<K,V> implements Map503<K,V>{
    private EntryImpl<K,V>[] elements;
    private int size;

    private class EntryImpl<K,V> implements Entry<K,V> {
        K key;
        V value;

        public EntryImpl(K k,V v) {
            key=k;
            value=v;
        }
        public K getKey(){
            return key;
        }
        public V getValue(){
            return value;
        }

        @Override
        public boolean equals(Object o) {

            if (this == o) return true;
            if (o==null || !o.getClass().equals(this.getClass())) return false;
            EntryImpl<?,?> e = (EntryImpl<?, ?>) o;
            return (e.getValue().equals(value) && e.getKey().equals(key));
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }

    public Map503Impl() {
        size=10;
        EntryImpl<K,V>[] elements=new EntryImpl[size];
    }

    private int contains(K k) {
        for (int i=0; i<size; i++) {
            if (elements[i].getKey().equals(k)) return i;
        }
        return -1;
    }

    @Override
    public void put(K k, V v) {
        int index=contains(k);
        if (index>=0) {
            elements[index].value=v;
            return;
        }
        if (size==elements.length) {
            increaseSize();
        }
        elements[size]=new EntryImpl(k,v);
        size++;
    }

    private void increaseSize() {
        EntryImpl<K,V>[] newElements = new EntryImpl[size * 2];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        this.elements = newElements;
    }

    @Override
    public Object get(K k) {
        for (int i = 0; i < size; i++) {
            if (elements[i].getKey().equals(k)) return elements[i];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object remove(Object key) {
        for(int i=0; i<size; i++) {
            if (elements[i].getKey().equals(key)) {
                Object res=elements[i];
                size--;
                for (int j=i; j<size;j++) {
                    elements[j]=elements[j+1];
                }
                return res;
            }
        }
        return null;
    }

    @Override
    public void clear() {
        size=10;
        EntryImpl<K,V>[] elements=new EntryImpl[size];
    }

    @Override
    public Set503gen<Entry<K,V>> entrySet() {
        Set503GenImplIter<Entry<K,V>> set = new Set503GenImplIter<>();
        for (int i=0;i<size;i++) {
            set.add(elements[i]);
        }
        return set;
    }

    @Override
    public Set503gen<K> keySet() {
        Set503GenImplIter<K> set = new Set503GenImplIter<>();

        for (int i=0;i<size;i++) {
            set.add(elements[i].getKey());
        }
        return set;
    }

    @Override
    public List503<V> valueList() {
        List503Impl<V> list = new List503Impl<>();
        for (int i=0;i<size;i++) {
            list.add(elements[i].getValue());
        }
        return list;
    }
}
