package com.cjs.jworks.generator.generator.base;

import com.cjs.jworks.generator.context.Context;
import com.cjs.jworks.generator.template.base.TemplateResolver;

public abstract class ContextGenerator<P, R> implements Generator<P, R> {
    private final Context context;

    public ContextGenerator(final Context context) {
        this.context = context;
    }

    protected GeneratorFactory getFactory() {
        return context.getGeneratorFactory();
    }

    protected TemplateResolver getTemplateResolver() {
        return context.getTemplateResolver();
    }

    public Context getContext() {
        return context;
    }

    protected String getProperty(final String key) {
        return context.getProperties().getProperty(key, "");
    }
}
