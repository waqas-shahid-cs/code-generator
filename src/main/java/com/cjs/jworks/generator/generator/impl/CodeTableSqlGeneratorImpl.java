package com.cjs.jworks.generator.generator.impl;

import com.cjs.jworks.generator.context.Context;
import com.cjs.jworks.generator.dto.base.CodeTableMeta;
import com.cjs.jworks.generator.dto.base.CodeTableSqlMeta;
import com.cjs.jworks.generator.dto.base.FieldMeta;
import com.cjs.jworks.generator.generator.base.CodeFileGenerator;
import com.cjs.jworks.generator.generator.base.CodeTableSqlGenerator;
import com.cjs.jworks.generator.template.base.Template;
import org.apache.commons.lang.WordUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CodeTableSqlGeneratorImpl extends CodeFileGenerator<CodeTableSqlMeta> implements CodeTableSqlGenerator {

    private static final String PLACEHOLDER_ENTITY_PACKAGE = "entityPackage";
    private static final String PLACEHOLDER_ENTITY_NAME = "entityName";
    private static final String PLACEHOLDER_DISPLAY_NAME = "displayName";
    private static final String PLACEHOLDER_EDITOR_TYPE = "editorType";
    private static final String PLACEHOLDER_FIELD_QUERIES = "fieldQueries";
    private static final String PLACEHOLDER_FIELD_NAME = "fieldName";

    private static final String TEMPLATE_CODE_TABLE_META = "template.sql.codetable.meta";
    private static final String TEMPLATE_CODE_TABLE_FIELD = "template.sql.codetable.field";

    private static final String DEFAULT_EDITOR_TYPE = "code.table.default.editor.type";

    private static final String EXTENSION_SQL = "extension.sql";
    private static final String PLACEHOLDER_INDEX = "index";
    private static final String PLACEHOLDER_SORT_ORDER = "sortOrder";

    public CodeTableSqlGeneratorImpl(final Context context) {
        super(context);
    }

    @Override
    protected String getFileExtension() {
        return getProperty(EXTENSION_SQL, "");
    }

    @Override
    protected Map<String, String> getParams(final CodeTableSqlMeta codeTableSqlMeta) throws Exception {
        final CodeTableMeta codeTableMeta = codeTableSqlMeta.getCodeTableMeta();
        final Map<String, String> params = new HashMap<String, String>() {{
            put(PLACEHOLDER_ENTITY_PACKAGE, codeTableMeta.getPackage());
            put(PLACEHOLDER_ENTITY_NAME, codeTableMeta.getName());
            put(PLACEHOLDER_DISPLAY_NAME, codeTableMeta.getName());
            put(PLACEHOLDER_EDITOR_TYPE, getProperty(DEFAULT_EDITOR_TYPE, ""));
            put(PLACEHOLDER_FIELD_QUERIES, getFieldQueries(codeTableMeta.getFieldsMeta()));
        }};
        return params;
    }

    protected String getFieldQueries(final FieldMeta[] fieldMetas) throws IOException {
        final Template template = getTemplateResolver().getTemplate(getProperty(TEMPLATE_CODE_TABLE_FIELD, ""));
        final StringBuilder builder = new StringBuilder();
        if (template != null) {
            for (int i = 0; i < fieldMetas.length; i++) {
                final FieldMeta fieldMeta = fieldMetas[i];
                final int idx = i, sortOrder = i - 1;
                builder.append(template.resolve(new HashMap<String, String>() {{
                    put(PLACEHOLDER_FIELD_NAME, fieldMeta.getName());
                    put(PLACEHOLDER_DISPLAY_NAME, WordUtils.capitalize(fieldMeta.getDbColumn().toLowerCase().replace("_", " "), new char[]{' '}));
                    put(PLACEHOLDER_INDEX, idx + "");
                    put(PLACEHOLDER_SORT_ORDER, sortOrder + "");
                }}));
            }
        }
        return builder.toString();
    }

    @Override
    protected String getTemplateName(final CodeTableSqlMeta codeTableSqlMeta) {
        return getProperty(TEMPLATE_CODE_TABLE_META, "");
    }
}
