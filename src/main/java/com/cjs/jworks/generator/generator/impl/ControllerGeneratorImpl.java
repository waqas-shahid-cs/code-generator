package com.cjs.jworks.generator.generator.impl;

import com.cjs.jworks.generator.context.Context;
import com.cjs.jworks.generator.dto.base.ControllerMeta;
import com.cjs.jworks.generator.dto.base.EntityMeta;
import com.cjs.jworks.generator.dto.base.FieldMeta;
import com.cjs.jworks.generator.generator.base.ClassFileGenerator;
import com.cjs.jworks.generator.generator.base.ControllerGenerator;
import com.cjs.jworks.generator.util.WordUtils;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class ControllerGeneratorImpl extends ClassFileGenerator<ControllerMeta> implements ControllerGenerator {

    private static final String PLACEHOLDER_SERVICE_PACKAGE = "servicePackage";
    private static final String PLACEHOLDER_SERVICE_NAME = "serviceName";
    private static final String PLACEHOLDER_SERVICE_VAR = "serviceVar";
    private static final String PLACEHOLDER_DOMAIN_PACKAGE = "domainPackage";
    private static final String PLACEHOLDER_DOMAIN_NAME = "domainName";
    private static final String PLACEHOLDER_ENTITY_NAME = "entityName";
    private static final String PLACEHOLDER_PRIMARY_FIELD_TYPE = "primaryFieldType";
    private static final String PLACEHOLDER_PRIMARY_FIELD = "primaryField";
    private static final String PLACEHOLDER_ENDPOINT = "endpoint";

    private static final String TEMPLATE_CONTROLLER = "template.controller";

    public ControllerGeneratorImpl(final Context context) {
        super(context);
    }

    @Override
    protected String getTemplateName(final ControllerMeta controllerMeta) {
        return getProperty(TEMPLATE_CONTROLLER);
    }

    @Override
    protected Map<String, String> getAdditionalParams(final ControllerMeta controllerMeta) {
        final EntityMeta entityMeta = controllerMeta.getServiceMeta().getRepositoryMeta().getEntityMeta();
        final FieldMeta primaryField = entityMeta.getTable().getPrimaryField();
        return new HashMap<String, String>() {{
            put(PLACEHOLDER_ENDPOINT, controllerMeta.getEndpoint());
            put(PLACEHOLDER_DOMAIN_PACKAGE, controllerMeta.getServiceMeta().getDomainMeta().getPackage());
            put(PLACEHOLDER_DOMAIN_NAME, controllerMeta.getServiceMeta().getDomainMeta().getName());
            put(PLACEHOLDER_SERVICE_VAR, WordUtils.getCamelCase(controllerMeta.getServiceMeta().getBaseServiceMeta().getName()));
            put(PLACEHOLDER_ENTITY_NAME, entityMeta.getName().toLowerCase());
            put(PLACEHOLDER_SERVICE_PACKAGE, controllerMeta.getServiceMeta().getBaseServiceMeta().getPackage());
            put(PLACEHOLDER_SERVICE_NAME, controllerMeta.getServiceMeta().getBaseServiceMeta().getName());
            if (primaryField != null) {
                put(PLACEHOLDER_PRIMARY_FIELD_TYPE, primaryField.getType());
                put(PLACEHOLDER_PRIMARY_FIELD, primaryField.getName());
            }
        }};
    }

    @Override
    protected Collection<FieldMeta> getFieldsMeta(ControllerMeta classMeta) {
        return new LinkedHashSet<>(0);
    }
}
