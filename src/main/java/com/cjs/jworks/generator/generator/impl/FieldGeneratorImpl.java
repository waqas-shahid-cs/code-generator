package com.cjs.jworks.generator.generator.impl;

import com.cjs.jworks.generator.context.Context;
import com.cjs.jworks.generator.dto.base.FieldMeta;
import com.cjs.jworks.generator.generator.base.FieldGenerator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FieldGeneratorImpl extends FieldGenerator {
    private static final String PLACEHOLDER_FIELD_NAME = "fieldName";
    private static final String PLACEHOLDER_FIELD_TYPE = "fieldType";

    private static final String TEMPLATE_FIELD = "template.field";

    public FieldGeneratorImpl(final Context context) {
        super(context);
    }

    @Override
    public String generate(final FieldMeta fieldMeta) throws Exception {
        if (fieldMeta != null) {
            final Map<String, String> templateParams = new HashMap<String, String>() {{
                put(PLACEHOLDER_FIELD_NAME, fieldMeta.getName());
                put(PLACEHOLDER_FIELD_TYPE, fieldMeta.getType());
            }};
            try {
                return getTemplateResolver().resolveTemplate(getProperty(TEMPLATE_FIELD), templateParams);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
