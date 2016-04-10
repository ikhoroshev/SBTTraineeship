package ru.sberbank.sbt.traineeship.serialization;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

/**
 * Created by salexandrov on 10.04.2016.
 */
public class JAXBExample {
    public static void main(String[] args) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(Person.class);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "windows-1251");
        /*JAXBElement<Person> jaxbElement = new JAXBElement<Person>(
                new QName("person"),
                Person.class, SerializationDemoUtils.createPerson()
        );*/
//        marshaller.marshal(jaxbElement, System.out);
        marshaller.marshal(SerializationDemoUtils.createPerson(), System.out);
    }
}
