package com.cjs.jworks.generator.template.impl;

import com.cjs.jworks.generator.context.Context;
import com.cjs.jworks.generator.template.base.Template;
import com.cjs.jworks.generator.template.base.TemplateResolver;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Map;

public class StringTemplateResolver extends TemplateResolver {
    private static final String TEMPLATE_FOLDER_KEY = "template.folder";
    private static final String PLACEHOLDER = "{%s}";

    public StringTemplateResolver(final Context context) {
        super(context);
    }

    @Override
    public String resolveTemplate(final String templateName, final Map<String, String> params) throws IOException {
        if (StringUtils.isNotBlank(templateName)) {
            final String templateString = getTemplateString(templateName);
            return resolve(templateString, params);
        }
        return null;
    }

    @Override
    public String resolve(String content, Map<String, String> params) {
        if (StringUtils.isNotBlank(content) && MapUtils.isNotEmpty(params)) {
            for (final Map.Entry<String, String> param : params.entrySet()) {
                content = content.replace(String.format(PLACEHOLDER, param.getKey()), param.getValue());
            }
        }
        return content;
    }

    @Override
    public Template getTemplate(final String templateName) throws IOException {
        if (StringUtils.isNotBlank(templateName)) {
            final TemplateImpl template = new TemplateImpl();
            template.setName(templateName);
            template.setContent(getTemplateString(templateName));
            return template;
        }
        return null;
    }

    private String getTemplateString(String templateName) throws IOException {
        final File templateFolder = getTemplateFolder();
        if (templateFolder != null && templateFolder.exists()) {
            final File templateFile = new File(templateFolder, templateName);
            if (templateFile.exists()) {
                return readFile(templateFile);
            }
        }
        return null;
    }

    private String readFile(File templateFile) throws IOException {
        final StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(templateFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }
        }
        return builder.toString();
    }

    private File getTemplateFolder() {
        final URL url = getClass().getClassLoader().getResource(getContext().getProperties().getProperty(TEMPLATE_FOLDER_KEY, ""));
        if (url != null) {
            try {
                return new File(URLDecoder.decode(url.getFile(), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private class TemplateImpl implements Template {
        private String name;
        private String content;

        @Override
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        @Override
        public String resolve(Map<String, String> params) {
            return StringTemplateResolver.this.resolve(getContent(), params);
        }
    }
}
