package ru.sberbank.sbt.traineeship.junit;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.core.StringStartsWith.startsWith;

/**
 * @author SBT-Rogachev-SN
 * @ created 12.05.2016
 * @ $Author$
 * @ $Revision$
 */
public class ExampleJUnitRules {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Rule
    public TestName name = new TestName();

    @Rule
    public TestRule globalTimeout = new Timeout(20, TimeUnit.MILLISECONDS);

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    public static String log;

    @Test
    public void testUsingTempFolder() throws IOException {
        File createdFile = folder.newFile("myfile.txt");
        File createdFolder = folder.newFolder("subfolder");
        // ...
    }

    @Test
    public void example() {
        collector.addError(new Throwable("first thing went wrong"));
        collector.addError(new Throwable("second thing went wrong"));
    }

    @Test
    public void testA() {
        assertEquals("testA", name.getMethodName());
    }

    @Test
    public void testB() {
        assertEquals("testB", name.getMethodName());
    }

    @Test
    public void testInfiniteLoop1() {
        log += "ran1";
        for(;;) {}
    }

    @Test
    public void testInfiniteLoop2() {
        log += "ran2";
        for(;;) {}
    }

    @Test
    public void throwsNothing() {

    }

    @Test
    public void throwsNullPointerException() {
        thrown.expect(NullPointerException.class);
        throw new NullPointerException();
    }

    @Test
    public void throwsNullPointerExceptionWithMessage() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("happened?");
        thrown.expectMessage(startsWith("What"));
        throw new NullPointerException("What happened?");
    }
}
