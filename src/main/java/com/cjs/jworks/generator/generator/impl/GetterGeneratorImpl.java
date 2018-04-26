package com.cjs.jworks.generator.generator.impl;

import com.cjs.jworks.generator.context.Context;
import com.cjs.jworks.generator.dto.base.FieldMeta;
import com.cjs.jworks.generator.generator.base.GetterGenerator;
import com.cjs.jworks.generator.util.WordUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GetterGeneratorImpl extends GetterGenerator {
    private static final String TEMPLATE_GETTER = "template.getter";

    private static final String PLACEHOLDER_METHOD_NAME = "methodName";
    private static final String PLACEHOLDER_FIELD_NAME = "fieldName";
    private static final String PLACEHOLDER_FIELD_TYPE = "fieldType";
    private static final String PLACEHOLDER_ANNOTATIONS = "annotations";

    public GetterGeneratorImpl(final Context context) {
        super(context);
    }

    @Override
    public String generate(final FieldMeta fieldMeta) throws Exception {
        if (fieldMeta != null) {
            final Map<String, String> templateParams = new HashMap<String, String>() {{
                put(PLACEHOLDER_METHOD_NAME, WordUtils.capitalize(fieldMeta.getName()));
                put(PLACEHOLDER_FIELD_NAME, fieldMeta.getName());
                put(PLACEHOLDER_FIELD_TYPE, fieldMeta.getType());
                put(PLACEHOLDER_ANNOTATIONS, getAnnotations(fieldMeta));
            }};
            try {
                return getTemplateResolver().resolveTemplate(getProperty(TEMPLATE_GETTER), templateParams);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private String getAnnotations(final FieldMeta fieldMeta) {
        final StringBuilder annotations = new StringBuilder();
        if (StringUtils.isNotBlank(fieldMeta.getDbColumn())) {
            if (fieldMeta.isPrimaryKey()) {
                annotations.append("@Id")
                        .append("\n")
                        .append("@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = \"NOTY_SEQUENCE\")")
                        .append("\n");
            }
            if (!fieldMeta.isForeignKey()) {
                annotations.append(String.format("@Column(name = \"%s\", nullable = %b)", fieldMeta.getDbColumn(), fieldMeta.isNullable()));
            } else {
                annotations.append(String.format("@JoinColumn(name = \"%s\", nullable = %b)", fieldMeta.getDbColumn(), fieldMeta.isNullable()));
            }
        }
        return annotations.toString();
    }
}
