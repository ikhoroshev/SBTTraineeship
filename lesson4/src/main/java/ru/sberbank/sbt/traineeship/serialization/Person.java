package ru.sberbank.sbt.traineeship.serialization;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by salexandrov on 10.04.2016.
 */
@XmlRootElement
public class Person implements Serializable{

    private static final long serialVersionUID = -1712970844586681562L;

    public enum Gender {MALE, FEMALE}

    private String firstName;
    private String middleName;
    private String lastName;
    @XmlElement(name="birth-date")
    private Date birthDate;
    private Gender gender;

    private Address address;

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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", gender=" + gender +
                ", address=" + address +
                '}';
    }

    /*private void readObject (ObjectInputStream stream) throws IOException, ClassNotFoundException{
        stream.defaultReadObject();
        firstName = (String) stream.readObject();
    }
    private void writeObject (ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeObject(firstName);
    }*/
}
