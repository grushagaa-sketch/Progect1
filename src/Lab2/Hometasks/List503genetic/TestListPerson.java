package Lab2.Hometasks.List503genetic;

import Lab2.Lessons.a02_14.NoGeneric.Gender;

public class TestListPerson {
    public static void main(String[] args) {
        List503Impl<Person1> list = new List503Impl<Person1>();

        System.out.println(list.isEmpty());

        list.add(new Person1("1", Gender.MALE));
        list.add(new Person1("2", Gender.FEMALE));
        list.add(new Person1("3", Gender.MALE));
        list.add(new Person1("4", Gender.FEMALE));
        list.add(new Person1("5", Gender.MALE));
        list.add(new Person1("6", Gender.FEMALE));
        //list.add("7");

        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.isItemInList(new Person1("1", Gender.MALE)));//???

        Object[] persons = list.toArray();
        for (Object p: persons) {
            System.out.print(((Person1) p).getName()+" ");
        }
        System.out.println();

        list.add(new Person1("0", Gender.FEMALE), 2);
        Object[] persons0 = list.toArray();
        for (Object p: persons0) {
            System.out.print(((Person1) p).getName()+" ");
        }
        System.out.println();


        list.remove(2);
        Object[] persons1 = list.toArray();
        for (Object p: persons1) {
            System.out.print(((Person1) p).getName()+" ");
        }

    }
}
