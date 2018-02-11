package com.cjs.jworks.generator.generator.impl;

import com.cjs.jworks.generator.context.Context;
import com.cjs.jworks.generator.dto.base.CodeTableMeta;
import com.cjs.jworks.generator.generator.base.CodeFileGenerator;
import com.cjs.jworks.generator.generator.base.CodeTableSqlGenerator;

import java.util.HashMap;
import java.util.Map;

public class CodeTableSqlGeneratorImpl extends CodeFileGenerator<CodeTableMeta> implements CodeTableSqlGenerator {

    private static final String PLACEHOLDER_ENTITY_PACKAGE = "entityPackage";
    private static final String PLACEHOLDER_ENTITY_NAME = "entityName";
    private static final String PLACEHOLDER_DISPLAY_NAME = "displayName";
    private static final String PLACEHOLDER_EDITOR_TYPE = "editorType";
    private static final String PLACEHOLDER_FIELD_QUERIES = "fieldQueries";

    private static final String TEMPLATE_CODE_TABLE_META = "template.sql.codetable.meta";
    private static final String TEMPLATE_CODE_TABLE_FIELD = "template.sql.codetable.field";

    private static final String DEFAULT_EDITOR_TYPE = "code.table.default.editor.type";

    private static final String EXTENSION_SQL = "extension.sql";

    public CodeTableSqlGeneratorImpl(final Context context) {
        super(context);
    }

    @Override
    protected String getFileExtension() {
        return getProperty(EXTENSION_SQL, "");
    }

    @Override
    protected Map<String, String> getParams(final CodeTableMeta codeTableMeta) throws Exception {
        final Map<String, String> params = new HashMap<String, String>() {{
            put(PLACEHOLDER_ENTITY_PACKAGE, codeTableMeta.getPath());
            put(PLACEHOLDER_ENTITY_NAME, codeTableMeta.getName());
            put(PLACEHOLDER_DISPLAY_NAME, codeTableMeta.getName());
            put(PLACEHOLDER_EDITOR_TYPE, getProperty(DEFAULT_EDITOR_TYPE, ""));
            put(PLACEHOLDER_FIELD_QUERIES, "");
        }};
        return params;
    }

    @Override
    protected String getTemplateName(final CodeTableMeta codeFileMeta) {
        return TEMPLATE_CODE_TABLE_META;
    }
}
