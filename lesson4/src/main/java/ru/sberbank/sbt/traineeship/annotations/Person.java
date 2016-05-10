package ru.sberbank.sbt.traineeship.annotations;

/**
 * Created by sbt-aleksandrov-sa on 11.04.2016.
 */
public class Person {
    @FieldValue("Ivan")
    private String firstName;
    @FieldValue("Ivanovich")
    private String middleName;
    @FieldValue("Ivanov")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
