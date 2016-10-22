package com.github.piasy.test.rules;

import android.support.multidex.MultiDex;
import android.support.test.InstrumentationRegistry;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Created by Piasy{github.com/Piasy} on 17/10/2016.
 */

public class MultiDexRule implements TestRule {
    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                MultiDex.install(InstrumentationRegistry.getTargetContext());
                base.evaluate();
            }
        };
    }
}
