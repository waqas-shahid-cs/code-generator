package com.jworks.code.generator;

import com.jworks.code.generator.commands.base.CommandFactory;
import com.jworks.code.generator.generators.base.GeneratorFactory;

import java.util.Properties;

public interface Configuration {
    CommandFactory getCommandFactory();

    GeneratorFactory getGeneratorFactory();

    Properties getProperties();
}
