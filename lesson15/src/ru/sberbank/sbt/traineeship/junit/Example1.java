package ru.sberbank.sbt.traineeship.junit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author SBT-Rogachev-SN
 * @ created 12.05.2016
 * @ $Author$
 * @ $Revision$
 */
public class Example1 {
    @Test
    public void multiplicationOfZeroIntegersShouldReturnZero() {

        SimpleClass tester = new SimpleClass();

        // assert statements
        assertEquals("10 x 0 must be 0", 0, tester.multiply(10, 0));
        assertEquals("0 x 10 must be 0", 0, tester.multiply(0, 10));
        assertEquals("0 x 0 must be 0", 0, tester.multiply(0, 0));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testExceptionIsThrown(){
        SimpleClass tester = new SimpleClass();
        tester.multiply(1000, 5);
    }
}

