package ru.sberbank.sbt.traineeship.annotations;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by sbt-aleksandrov-sa on 11.04.2016.
 */
public class AnnotationExample {

    private static final void applyFieldValueAnnotation (Object obj) throws IllegalAccessException {
        Class cl = obj.getClass();
        if (cl.isAnnotationPresent(FieldValue.class)){
            Field[] fields = cl.getFields();
            for(Field field: fields){
                if (field.isAnnotationPresent(FieldValue.class)) {
                    if (field.getType().getClass().equals(String.class)) {
                        field.set(obj, field.getAnnotation(FieldValue.class).value());
                    } else {
                        throw new IllegalArgumentException("Field type should be String");
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IllegalAccessException {
        Person person = new Person();
        applyFieldValueAnnotation(person);
    }
}
