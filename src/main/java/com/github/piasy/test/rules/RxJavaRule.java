package com.github.piasy.test.rules;

import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Created by Piasy{github.com/Piasy} on 17/10/2016.
 */

public class RxJavaRule implements TestRule {
    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                setSchedulerHook();
                base.evaluate();
                resetSchedulerHook();
            }
        };
    }

    private void setSchedulerHook() {
        RxJavaPlugins.reset();
        RxJavaPlugins.onIoScheduler(Schedulers.trampoline());
        RxJavaPlugins.onComputationScheduler(Schedulers.trampoline());
        RxJavaPlugins.onNewThreadScheduler(Schedulers.trampoline());
        RxJavaPlugins.onSingleScheduler(Schedulers.trampoline());

        RxAndroidPlugins.reset();
        RxAndroidPlugins.onMainThreadScheduler(Schedulers.trampoline());
    }

    private void resetSchedulerHook() {
        RxJavaPlugins.reset();
        RxAndroidPlugins.reset();
    }
}
