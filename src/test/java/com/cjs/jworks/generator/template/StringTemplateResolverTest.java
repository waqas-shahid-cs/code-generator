package com.cjs.jworks.generator.template;

import com.cjs.jworks.generator.BaseTest;
import com.cjs.jworks.generator.context.Context;
import com.cjs.jworks.generator.context.ContextImpl;
import com.cjs.jworks.generator.template.base.TemplateResolver;
import com.cjs.jworks.generator.template.impl.StringTemplateResolver;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.NotFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

public class StringTemplateResolverTest extends BaseTest {

    @Test
    public void testReturnNullWhenTemplateNameIsNullOrBlank() throws IOException {
        final TemplateResolver resolver = new StringTemplateResolver(getContext());
        assert resolver.resolveTemplate(null, null) == null;
        assert resolver.resolveTemplate("", null) == null;
        assert resolver.resolveTemplate("   ", null) == null;
    }

    @Test
    public void testReturnTemplateString() throws IOException {
        final TemplateResolver resolver = new StringTemplateResolver(getContext());
        assert resolver.resolveTemplate(getProperties().getProperty("template.entity"), null) != null;
    }

    @Test
    public void testReturnNullWhenTemplateNotFound() throws IOException {
        final TemplateResolver resolver = new StringTemplateResolver(getContext());
        assert resolver.resolveTemplate("abcd", null) == null;
    }

    @Test
    public void testReturnNullWhenTemplateFolderNotFound() throws IOException {
        final Context context = new ContextImpl();
        final TemplateResolver resolver = new StringTemplateResolver(context);
        assert resolver.resolveTemplate("abcd", null) == null;
    }

    @Test
    public void testReturnTemplateStringWithResolvedParams() throws IOException {
        final TemplateResolver resolver = new StringTemplateResolver(getContext());
        final String templateString = resolver.resolveTemplate(getProperties().getProperty("template.entity"), null);
        final String resolvedTemplateString = resolver.resolveTemplate(getProperties().getProperty("template.entity"), new HashMap<String, String>() {{
            put("tableName", "CASES_VIEW");
            put("fields", "");
        }});
        assert !templateString.equals(resolvedTemplateString);
    }

    @Test
    public void testFiles() {
        final Collection<File> files = FileUtils.listFilesAndDirs(new File("D:\\Code\\jworks2"), new NotFileFilter(TrueFileFilter.INSTANCE), new WildcardFileFilter("**entity**"));
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
    }
}
