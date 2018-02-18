package com.cjs.jworks.generator.generator.impl;

import com.cjs.jworks.generator.context.Context;
import com.cjs.jworks.generator.dto.base.CodeTableJSMeta;
import com.cjs.jworks.generator.generator.base.CodeTableJSFileGenerator;

import java.util.HashMap;
import java.util.Map;

public class CodeTableJSGeneratorImpl extends JSFileGeneratorImpl<CodeTableJSMeta> implements CodeTableJSFileGenerator {
    private static final String TEMPLATE_CODE_TABLE_JAVASCRIPT_DEFAULT = "code.table.javascript.default";
    private static final String TEMPLATE_CODE_TABLE_JAVASCRIPT_TABBED = "code.table.javascript.tabbed";

    private static final String PLACEHOLDER_ENTITY_NAME = "entityName";
    private static final String PLACEHOLDER_EDITOR_TYPE = "editorType";

    private static final String DEFAULT_EDITOR_TYPE = "code.table.default.editor.type";

    public CodeTableJSGeneratorImpl(final Context context) {
        super(context);
    }

    @Override
    protected Map<String, String> getAdditionalParams(final CodeTableJSMeta codeTableJSMeta) throws Exception {
        final Map<String, String> additionalParams = new HashMap<String, String>() {{
            if (codeTableJSMeta.isTabbed()) {
                put(PLACEHOLDER_ENTITY_NAME, codeTableJSMeta.getCodeTableMeta().getName());
                put(PLACEHOLDER_EDITOR_TYPE, getProperty(DEFAULT_EDITOR_TYPE));
            }
        }};
        return additionalParams;
    }

    @Override
    protected String getTemplateName(final CodeTableJSMeta codeTableJSMeta) {
        if (codeTableJSMeta.isTabbed())
            return getProperty(TEMPLATE_CODE_TABLE_JAVASCRIPT_TABBED);
        return getProperty(TEMPLATE_CODE_TABLE_JAVASCRIPT_DEFAULT);
    }
}
