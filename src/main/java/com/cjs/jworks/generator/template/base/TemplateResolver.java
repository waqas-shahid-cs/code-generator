package com.cjs.jworks.generator.template.base;

import com.cjs.jworks.generator.context.Context;

import java.io.IOException;
import java.util.Map;

public abstract class TemplateResolver {
    private final Context context;

    public TemplateResolver(final Context context) {
        this.context = context;
    }

    protected Context getContext() {
        return context;
    }

    public abstract String resolveTemplate(String templateName, Map<String, String> params) throws IOException;

    public abstract String resolve(String content, Map<String, String> params);

    public abstract Template getTemplate(String templateName) throws IOException;
}
