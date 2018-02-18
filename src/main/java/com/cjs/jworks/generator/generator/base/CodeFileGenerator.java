package com.cjs.jworks.generator.generator.base;

import com.cjs.jworks.generator.context.Context;
import com.cjs.jworks.generator.dto.base.CodeFileMeta;
import com.cjs.jworks.generator.dto.base.FileMeta;
import com.cjs.jworks.generator.dto.impl.FileMetaImpl;
import com.cjs.jworks.generator.util.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public abstract class CodeFileGenerator<P extends CodeFileMeta> extends ContextGenerator<P, File> {
    public CodeFileGenerator(final Context context) {
        super(context);
    }

    @Override
    public File generate(final P codeFileMeta) throws Exception {
        if (codeFileMeta != null) {
            final Map<String, String> templateParams = getParams(codeFileMeta);
            final String fileName = getFileName(codeFileMeta);
            final String filePath = getFilePath(codeFileMeta);
            final String fileContent = getFileContent(codeFileMeta, templateParams);
            final FileMeta fileMeta = getFileMeta(fileName, filePath, fileContent);
            return createFile(fileMeta);
        }
        return null;
    }

    protected File createFile(final FileMeta fileMeta) throws Exception {
        return getFactory().getFileGenerator().generate(fileMeta);
    }

    protected FileMeta getFileMeta(final String fileName, final String filePath, final String fileContent) {
        return new FileMetaImpl(fileName, fileContent, filePath);
    }

    protected String getFileContent(final P codeFileMeta, final Map<String, String> templateParams) throws IOException {
        return getTemplateResolver().resolveTemplate(getTemplateName(codeFileMeta), templateParams);
    }

    protected String getFileName(final P codeFileMeta) {
        return codeFileMeta.getName() + "." + getFileExtension();
    }

    protected abstract String getFileExtension();

    protected String getFilePath(final P codeFileMeta) {
        final String folder = FileUtils.searchDirectory(codeFileMeta.getPath());
        if (folder != null) return folder;
        return codeFileMeta.getPath();
    }

    protected abstract Map<String, String> getParams(final P codeFileMeta) throws Exception;

    protected abstract String getTemplateName(P codeFileMeta);
}
