package a03_21;

import java.util.Objects;

public class Person {
    private String gender;
    private String birthdate;
    private String fromcity;

    public int getGroup() {
        int birth = Integer.parseInt(birthdate.substring(0,4));
        int age = 2022-birth;
        if (age <=14) return 1;
        if (age <= 18) return 2;
        if (age <=25) return 3;
        if (age <= 35) return 4;
        if (age <= 45) return 5;
        return 6;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return gender.equals(person.gender) && birthdate.equals(person.birthdate) && fromcity.equals(person.fromcity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gender, birthdate, fromcity);
    }

    @Override
    public String toString() {
        return "Person{" +
                "gender='" + gender + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", fromcity='" + fromcity + '\'' +
                '}';
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getFromcity() {
        return fromcity;
    }

    public void setFromcity(String fromcity) {
        this.fromcity = fromcity;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
