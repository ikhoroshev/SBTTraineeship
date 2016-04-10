package ru.sberbank.sbt.traineeship.serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by salexandrov on 10.04.2016.
 */
public class DeserializationFromFile {
    private static final String FILE_NAME = "d:\\work\\tutoring\\SBTTraineeship\\lesson4\\doc\\obj";
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME));
        Person person = (Person) ois.readObject();
        System.out.println(person);
        ois.close();
    }
}
