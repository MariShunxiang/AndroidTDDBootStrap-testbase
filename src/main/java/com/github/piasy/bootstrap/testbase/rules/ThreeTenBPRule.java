package com.github.piasy.bootstrap.testbase.rules;

import android.content.Context;
import com.github.piasy.bootstrap.testbase.TestUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.threeten.bp.zone.TzdbZoneRulesProvider;
import org.threeten.bp.zone.ZoneRulesException;
import org.threeten.bp.zone.ZoneRulesProvider;
import timber.log.Timber;

/**
 * Created by Piasy{github.com/Piasy} on 17/10/2016.
 */

public final class ThreeTenBPRule implements TestRule {
    private final Context mContext;

    private ThreeTenBPRule(Context context) {
        mContext = context;
    }

    public static ThreeTenBPRule junitTest() {
        return new ThreeTenBPRule(null);
    }

    public static ThreeTenBPRule androidTest(Context context) {
        return new ThreeTenBPRule(context);
    }

    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                initThreeTenBP();
                Timber.plant(new Timber.DebugTree());
                base.evaluate();
            }
        };
    }

    private void initThreeTenBP() {
        if (mContext != null) {
            init4AndroidJUnit();
        } else {
            init4JUnit();
        }
    }

    private void init4AndroidJUnit() {
        try {
            final InputStream is = mContext.getAssets().open("org/threeten/bp/TZDB.dat");
            ZoneRulesProvider.registerProvider(new TzdbZoneRulesProvider(is));
        } catch (ZoneRulesException ignored) {
        } catch (IOException e) {
            throw new IllegalStateException("TZDB.dat missing from assets.", e);
        }
    }

    private void init4JUnit() {
        try {
            InputStream is;
            File dat = new File(
                    TestUtil.projectRoot() + "testbase/src/main/assets/org/threeten/bp/TZDB.dat");
            System.out.println(dat.getAbsolutePath());
            if (dat.exists()) {
                System.out.println("got TZDB");
                is = new FileInputStream(dat);
            } else {
                System.out.println("TZDB not found! Give up...");
                throw new FileNotFoundException("TZDB.dat");
            }
            ZoneRulesProvider.registerProvider(new TzdbZoneRulesProvider(is));
        } catch (ZoneRulesException ignore) {
        } catch (IOException e) {
            throw new IllegalStateException("TZDB.dat missing from assets.", e);
        }
    }
}
