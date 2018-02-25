package com.cjs.jworks.generator.generator.impl;

import com.cjs.jworks.generator.context.Context;
import com.cjs.jworks.generator.dto.base.CodeTableMeta;
import com.cjs.jworks.generator.dto.base.FieldMeta;
import com.cjs.jworks.generator.dto.impl.FieldMetaImpl;
import com.cjs.jworks.generator.generator.base.EntityGenerator;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;

public class CodeTableEntityGeneratorImpl extends EntityGeneratorImpl<CodeTableMeta> implements EntityGenerator<CodeTableMeta> {
    private static final String TEMPLATE_ENTITY_CODE_TABLE = "template.entity.codetable";
    private static final String TEMPLATE_ENTITY_SORTED_CODE_TABLE = "template.entity.codetable.sorted";

    private static final String PLACEHOLDER_PRIMARY_FIELD_TYPE = "primaryFieldType";
    private static final String PLACEHOLDER_PRIMARY_FIELD = "primaryField";

    private final Collection<FieldMeta> codeTableFields = new LinkedHashSet<FieldMeta>(2) {
        {
            add(new FieldMetaImpl("clientCd", String.class.getSimpleName(), "CLIENT_CD"));
            add(new FieldMetaImpl("descr", String.class.getSimpleName(), "DESCR"));
            add(new FieldMetaImpl("sortOrder", Integer.class.getSimpleName(), "SORT_ORDER"));
        }
    };

    public CodeTableEntityGeneratorImpl(final Context context) {
        super(context);
    }

    @Override
    protected Map<String, String> getAdditionalParams(final CodeTableMeta codeTableMeta) {
        final Map<String, String> additionalParams = super.getAdditionalParams(codeTableMeta);
        final FieldMeta primaryField = codeTableMeta.getTable().getPrimaryField();
        if (primaryField != null) {
            additionalParams.put(PLACEHOLDER_PRIMARY_FIELD_TYPE, primaryField.getType());
            additionalParams.put(PLACEHOLDER_PRIMARY_FIELD, primaryField.getName());
        }
        return additionalParams;
    }

    @Override
    protected String getTemplateName(final CodeTableMeta codeTableMeta) {
        if (codeTableMeta.isSorted()) {
            return getProperty(TEMPLATE_ENTITY_SORTED_CODE_TABLE);
        }
        return getProperty(TEMPLATE_ENTITY_CODE_TABLE);
    }

    @Override
    protected Collection<FieldMeta> getFieldsMeta(final CodeTableMeta codeTableMeta) {
        final Collection<FieldMeta> fields = super.getFieldsMeta(codeTableMeta);
        fields.addAll(codeTableFields);
        return fields;
    }
}