package com.cjs.jworks.generator.generator.impl;

import com.cjs.jworks.generator.context.Context;
import com.cjs.jworks.generator.dto.base.FieldMeta;
import com.cjs.jworks.generator.dto.base.RepositoryMeta;
import com.cjs.jworks.generator.generator.base.ClassFileGenerator;
import com.cjs.jworks.generator.generator.base.RepositoryGenerator;

import java.util.HashMap;
import java.util.Map;

public class RepositoryGeneratorImpl extends ClassFileGenerator<RepositoryMeta> implements RepositoryGenerator {
    private static final String TEMPLATE_REPOSITORY = "template.repository";
    private static final String PLACEHOLDER_ENTITY_PACKAGE = "entityPackage";
    private static final String PLACEHOLDER_ENTITY_NAME = "entityName";

    public RepositoryGeneratorImpl(final Context context) {
        super(context);
    }

    @Override
    protected String getTemplateName(final RepositoryMeta repositoryMeta) {
        return getProperty(TEMPLATE_REPOSITORY);
    }

    @Override
    protected Map<String, String> getAdditionalParams(final RepositoryMeta repositoryMeta) {
        return new HashMap<String, String>() {{
            put(PLACEHOLDER_ENTITY_PACKAGE, repositoryMeta.getEntityMeta().getPackage());
            put(PLACEHOLDER_ENTITY_NAME, repositoryMeta.getEntityMeta().getName());
        }};
    }

    @Override
    protected FieldMeta[] getFieldsMeta(final RepositoryMeta repositoryMeta) {
        return null;
    }
}
