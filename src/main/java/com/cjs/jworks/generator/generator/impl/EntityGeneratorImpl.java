package com.cjs.jworks.generator.generator.impl;

import com.cjs.jworks.generator.context.Context;
import com.cjs.jworks.generator.dto.base.EntityMeta;
import com.cjs.jworks.generator.dto.base.FieldMeta;
import com.cjs.jworks.generator.generator.base.ClassFileGenerator;
import com.cjs.jworks.generator.generator.base.EntityGenerator;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EntityGeneratorImpl<P extends EntityMeta> extends ClassFileGenerator<P> implements EntityGenerator<P> {

    private static final String PLACEHOLDER_TABLE_NAME = "tableName";
    private static final String TEMPLATE_ENTITY = "template.entity";

    public EntityGeneratorImpl(final Context context) {
        super(context);
    }

    @Override
    protected String getTemplateName(final P entityMeta) {
        return getProperty(TEMPLATE_ENTITY);
    }

    @Override
    protected Map<String, String> getAdditionalParams(final P entityMeta) {
        return new HashMap<String, String>() {{
            put(PLACEHOLDER_TABLE_NAME, entityMeta.getTable().getName());
        }};
    }

    @Override
    protected Collection<FieldMeta> getFieldsMeta(final P entityMeta) {
        return entityMeta.getTable().getFields();
    }
}
