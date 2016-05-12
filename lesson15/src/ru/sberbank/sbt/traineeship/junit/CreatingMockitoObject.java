package ru.sberbank.sbt.traineeship.junit;

import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * @author SBT-Rogachev-SN
 * @ created 12.05.2016
 * @ $Author$
 * @ $Revision$
 */
public class CreatingMockitoObject {
    @Test
    public void test1()  {
        //  create mock
        SimpleClass test = Mockito.mock(SimpleClass.class);

        // define return value for method getUniqueId()
        when(test.getUniqueId()).thenReturn(43);

        // use mock in test....
        assertEquals(test.getUniqueId(), 43);
    }


    // Demonstrates the return of multiple values
    @Test
    public void testMoreThanOneReturnValue()  {
        Iterator i= mock(Iterator.class);
        when(i.next()).thenReturn("Mockito").thenReturn("rocks");
        String result=i.next()+" "+i.next();
        //assert
        assertEquals("Mockito rocks", result);
    }

    // this test demonstrates how to return values based on the input
    @Test
    public void testReturnValueDependentOnMethodParameter()  {
        Comparable c= mock(Comparable.class);
        when(c.compareTo("Mockito")).thenReturn(1);
        when(c.compareTo("Eclipse")).thenReturn(2);
        //assert
        assertEquals(1,c.compareTo("Mockito"));
    }

    // this test demonstrates how to return values independent of the input value
    @Test
    public void testReturnValueInDependentOnInputValue()  {
        Comparable c= mock(Comparable.class);
        when(c.compareTo(anyInt())).thenReturn(-1);
        //assert
        assertEquals(-1 ,c.compareTo(9));
    }

    // this test demonstrates how use doThrow
    @Test(expected=IOException.class)
    public void testForIOException() throws IOException {
        // create an configure mock
        OutputStream mockStream = mock(OutputStream.class);
        doThrow(new IOException()).when(mockStream).close();

        // use mock
        OutputStreamWriter streamWriter= new OutputStreamWriter(mockStream);
        streamWriter.close();
    }

    @Test
    public void testVerify()  {
        // create and configure mock
        SimpleClass test = Mockito.mock(SimpleClass.class);
        when(test.getUniqueId()).thenReturn(43);

        // call method testing on the mock with parameter 12
        test.testing(12);
        test.getUniqueId();
        test.getUniqueId();

        // now check if method testing was called with the parameter 12
        verify(test).testing(Matchers.eq(12));

        // was the method called twice?
        verify(test, times(2)).getUniqueId();

        // other alternatives for verifiying the number of method calls for a method
        verify(test, never()).someMethod("never called");
        verify(test, atLeastOnce()).someMethod("called at least once");
        verify(test, atLeast(2)).someMethod("called at least twice");
        verify(test, times(5)).someMethod("called five times");
        verify(test, atMost(3)).someMethod("called at most 3 times");
    }

    @Test
    public void testSpy(){
        // Lets mock a LinkedList
        List list = new LinkedList();
        List spy = spy(list);

        //You have to use doReturn() for stubbing
        doReturn("foo").when(spy).get(0);

        // this would not work
        // real method is called so spy.get(0)
        // throws IndexOutOfBoundsException (list is still empty)
        when(spy.get(0)).thenReturn("foo");
    }
}
