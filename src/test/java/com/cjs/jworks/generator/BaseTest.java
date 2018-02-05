package com.cjs.jworks.generator;

import com.cjs.jworks.generator.context.Context;
import com.cjs.jworks.generator.util.TestUtil;

import java.util.Properties;

public class BaseTest {
    protected final TestUtil testUtil = new TestUtil();

    protected Context getContext() {
        return testUtil.getContext();
    }

    protected Properties getProperties() {
        return testUtil.getContext().getProperties();
    }
}
