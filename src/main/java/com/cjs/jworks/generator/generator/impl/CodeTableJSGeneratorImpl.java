package com.cjs.jworks.generator.generator.impl;

import com.cjs.jworks.generator.context.Context;
import com.cjs.jworks.generator.dto.base.CodeTableJSMeta;
import com.cjs.jworks.generator.dto.base.CodeTableMeta;
import com.cjs.jworks.generator.generator.base.CodeFileGenerator;
import com.cjs.jworks.generator.generator.base.CodeTableJSFileGenerator;

import java.util.HashMap;
import java.util.Map;

public class CodeTableJSGeneratorImpl extends CodeFileGenerator<CodeTableJSMeta> implements CodeTableJSFileGenerator {

    private final String TEMPLATE_CODE_TABLE_TABBED_JAVASCRIPT = "code.table.javascript.tabbed";

    public static final String EXTENSION_JS = "js";

    public CodeTableJSGeneratorImpl(final Context context) {
        super(context);
    }

    @Override
    protected String getFileExtension() {
        return EXTENSION_JS;
    }

    @Override
    protected Map<String, String> getParams(final CodeTableJSMeta codeTableJSMeta) throws Exception {
        final CodeTableMeta codeTableMeta = codeTableJSMeta.getCodeTableMeta();
        final Map<String, String> params = new HashMap<String, String>() {{
        }};
        return params;
    }

    @Override
    protected String getTemplateName(final CodeTableJSMeta codeTableJSMeta) {
        if (codeTableJSMeta.isTabbed())
            return getProperty(TEMPLATE_CODE_TABLE_TABBED_JAVASCRIPT, "");
        return "";
    }
}
