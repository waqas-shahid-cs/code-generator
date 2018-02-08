package com.cjs.jworks.generator.generator.impl;

import com.cjs.jworks.generator.context.Context;
import com.cjs.jworks.generator.dto.base.EntityMeta;
import com.cjs.jworks.generator.dto.base.FieldMeta;
import com.cjs.jworks.generator.generator.base.ClassFileGenerator;
import com.cjs.jworks.generator.generator.base.EntityGenerator;

import java.util.HashMap;
import java.util.Map;

public class EntityGeneratorImpl extends ClassFileGenerator<EntityMeta> implements EntityGenerator {

    private static final String PLACEHOLDER_TABLE_NAME = "tableName";
    private static final String TEMPLATE_ENTITY = "template.entity";
    private static final String TEMPLATE_ENTITY_CODE_TABLE = "template.entity.codetable";
    private static final String TEMPLATE_ENTITY_SORTED_CODE_TABLE = "template.entity.codetable.sorted";

    public EntityGeneratorImpl(final Context context) {
        super(context);
    }

    @Override
    protected String getTemplateName(final EntityMeta entityMeta) {
        if (entityMeta.isSortedCodeTable()) {
            return getProperty(TEMPLATE_ENTITY_SORTED_CODE_TABLE, "");
        } else if (entityMeta.isCodeTable()) {
            return getProperty(TEMPLATE_ENTITY_CODE_TABLE, "");
        }
        return getProperty(TEMPLATE_ENTITY, "");
    }

    @Override
    protected Map<String, String> getAdditionalParams(final EntityMeta entityMeta) {
        return new HashMap<String, String>() {{
            put(PLACEHOLDER_TABLE_NAME, entityMeta.getTable());
        }};
    }

    @Override
    protected FieldMeta[] getFieldsMeta(final EntityMeta entityMeta) {
        return entityMeta.getFieldsMeta();
    }
}
