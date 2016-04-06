package ru.sberbank.sbt.traineeship.lesson1;

import java.util.ArrayList;
import  java.util.List;
/**
 * Created by igor on 31.03.16.
 * @author Igor Khoroshev
 */
public class HelloWorld {
    private String msg = "Hello, world!";
    private  HelloWorldListener listener = new HelloWorldListener() {
        @Override
        public void onChange(HelloWorld helloWorld) {
            System.out.println("HelloWorld has been changed new value of msg = " + helloWorld.getMsg());
        }
    };
    static {
        System.out.println("Hello from static block");
    };

    {
        System.out.println("Hello from non static block");
    };

    private HelloWorld() {
        System.out.println("Hello from constructor");
    }

    @Override
    public String toString() {
        return "HelloWorld{" +
                "msg='" + msg + '\'' +
                '}';
    }

    public static void main(String[] args) {
        System.out.println("Hello from main()");
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.say();
        System.out.println( helloWorld);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
        listener.onChange(this);
    }

    private void say() {
        System.out.println(msg);
    }
}
