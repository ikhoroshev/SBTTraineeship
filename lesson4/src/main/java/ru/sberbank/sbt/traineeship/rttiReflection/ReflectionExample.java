package ru.sberbank.sbt.traineeship.rttiReflection;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by salexandrov on 10.04.2016.
 */
public class ReflectionExample {

    public void printClassesInPackage (String packageName) {

    }

    public static void printObjectMembers (Object o) {
        Class objectClass = o.getClass();
        System.out.println ("Parent: " + objectClass.getGenericSuperclass().getTypeName());
        System.out.println ("Interfaces: ");
        for (Type type: objectClass.getGenericInterfaces()) {
            System.out.println (type.getTypeName());
        }
        System.out.println ("Fields: ");
        for (Field field: objectClass.getDeclaredFields()) {
            int modifiers = field.getModifiers();
            System.out.println (Modifier.toString(modifiers) + " " + field.getName() + " " + field.getGenericType().getTypeName());
        }
        System.out.println ("Methods: ");
        for (Method method: objectClass.getDeclaredMethods()) {
            int modifiers = method.getModifiers();
            StringBuilder sb = new StringBuilder();
            for (Class argType : method.getParameterTypes()){
                sb.append(argType.getTypeName()).append(" ");
            }
            System.out.println (Modifier.toString(modifiers) + " " + method.getGenericReturnType().getTypeName()
                    + " " + method.getName() + "( " + sb.toString() + ")");
        }

    }

    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        printObjectMembers(l);
    }
}
