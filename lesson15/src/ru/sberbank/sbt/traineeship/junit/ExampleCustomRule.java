package ru.sberbank.sbt.traineeship.junit;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * @author SBT-Rogachev-SN
 * @ created 12.05.2016
 * @ $Author$
 * @ $Revision$
 */
public class ExampleCustomRule implements TestRule{

    private Statement base;
    private Description description;

    /**
     * Modifies the method-running {@link org.junit.runners.model.Statement} to implement this
     * test-running rule.
     *
     * @param base        The {@link org.junit.runners.model.Statement} to be modified
     * @param description A {@link org.junit.runner.Description} of the test implemented in {@code base}
     * @return a new statement, which may be the same as {@code base},
     *         a wrapper around {@code base}, or a completely new Statement.
     */
    @Override
    public Statement apply(Statement base, Description description) {
        this.base = base;
        this.description = description;
        return new MyStatement(base);
    }

    public class MyStatement extends Statement {
        private final Statement base;

        public MyStatement(Statement base) {
            this.base = base;
        }

        @Override
        public void evaluate() throws Throwable {
            System.out.println(description.getMethodName() + "Started");
            try {
                base.evaluate();
            } finally {
                System.out.println(description.getMethodName() + "Finished");
            }
        }
    }
}
