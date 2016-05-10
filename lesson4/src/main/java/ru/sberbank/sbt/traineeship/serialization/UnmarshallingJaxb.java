package ru.sberbank.sbt.traineeship.serialization;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by salexandrov on 10.04.2016.
 */
public class UnmarshallingJaxb {
    public static final String FILE_NAME = "d:\\work\\tutoring\\SBTTraineeship\\lesson4\\doc\\person.xml";
    public static void main(String[] args) throws JAXBException, IOException {
        JAXBContext jc = JAXBContext.newInstance(Person.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        InputStream is = new FileInputStream(FILE_NAME);

        Person person = (Person) unmarshaller.unmarshal(is);
        System.out.println(person);
        is.close();
    }
}
