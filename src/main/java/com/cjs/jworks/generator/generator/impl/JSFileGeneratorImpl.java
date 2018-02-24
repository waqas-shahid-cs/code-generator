package com.cjs.jworks.generator.generator.impl;

import com.cjs.jworks.generator.context.Context;
import com.cjs.jworks.generator.dto.base.FileMeta;
import com.cjs.jworks.generator.dto.base.JSFileMeta;
import com.cjs.jworks.generator.dto.impl.FileMetaImpl;
import com.cjs.jworks.generator.generator.base.CodeFileGenerator;
import com.cjs.jworks.generator.generator.base.JSFileGenerator;
import com.cjs.jworks.generator.template.base.Template;
import com.cjs.jworks.generator.util.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class JSFileGeneratorImpl<P extends JSFileMeta> extends CodeFileGenerator<P> implements JSFileGenerator<P> {

    private static final String TEMPLATE_JAVASCRIPT_IMPORT = "template.javascript.import";

    private static final String PLACEHOLDER_NAME = "name";
    private static final String PLACEHOLDER_FILE_NAME = "fileName";

    private static final String JAVASCRIPT_FILE_IMPORT = "javascript.file.import";

    private static final String EXTENSION_JS = "js";

    public JSFileGeneratorImpl(final Context context) {
        super(context);
    }

    @Override
    public File generate(final P jsFileMeta) throws Exception {
        final File file = super.generate(jsFileMeta);
        if (file != null && file.exists()) {
            addScriptToImportFile(jsFileMeta);
        }
        return file;
    }

    protected void addScriptToImportFile(final P jsFileMeta) throws Exception {
        final File importFile = FileUtils.searchFile(getContext().getProjectFolder(), getProperty(JAVASCRIPT_FILE_IMPORT));
        final Map<String, String> params = getImportParams(jsFileMeta);
        final Template scriptTemplate = getScriptTemplate(jsFileMeta);
        final String content = scriptTemplate.resolve(params);
        final FileMeta fileMeta = new FileMetaImpl(importFile.getName(), content, importFile.getAbsolutePath());
        fileMeta.setAppend(true);
        getFactory().getFileGenerator().generate(fileMeta);
    }

    protected Map<String, String> getImportParams(final P jsFileMeta) {
        return new HashMap<String, String>() {{
            put(PLACEHOLDER_FILE_NAME, getFileName(jsFileMeta));
        }};
    }

    protected Template getScriptTemplate(final P jsFileMeta) throws IOException {
        return getContext().getTemplateResolver().getTemplate(getProperty(TEMPLATE_JAVASCRIPT_IMPORT));
    }

    @Override
    protected String getFileExtension() {
        return EXTENSION_JS;
    }

    @Override
    protected Map<String, String> getParams(final P jsFileMeta) throws Exception {
        final Map<String, String> params = new HashMap<String, String>() {{
            put(PLACEHOLDER_NAME, jsFileMeta.getName());
        }};
        params.putAll(getAdditionalParams(jsFileMeta));
        return params;
    }

    protected Map<String, String> getAdditionalParams(final P jsFileMeta) throws Exception {
        return new HashMap<>(0);
    }
}
