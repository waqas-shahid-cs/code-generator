package com.cjs.jworks.generator.generator.impl;

import com.cjs.jworks.generator.context.Context;
import com.cjs.jworks.generator.dto.base.ClassMeta;
import com.cjs.jworks.generator.dto.base.FieldMeta;
import com.cjs.jworks.generator.generator.base.CodeFileGenerator;

import java.util.Map;

public class DefaultCodeFileGenerator extends CodeFileGenerator<ClassMeta> {

    private static final String DEFAULT_FILE_EXTENSION = "java";

    private final String templateName;
    private final Map<String, String> additionalParams;
    private final FieldMeta[] fieldsMeta;
    private String fileExtension = DEFAULT_FILE_EXTENSION;

    public DefaultCodeFileGenerator(final Context context, final String templateName, final Map<String, String> additionalParams, final FieldMeta[] fieldsMeta) {
        super(context);
        this.templateName = templateName;
        this.additionalParams = additionalParams;
        this.fieldsMeta = fieldsMeta;
    }

    protected void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    @Override
    protected String getFileExtension() {
        return fileExtension;
    }

    @Override
    protected String getTemplateName(final ClassMeta classMeta) {
        return templateName;
    }

    @Override
    protected Map<String, String> getAdditionalParams(final ClassMeta classMeta) {
        return additionalParams;
    }

    @Override
    protected FieldMeta[] getFieldsMeta(final ClassMeta classMeta) {
        return fieldsMeta;
    }
}
