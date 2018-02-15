package com.cjs.jworks.generator.generator.impl;

import com.cjs.jworks.generator.context.Context;
import com.cjs.jworks.generator.dto.base.ControllerMeta;
import com.cjs.jworks.generator.dto.base.FieldMeta;
import com.cjs.jworks.generator.generator.base.ClassFileGenerator;
import com.cjs.jworks.generator.generator.base.ControllerGenerator;
import org.apache.commons.lang.WordUtils;

import java.util.HashMap;
import java.util.Map;

public class ControllerGeneratorImpl extends ClassFileGenerator<ControllerMeta> implements ControllerGenerator {

    private static final String PLACEHOLDER_SERVICE_PACKAGE = "entityPackage";
    private static final String PLACEHOLDER_SERVICE_NAME = "entityName";
    private static final String PLACEHOLDER_SERVICE_VAR = "serviceVar";
    private static final String PLACEHOLDER_DOMAIN_PACKAGE = "domainPackage";
    private static final String PLACEHOLDER_DOMAIN_NAME = "domainName";
    private static final String PLACEHOLDER_ENTITY_NAME = "entityName";
    private static final String PLACEHOLDER_PRIMARY_FIELD_TYPE = "primaryFieldType";
    private static final String PLACEHOLDER_PRIMARY_FIELD = "primaryField";

    private static final String TEMPLATE_CONTROLLER = "template.controller";

    public ControllerGeneratorImpl(final Context context) {
        super(context);
    }

    @Override
    protected String getTemplateName(final ControllerMeta controllerMeta) {
        return getProperty(TEMPLATE_CONTROLLER, "");
    }

    @Override
    protected Map<String, String> getAdditionalParams(final ControllerMeta controllerMeta) {
        final FieldMeta primaryField = getPrimaryField(controllerMeta.getServiceMeta().getEntityMeta().getFieldsMeta());
        return new HashMap<String, String>() {{
            put(PLACEHOLDER_DOMAIN_PACKAGE, controllerMeta.getServiceMeta().getDomainMeta().getPackage());
            put(PLACEHOLDER_DOMAIN_NAME, controllerMeta.getServiceMeta().getDomainMeta().getName());
            put(PLACEHOLDER_SERVICE_VAR, getCamelCase(controllerMeta.getServiceMeta().getBaseServiceMeta().getName()));
            put(PLACEHOLDER_ENTITY_NAME, controllerMeta.getServiceMeta().getEntityMeta().getName().toLowerCase());
            put(PLACEHOLDER_SERVICE_PACKAGE, controllerMeta.getServiceMeta().getBaseServiceMeta().getPackage());
            put(PLACEHOLDER_SERVICE_NAME, controllerMeta.getServiceMeta().getBaseServiceMeta().getName());
            if (primaryField != null) {
                put(PLACEHOLDER_PRIMARY_FIELD_TYPE, primaryField.getType());
                put(PLACEHOLDER_PRIMARY_FIELD, primaryField.getName());
            }
        }};
    }

    @Override
    protected FieldMeta[] getFieldsMeta(ControllerMeta classMeta) {
        return new FieldMeta[0];
    }

    private FieldMeta getPrimaryField(final FieldMeta[] fieldMetas) {
        if (fieldMetas != null) {
            for (final FieldMeta fieldMeta : fieldMetas) {
                if (fieldMeta.isPrimaryKey()) {
                    return fieldMeta;
                }
            }
        }
        return null;
    }

    private String getCamelCase(final String str) {
        return WordUtils.initials(str).toLowerCase() + str.substring(1);
    }
}
