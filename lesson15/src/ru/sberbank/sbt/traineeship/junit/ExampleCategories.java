package ru.sberbank.sbt.traineeship.junit;

import org.junit.Test;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static junit.framework.Assert.fail;

/**
 * @author SBT-Rogachev-SN
 * @ created 12.05.2016
 * @ $Author$
 * @ $Revision$
 */
public class ExampleCategories {
    public interface FastTests { /* category marker */
    }

    public interface SlowTests { /* category marker */
    }

    public class A {
        @Test
        public void a() {
            fail();
        }

        @Category(SlowTests.class)
        @Test
        public void b() {
        }
    }

    @Category({ SlowTests.class, FastTests.class })
    public class B {
        @Test
        public void c() {
        }
    }

    @RunWith(Categories.class)
    @Categories.IncludeCategory(SlowTests.class)
    @Suite.SuiteClasses({ A.class, B.class })
// Note that Categories is a kind of Suite
    public class SlowTestSuite {
        // Will run A.b and B.c, but not A.a
    }

    @RunWith(Categories.class)
    @Categories.IncludeCategory(SlowTests.class)
    @Categories.ExcludeCategory(FastTests.class)
    @Suite.SuiteClasses({ A.class, B.class })
// Note that Categories is a kind of Suite
    public class OnlySlowTestSuite {
        // Will run A.b, but not A.a or B.c
    }
}
