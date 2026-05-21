package Lab2.Lessons.a02_14.Generic;

import Lab2.Lessons.a02_14.NoGeneric.Gender;
import Lab2.Lessons.a02_14.NoGeneric.Person;

public class TestSetPersonGen {
    public static void main(String[] args) {
        Set503genimpl<Person> set = new Set503genimpl<Person>();

        set.add(new Person("I", Gender.MALE));
        set.add(new Person("II", Gender.FEMALE));
        set.add(new Person("III", Gender.MALE));
        //set.add("VI");
        set.add(new Person("IV", Gender.FEMALE));
        set.add(new Person("V", Gender.MALE));

        System.out.println(set);

        System.out.println(set.isElementInSet(new Person("III", Gender.MALE)));

        Object[] persons = set.toArray();
        for (Object p: persons) {
            System.out.println(((Person) p).getGender());
        }

        Person[] persons2=set.toArray(new Person());//почему тут используется класс из другой папки??
        for (Person p:persons2) {
            System.out.println(p.getGender());
        }
    }
}
