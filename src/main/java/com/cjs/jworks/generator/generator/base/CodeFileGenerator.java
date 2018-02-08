package com.cjs.jworks.generator.generator.base;

import com.cjs.jworks.generator.context.Context;
import com.cjs.jworks.generator.dto.base.ClassMeta;
import com.cjs.jworks.generator.dto.base.FieldMeta;
import com.cjs.jworks.generator.dto.base.FileMeta;
import com.cjs.jworks.generator.dto.impl.FileMetaImpl;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.NotFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class CodeFileGenerator<P extends ClassMeta> extends ContextGenerator<P, File> {
    private static final String PLACEHOLDER_CLASS_NAME = "className";
    private static final String PLACEHOLDER_PACKAGE = "package";
    private static final String PLACEHOLDER_FIELDS = "fields";
    private static final String PLACEHOLDER_GETTER_SETTERS = "getterSetters";
    private static final String DEFAULT_FILE_EXTENSION = "java";

    public CodeFileGenerator(final Context context) {
        super(context);
    }

    @Override
    public final File generate(final P classMeta) throws Exception {
        if (classMeta != null) {
            final Map<String, String> templateParams = getParams(classMeta);
            final String fileName = getFileName(classMeta);
            final String filePath = getFilePath(classMeta);
            final String fileContent = getFileContent(classMeta, templateParams);
            final FileMeta fileMeta = getFileMeta(fileName, filePath, fileContent);
            return createFile(fileMeta);
        }
        return null;
    }

    protected File createFile(FileMeta fileMeta) throws Exception {
        return getFactory().getFileGenerator().generate(fileMeta);
    }

    protected FileMeta getFileMeta(String fileName, String filePath, String fileContent) {
        return new FileMetaImpl(fileName, fileContent, filePath);
    }

    protected String getFileContent(P classMeta, Map<String, String> templateParams) throws IOException {
        return getTemplateResolver().resolveTemplate(getTemplateName(classMeta), templateParams);
    }

    protected String getFileName(P classMeta) {
        return classMeta.getName() + "." + getFileExtension();
    }

    protected String getFileExtension() {
        return DEFAULT_FILE_EXTENSION;
    }

    private String getFilePath(final ClassMeta classMeta) {
        final String filePath = "\\" + classMeta.getPackage().replace('.', '\\');
        final File currentFolder = new File(".");
        final Collection<File> folders = FileUtils.listFilesAndDirs(currentFolder, new NotFileFilter(TrueFileFilter.INSTANCE), DirectoryFileFilter.INSTANCE);
        for (final File folder : folders) {
            if (folder.getAbsolutePath().endsWith(filePath)) {
                return folder.getAbsolutePath();
            }
        }
        return filePath;
    }

    private Map<String, String> getParams(final P classMeta) throws Exception {
        final Map<String, String> templateParams = getDefaultParams(classMeta);
        final Map<String, String> additionalParams = getAdditionalParams(classMeta);
        if (MapUtils.isNotEmpty(additionalParams)) {
            templateParams.putAll(additionalParams);
        }
        return templateParams;
    }

    private Map<String, String> getDefaultParams(final P classMeta) throws Exception {
        final FieldMeta[] fieldsMeta = getFieldsMeta(classMeta);
        return new HashMap<String, String>() {{
            put(PLACEHOLDER_CLASS_NAME, classMeta.getName());
            put(PLACEHOLDER_PACKAGE, classMeta.getPackage());
            if (fieldsMeta != null) {
                put(PLACEHOLDER_FIELDS, getFieldsString(fieldsMeta));
                put(PLACEHOLDER_GETTER_SETTERS, getGetterSetters(fieldsMeta));
            }
        }};
    }

    private String getFieldsString(final FieldMeta[] fieldsMeta) throws Exception {
        final FieldGenerator fieldGenerator = getFactory().getFieldGenerator();
        final StringBuilder builder = new StringBuilder();
        for (final FieldMeta fieldMeta : fieldsMeta) {
            builder.append(fieldGenerator.generate(fieldMeta));
        }
        return builder.toString();
    }

    private String getGetterSetters(final FieldMeta[] fieldsMeta) throws Exception {
        final GetterGenerator getterGenerator = getFactory().getGetterGenerator();
        final SetterGenerator setterGenerator = getFactory().getSetterGenerator();
        final StringBuilder builder = new StringBuilder();
        for (final FieldMeta fieldMeta : fieldsMeta) {
            builder.append(getterGenerator.generate(fieldMeta));
            builder.append(setterGenerator.generate(fieldMeta)).append("\n");
        }
        return builder.toString();
    }

    protected abstract String getTemplateName(P classMeta);

    protected abstract Map<String, String> getAdditionalParams(P classMeta);

    protected abstract FieldMeta[] getFieldsMeta(P classMeta);
}
