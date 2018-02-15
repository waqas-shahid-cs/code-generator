package com.cjs.jworks.generator.generator.impl;

import com.cjs.jworks.generator.context.Context;
import com.cjs.jworks.generator.dto.base.ClassMeta;
import com.cjs.jworks.generator.dto.base.FieldMeta;
import com.cjs.jworks.generator.dto.base.ServiceMeta;
import com.cjs.jworks.generator.dto.impl.ClassMetaImpl;
import com.cjs.jworks.generator.generator.base.ServiceGenerator;
import org.apache.commons.lang.WordUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ServiceGeneratorImpl extends ServiceGenerator {
    private static final String PLACEHOLDER_ENTITY_PACKAGE = "entityPackage";
    private static final String PLACEHOLDER_ENTITY_NAME = "entityName";
    private static final String PLACEHOLDER_DOMAIN_PACKAGE = "domainPackage";
    private static final String PLACEHOLDER_DOMAIN_NAME = "domainName";
    private static final String PLACEHOLDER_DOMAIN_VAR = "domainVar";
    private static final String PLACEHOLDER_REPO_PACKAGE = "repoPackage";
    private static final String PLACEHOLDER_REPO_NAME = "repoName";
    private static final String PLACEHOLDER_REPO_VAR = "repoVar";
    private static final String PLACEHOLDER_BASE_INTERFACE = "baseInterface";
    private static final String PLACEHOLDER_BASE_INTERFACE_PACKAGE = "baseInterfacePackage";
    private static final String PLACEHOLDER_PRIMARY_KEY = "primaryKey";
    private static final String PLACEHOLDER_PRIMARY_FIELD_TYPE = "primaryFieldType";
    private static final String PLACEHOLDER_PRIMARY_FIELD = "primaryField";

    private static final String PACKAGE_SERVICE = "package.service";
    private static final String PACKAGE_SERVICE_IMPL = "package.service.impl";
    private static final String TEMPLATE_SERVICE = "template.service";
    private static final String TEMPLATE_SERVICE_IMPL = "template.service.impl";

    public ServiceGeneratorImpl(final Context context) {
        super(context);
    }

    @Override
    public File[] generate(final ServiceMeta serviceMeta) throws Exception {
        if (serviceMeta != null) {
            final File[] serviceFiles = new File[2];
            final ClassMeta serviceClass = new ClassMetaImpl(serviceMeta.getBaseInterfaceName(), getPath(PACKAGE_SERVICE), getPackage(PACKAGE_SERVICE));
            final ClassMeta serviceImplClass = new ClassMetaImpl(serviceMeta.getImplClassName(), getPath(PACKAGE_SERVICE_IMPL), getPackage(PACKAGE_SERVICE_IMPL));
            final FieldMeta primaryField = getPrimaryField(serviceMeta.getEntityMeta().getFieldsMeta());
            final Map<String, String> params = new HashMap<String, String>() {{
                put(PLACEHOLDER_ENTITY_PACKAGE, serviceMeta.getEntityMeta().getPackage());
                put(PLACEHOLDER_ENTITY_NAME, serviceMeta.getEntityMeta().getName());
                put(PLACEHOLDER_DOMAIN_PACKAGE, serviceMeta.getDomainMeta().getPackage());
                put(PLACEHOLDER_DOMAIN_NAME, serviceMeta.getDomainMeta().getName());
                put(PLACEHOLDER_DOMAIN_VAR, getCamelCase(serviceMeta.getDomainMeta().getName()));
                put(PLACEHOLDER_REPO_PACKAGE, serviceMeta.getRepositoryMeta().getPath());
                put(PLACEHOLDER_REPO_NAME, serviceMeta.getRepositoryMeta().getName());
                put(PLACEHOLDER_REPO_VAR, getCamelCase(serviceMeta.getRepositoryMeta().getName()));
                put(PLACEHOLDER_BASE_INTERFACE, serviceClass.getName());
                put(PLACEHOLDER_BASE_INTERFACE_PACKAGE, serviceClass.getPath());
                if (primaryField != null) {
                    put(PLACEHOLDER_PRIMARY_KEY, WordUtils.capitalize(primaryField.getName()));
                    put(PLACEHOLDER_PRIMARY_FIELD_TYPE, primaryField.getType());
                    put(PLACEHOLDER_PRIMARY_FIELD, primaryField.getName());
                }
            }};
            serviceFiles[0] = new DefaultCodeFileGenerator(getContext(), getProperty(TEMPLATE_SERVICE, ""), params, null).generate(serviceClass);
            serviceFiles[1] = new DefaultCodeFileGenerator(getContext(), getProperty(TEMPLATE_SERVICE_IMPL, ""), params, null).generate(serviceImplClass);
            return serviceFiles;
        }
        return null;
    }

    protected String getPath(final String propertyName) {
        return getPackage(propertyName).replace('.', '/');
    }

    protected String getPackage(String packageEntity) {
        return getProperty(packageEntity, "");
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
