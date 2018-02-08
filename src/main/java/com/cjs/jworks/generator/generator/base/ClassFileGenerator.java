package com.cjs.jworks.generator.generator.base;

import com.cjs.jworks.generator.context.Context;
import com.cjs.jworks.generator.dto.base.ClassMeta;
import com.cjs.jworks.generator.dto.base.FieldMeta;
import org.apache.commons.collections4.MapUtils;

import java.util.HashMap;
import java.util.Map;

public abstract class ClassFileGenerator<P extends ClassMeta> extends CodeFileGenerator<P> {
    private static final String PLACEHOLDER_CLASS_NAME = "className";
    private static final String PLACEHOLDER_PACKAGE = "package";
    private static final String PLACEHOLDER_FIELDS = "fields";
    private static final String PLACEHOLDER_GETTER_SETTERS = "getterSetters";
    private static final String DEFAULT_FILE_EXTENSION = "java";

    public ClassFileGenerator(final Context context) {
        super(context);
    }

    @Override
    protected String getFileExtension() {
        return DEFAULT_FILE_EXTENSION;
    }

    @Override
    protected Map<String, String> getParams(final P classMeta) throws Exception {
        final Map<String, String> templateParams = getDefaultParams(classMeta);
        final Map<String, String> additionalParams = getAdditionalParams(classMeta);
        if (MapUtils.isNotEmpty(additionalParams)) {
            templateParams.putAll(additionalParams);
        }
        return templateParams;
    }

    private Map<String, String> getDefaultParams(final P classMeta) throws Exception {
        final FieldMeta[] fieldsMeta = getFieldsMeta(classMeta);
        return new HashMap<String, String>() {{
            put(PLACEHOLDER_CLASS_NAME, classMeta.getName());
            put(PLACEHOLDER_PACKAGE, classMeta.getPackage());
            if (fieldsMeta != null) {
                put(PLACEHOLDER_FIELDS, getFieldsString(fieldsMeta));
                put(PLACEHOLDER_GETTER_SETTERS, getGetterSetters(fieldsMeta));
            }
        }};
    }

    private String getFieldsString(final FieldMeta[] fieldsMeta) throws Exception {
        final FieldGenerator fieldGenerator = getFactory().getFieldGenerator();
        final StringBuilder builder = new StringBuilder();
        for (final FieldMeta fieldMeta : fieldsMeta) {
            builder.append(fieldGenerator.generate(fieldMeta));
        }
        return builder.toString();
    }

    private String getGetterSetters(final FieldMeta[] fieldsMeta) throws Exception {
        final GetterGenerator getterGenerator = getFactory().getGetterGenerator();
        final SetterGenerator setterGenerator = getFactory().getSetterGenerator();
        final StringBuilder builder = new StringBuilder();
        for (final FieldMeta fieldMeta : fieldsMeta) {
            builder.append(getterGenerator.generate(fieldMeta));
            builder.append(setterGenerator.generate(fieldMeta)).append("\n");
        }
        return builder.toString();
    }

    protected abstract String getTemplateName(P classMeta);

    protected abstract Map<String, String> getAdditionalParams(P classMeta);

    protected abstract FieldMeta[] getFieldsMeta(P classMeta);
}
