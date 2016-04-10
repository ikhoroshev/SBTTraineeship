package ru.sberbank.sbt.traineeship.serialization;

import com.thoughtworks.xstream.XStream;

/**
 * Created by פגüרע on 10.04.2016.
 */
public class XStreamExample {
    public static void main(String[] args) {
        XStream xstream = new XStream();
        xstream.autodetectAnnotations(true);
        xstream.toXML(SerializationDemoUtils.createPerson(), System.out);
    }
}
