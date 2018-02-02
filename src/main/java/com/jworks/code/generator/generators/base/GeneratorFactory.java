package com.jworks.code.generator.generators.base;

import com.jworks.code.generator.Configuration;

public abstract class GeneratorFactory {
    private final Configuration configuration;

    public GeneratorFactory(final Configuration configuration) {
        this.configuration = configuration;
    }

    protected Configuration getConfiguration() {
        return configuration;
    }

    public abstract EntityGenerator getEntityGenerator();

    public abstract DomainGenerator getDomainGenerator();
}
