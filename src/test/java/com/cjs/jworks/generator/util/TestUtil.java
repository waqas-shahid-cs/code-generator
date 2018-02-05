package com.cjs.jworks.generator.util;

import com.cjs.jworks.generator.context.Context;
import com.cjs.jworks.generator.context.ContextImpl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestUtil {
    private static final String PROPERTIES_FILE = "codegenerator.properties";
    public final Context context;

    public TestUtil() {
        final ContextImpl configuration = new ContextImpl();
        final Properties properties = new Properties();
        try (final InputStream inputStream = getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        configuration.setProperties(properties);
        context = configuration;
    }

    public Context getContext() {
        return context;
    }
}
