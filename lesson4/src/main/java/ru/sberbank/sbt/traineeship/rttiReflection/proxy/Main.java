package ru.sberbank.sbt.traineeship.rttiReflection.proxy;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by фвьшт on 10.04.2016.
 */
public class Main {

    public static void main(String[] args) {
        List<String> listOfStrings = new ArrayList<String>();
        listOfStrings.add("one");
        listOfStrings.add("two");
        listOfStrings.add("three");

//        List<String> listProxy = new ListProxy<>(listOfStrings);
        List<String> listProxy = (List<String>) Proxy.newProxyInstance(
            listOfStrings.getClass().getClassLoader(), new Class[] {List.class}, new DynamicProxy(listOfStrings)
        );
        System.out.print("List size: " + listProxy.size());
    }
}
