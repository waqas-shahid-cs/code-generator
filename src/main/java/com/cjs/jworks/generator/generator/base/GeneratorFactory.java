package com.cjs.jworks.generator.generator.base;

import com.cjs.jworks.generator.context.Context;

public abstract class GeneratorFactory {
    private final Context context;

    public GeneratorFactory(final Context context) {
        this.context = context;
    }

    protected Context getContext() {
        return context;
    }

    public abstract EntityGenerator getEntityGenerator();

    public abstract DomainGenerator getDomainGenerator();

    public abstract FileGenerator getFileGenerator();

    public abstract FieldGenerator getFieldGenerator();

    public abstract GetterGenerator getGetterGenerator();

    public abstract SetterGenerator getSetterGenerator();

    public abstract RepositoryGenerator getRepositoryGenerator();

    public abstract ServiceGenerator getServiceGenerator();

}
