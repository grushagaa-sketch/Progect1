package Lab2.Lessons.a02_14.NoGeneric;

public class TestSetPerson {
    public static void main(String[] args) {
        Set503 set = new Set503Impl();

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
    }
}
