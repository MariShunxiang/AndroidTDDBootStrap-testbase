package com.github.piasy.test.rules;

import android.support.test.InstrumentationRegistry;
import io.appflate.restmock.RESTMockServerStarter;
import io.appflate.restmock.android.AndroidAssetsFileParser;
import io.appflate.restmock.android.AndroidLogger;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Created by Piasy{github.com/Piasy} on 17/10/2016.
 */

public class RestMockRule implements TestRule {
    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                RESTMockServerStarter.startSync(
                        new AndroidAssetsFileParser(InstrumentationRegistry.getContext()),
                        new AndroidLogger());
                base.evaluate();
            }
        };
    }
}
