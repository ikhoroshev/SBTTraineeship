package ru.sberbank.sbt.traineeship.rttiReflection;

/**
 * Created by salexandrov on 10.04.2016.
 */
public class StaticBlock {

    static {
        System.out.println ("Static block");
    }

    public StaticBlock() {
        System.out.println ("Constructor");
    }

    public static void main(String[] args) throws ClassNotFoundException {
//        Class.forName("ru.sberbank.sbt.traineeship.rttiReflection.StaticBlock");
        Class staticBlock = StaticBlock.class;
//        StaticBlock staticBlock = new StaticBlock();

    }
}
