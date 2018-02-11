package com.cjs.jworks.generator.generator.impl;

import com.cjs.jworks.generator.context.Context;
import com.cjs.jworks.generator.dto.base.CodeTableMeta;
import com.cjs.jworks.generator.generator.base.EntityGenerator;

public class CodeTableEntityGeneratorImpl extends EntityGeneratorImpl<CodeTableMeta> implements EntityGenerator<CodeTableMeta> {
    private static final String TEMPLATE_ENTITY_CODE_TABLE = "template.entity.codetable";
    private static final String TEMPLATE_ENTITY_SORTED_CODE_TABLE = "template.entity.codetable.sorted";

    public CodeTableEntityGeneratorImpl(final Context context) {
        super(context);
    }

    @Override
    protected String getTemplateName(final CodeTableMeta codeTableMeta) {
        if (codeTableMeta.isSorted()) {
            return getProperty(TEMPLATE_ENTITY_SORTED_CODE_TABLE, "");
        }
        return getProperty(TEMPLATE_ENTITY_CODE_TABLE, "");
    }
}