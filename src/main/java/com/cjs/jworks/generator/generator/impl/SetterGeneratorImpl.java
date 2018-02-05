package com.cjs.jworks.generator.generator.impl;

import com.cjs.jworks.generator.context.Context;
import com.cjs.jworks.generator.dto.base.FieldMeta;
import com.cjs.jworks.generator.generator.base.SetterGenerator;
import org.apache.commons.lang.WordUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SetterGeneratorImpl extends SetterGenerator {
    private static final String TEMPLATE_SETTER = "template.setter";

    private static final String PLACEHOLDER_METHOD_NAME = "methodName";
    private static final String PLACEHOLDER_FIELD_NAME = "fieldName";
    private static final String PLACEHOLDER_FIELD_TYPE = "fieldType";

    public SetterGeneratorImpl(final Context context) {
        super(context);
    }

    @Override
    public String generate(final FieldMeta fieldMeta) throws Exception {
        if (fieldMeta != null) {
            final Map<String, String> templateParams = new HashMap<String, String>() {{
                put(PLACEHOLDER_METHOD_NAME, WordUtils.capitalize(fieldMeta.getName()));
                put(PLACEHOLDER_FIELD_NAME, fieldMeta.getName());
                put(PLACEHOLDER_FIELD_TYPE, fieldMeta.getType());
            }};
            try {
                return getTemplateResolver().resolveTemplate(getProperty(TEMPLATE_SETTER, ""), templateParams);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
