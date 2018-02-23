package com.cjs.jworks.generator;

import com.cjs.jworks.generator.command.base.CommandType;
import com.cjs.jworks.generator.context.Context;
import com.cjs.jworks.generator.context.ContextImpl;
import org.apache.commons.lang3.ArrayUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CodeGenerator {

    private static final String CODEGENERATOR_PROPERTIES = "codegenerator.properties";

    public static void main(final String[] args) throws Exception {
        final Context context = prepareConfiguration();
        if (ArrayUtils.isNotEmpty(args)) {
            final CommandType command = CommandType.findByCommand(args[0]);
            if (command != null) {
                context.getCommandFactory().getCommand(command).execute();
            }
        }
    }

    private static Context prepareConfiguration() throws IOException {
        final ContextImpl configuration = new ContextImpl();
        final Properties properties = new Properties();
        try (final InputStream inputStream = CodeGenerator.class.getClassLoader().getResourceAsStream(CODEGENERATOR_PROPERTIES)) {
            properties.load(inputStream);
        }
        properties.putAll(System.getProperties());
        configuration.setProperties(properties);
        return configuration;
    }
}
