package ru.sberbank.sbt.traineeship.serialization;

import java.io.*;
import java.util.Date;

/**
 * Created by salexandrov on 10.04.2016.
 */
public class SerializationToFile {
    private static final String FILE_NAME = "d:\\work\\tutoring\\SBTTraineeship\\lesson4\\doc\\obj";
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = SerializationDemoUtils.createPerson();

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:\\work\\tutoring\\SBTTraineeship\\lesson4\\doc\\obj"));
        oos.writeObject(person);
        oos.close();
    }


}
