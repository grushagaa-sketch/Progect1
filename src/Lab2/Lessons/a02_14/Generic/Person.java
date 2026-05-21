package Lab2.Lessons.a02_14.Generic;

import Lab2.Lessons.a02_14.NoGeneric.Gender;

import java.util.Objects;

public class Person {
    private String name;
    private Gender gender;

    public Person(){
    }

    public Person(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "P[" + name + ", " + gender + "]";
    }

    public Gender getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this==o) return true;
        if (o==null || !o.getClass().equals(Lab2.Lessons.a02_14.NoGeneric.Person.class)) {
            return false;
        }
        Person p = (Person)o;

        return name.equals(p.name) && gender == p.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender);
    }
}
