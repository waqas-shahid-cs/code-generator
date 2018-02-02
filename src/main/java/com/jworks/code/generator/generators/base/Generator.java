package com.jworks.code.generator.generators.base;

import com.jworks.code.generator.Configuration;

public abstract class Generator<P, R> {
    private final Configuration configuration;

    public Generator(final Configuration configuration) {
        this.configuration = configuration;
    }

    protected GeneratorFactory getFactory() {
        return configuration.getGeneratorFactory();
    }

    public abstract R generate(P args);
}
