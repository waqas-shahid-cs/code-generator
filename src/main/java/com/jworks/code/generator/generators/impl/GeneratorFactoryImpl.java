package com.jworks.code.generator.generators.impl;

import com.jworks.code.generator.Configuration;
import com.jworks.code.generator.generators.base.DomainGenerator;
import com.jworks.code.generator.generators.base.EntityGenerator;
import com.jworks.code.generator.generators.base.GeneratorFactory;

public final class GeneratorFactoryImpl extends GeneratorFactory {

    public GeneratorFactoryImpl(final Configuration configuration) {
        super(configuration);
    }

    @Override
    public EntityGenerator getEntityGenerator() {
        return new EntityGeneratorImpl(getConfiguration());
    }

    @Override
    public DomainGenerator getDomainGenerator() {
        return new DomainGeneratorImpl(getConfiguration());
    }
}
