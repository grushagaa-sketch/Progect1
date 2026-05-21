package Lab2.Lessons.a02_21.Iterator;


import Lab2.Hometasks.List503genetic.List503;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;

    public class List503GenImplIter<T> implements List503<T>, Iterable<T> {
        private int size;
        private Object[] list;
        private int current;

        public List503GenImplIter() {
            list = new Object[3];
            size = 0;
            current=0;
        }

        @Override
        public int size() {
            return this.size;
        }

        @Override
        public boolean isEmpty() {
            return size == 0 ? true : false;
        }

        @Override
        public boolean isItemInList(T o) {
            for (Object i: list) {
                if (o.equals((T)i)) return true;
            }/*
        for (int i = 0; i < size; i++) {
            if (o.equals(list[i])) return true;
        }*/
            return false;

        }

        @Override
        public void add(T o) {
            this.add(o, size);
        /*
        if (size == list.length) {
            increaseSize();
        }
        list[size++] = o;
         */
        }

        @Override
        public void add(T o, int x) {
            if (x < 0 || x > size) throw new IndexOutOfBoundsException();
            if (size == list.length) {
                increaseSize();
            }
            if (x != size) {
                for (int i = size; i > x; i--) {
                    list[i] = list[i - 1];
                }
            }
            list[x] = o;
            size++;
        }

        private void increaseSize() {
            Object[] newList = new Object[size * 2];
            for (int i = 0; i < size; i++) {
                newList[i] = list[i];
            }
            this.list = newList;
        }

        @Override
        public T remove(int x) {
            if (x < 0 || x >= size) throw new NoSuchElementException();
            Object o = list[x];
            list[x] = null;
            if (x != size - 1) {
                for (int i = x; i < size - 1; i++) {
                    list[i] = list[i + 1];
                }
                list[size - 1] = null;
            }
            size--;
            return (T) o;
        }

        @Override
        public void clear() {
            list = new Object[list.length];
            size = 0;
        }

        @Override
        public T getItemByIndex(int x) {
            return (T) list[x];
        }

        @Override
        public Object[] toArray() {
            Object[] temp = new Object[size];
            System.arraycopy(list, 0, temp, 0, size);
            return temp;
        }

        public T[] toArray(T clazz) {
            T[] temp = (T[]) Array.newInstance(clazz.getClass(), size);
            System.arraycopy(list, 0, temp, 0, size);
            return temp;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.length; i++) {
                sb.append(list[i]).append(", ");
            }
            return sb.toString();
        }


        @Override
        public Iterator<T> iterator() {
            return new Iterator<T>() {
                @Override
                public boolean hasNext() {
                    return current<size;
                }

                @Override
                public T next() {
                    return (T) list[current++];
                }
            };
        }

}
