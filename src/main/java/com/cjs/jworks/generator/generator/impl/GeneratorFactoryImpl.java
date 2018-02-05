package com.cjs.jworks.generator.generator.impl;

import com.cjs.jworks.generator.context.Context;
import com.cjs.jworks.generator.generator.base.*;

public final class GeneratorFactoryImpl extends GeneratorFactory {

    public GeneratorFactoryImpl(final Context context) {
        super(context);
    }

    @Override
    public EntityGenerator getEntityGenerator() {
        return new EntityGeneratorImpl(getContext());
    }

    @Override
    public DomainGenerator getDomainGenerator() {
        return new DomainGeneratorImpl(getContext());
    }

    @Override
    public FileGenerator getFileGenerator() {
        return new FileGeneratorImpl();
    }

    @Override
    public FieldGenerator getFieldGenerator() {
        return new FieldGeneratorImpl(getContext());
    }

    @Override
    public GetterGenerator getGetterGenerator() {
        return new GetterGeneratorImpl(getContext());
    }

    @Override
    public SetterGenerator getSetterGenerator() {
        return new SetterGeneratorImpl(getContext());
    }

    @Override
    public RepositoryGenerator getRepositoryGenerator() {
        return new RepositoryGeneratorImpl(getContext());
    }

    @Override
    public ServiceGenerator getServiceGenerator() {
        return new ServiceGeneratorImpl(getContext());
    }
}
