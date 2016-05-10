package ru.sberbank.sbt.traineeship.rttiReflection;

import java.util.List;

import static java.lang.Class.forName;

/**
 * Created by salexandrov on 10.04.2016.
 */
public class DynamicLoading {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class arrayListClass = Class.forName("java.util.ArrayList");
        Object object = arrayListClass.newInstance();
        if (object instanceof List) {
            List list = (List) object;
            list.add("one");
            list.add("two");
            list.add("three");
            System.out.println(list.size());
        } else{
            System.out.println("It's not a list");
        }
    }
}
