package com.cjs.jworks.generator.generator.impl;

import com.cjs.jworks.generator.context.Context;
import com.cjs.jworks.generator.dto.base.ClassMeta;
import com.cjs.jworks.generator.dto.base.FieldMeta;
import com.cjs.jworks.generator.generator.base.ClassFileGenerator;

import java.util.Collection;
import java.util.Map;

public class DefaultCodeFileGenerator extends ClassFileGenerator<ClassMeta> {

    private static final String DEFAULT_FILE_EXTENSION = "java";

    private final String templateName;
    private final Map<String, String> additionalParams;
    private final Collection<FieldMeta> fieldsMeta;
    private String fileExtension = DEFAULT_FILE_EXTENSION;

    public DefaultCodeFileGenerator(final Context context, final String templateName, final Map<String, String> additionalParams, final Collection<FieldMeta> fieldsMeta) {
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
    protected String getTemplateName(final ClassMeta codeFileMeta) {
        return templateName;
    }

    @Override
    protected Map<String, String> getAdditionalParams(final ClassMeta codeFileMeta) {
        return additionalParams;
    }

    @Override
    protected Collection<FieldMeta> getFieldsMeta(final ClassMeta codeFileMeta) {
        return fieldsMeta;
    }
}
