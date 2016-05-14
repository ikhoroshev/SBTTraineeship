package ru.sberbank.sbt.traineeship.junit;

/**
 * @author SBT-Rogachev-SN
 * @ created 12.05.2016
 * @ $Author$
 * @ $Revision$
 */
public class SimpleClass {

    private int uniqueId;

    public int multiply(int arg1, int arg2) {
        validate(arg1);
        validate(arg2);
        return arg1 * arg2;
    }

    private void validate(int x){
        if (x > 999) {
            throw new IllegalArgumentException("X should be less than 1000");
        }
    }

    public int getUniqueId() {
        return uniqueId;
    }

    public void testing(int i) {
        System.out.println(i);
    }

    public void someMethod(String s) {
        System.out.println(s);
    }
}
