package com.jworks.code.generator;

import com.jworks.code.generator.commands.base.CommandFactory;
import com.jworks.code.generator.commands.base.CommandType;
import com.jworks.code.generator.commands.impl.CommandFactoryImpl;
import com.jworks.code.generator.generators.base.GeneratorFactory;
import com.jworks.code.generator.generators.impl.GeneratorFactoryImpl;
import org.apache.commons.lang3.ArrayUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Application {

    private static final String PROPERTIES_FILE = "codegenerator.properties";

    public static void main(final String[] args) throws IOException {
        final Configuration configuration = prepareConfiguration();
        if (ArrayUtils.isNotEmpty(args)) {
            final CommandType command = CommandType.findByCommand(args[0]);
            if (command != null) {
                configuration.getCommandFactory().getCommand(command).execute();
            }
        }
    }

    private static Configuration prepareConfiguration() throws IOException {
        final ConfigurationImpl configuration = new ConfigurationImpl();
        final Properties properties = new Properties();
        try (final InputStream inputStream = Application.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            properties.load(inputStream);
        }
        configuration.setProperties(properties);
        return configuration;
    }

    private static class ConfigurationImpl implements Configuration {

        private Properties properties;

        @Override
        public CommandFactory getCommandFactory() {
            return new CommandFactoryImpl(this);
        }

        @Override
        public GeneratorFactory getGeneratorFactory() {
            return new GeneratorFactoryImpl(this);
        }

        @Override
        public Properties getProperties() {
            return properties;
        }

        public void setProperties(Properties properties) {
            this.properties = properties;
        }
    }
}
