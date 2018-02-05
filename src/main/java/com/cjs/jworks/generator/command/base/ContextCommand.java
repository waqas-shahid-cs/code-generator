package com.cjs.jworks.generator.command.base;

import com.cjs.jworks.generator.context.Context;
import com.cjs.jworks.generator.generator.base.GeneratorFactory;
import com.cjs.jworks.generator.template.base.TemplateResolver;

public abstract class ContextCommand implements Command {
    private final Context context;

    public ContextCommand(final Context context) {
        this.context = context;
    }

    protected GeneratorFactory getFactory() {
        return context.getGeneratorFactory();
    }

    protected TemplateResolver getTemplateResolver() {
        return context.getTemplateResolver();
    }

    protected String getProperty(final String key, String defaultValue) {
        return context.getProperties().getProperty(key, defaultValue);
    }
}
