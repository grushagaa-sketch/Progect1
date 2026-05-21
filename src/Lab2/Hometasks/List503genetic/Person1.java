package Lab2.Hometasks.List503genetic;

import Lab2.Lessons.a02_14.NoGeneric.Gender;

import java.util.Objects;

public class Person1 {
    private String name;
    private Gender gender;

    public Person1(){
    }

    public Person1(String name, Gender gender) {
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
        Person1 p = (Person1)o;

        return name.equals(p.name) && gender == p.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender);
    }
}

