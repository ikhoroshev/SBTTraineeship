package ru.sberbank.sbt.traineeship.serialization;

import java.util.Date;

/**
 * Created by фвьшт on 10.04.2016.
 */
public class SerializationDemoUtils {
    public static Person createPerson() {
        Person person = new Person();
        person.setFirstName("Иванов");
        person.setMiddleName("Иван");
        person.setLastName("Иванович");
        person.setBirthDate(new Date());
        person.setGender(Person.Gender.MALE);
        Address address = new Address();
        address.setCity("Омск");
        address.setStreet("Гагарина");
        person.setAddress(address);
        return person;
    }
}
