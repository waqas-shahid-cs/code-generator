package com.cjs.jworks.generator.generator.impl;

import com.cjs.jworks.generator.context.Context;
import com.cjs.jworks.generator.dto.base.DomainMeta;
import com.cjs.jworks.generator.dto.base.EntityMeta;
import com.cjs.jworks.generator.dto.base.FieldMeta;
import com.cjs.jworks.generator.dto.impl.FieldMetaImpl;
import com.cjs.jworks.generator.generator.base.ClassFileGenerator;
import com.cjs.jworks.generator.generator.base.DomainGenerator;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;

public class DomainGeneratorImpl extends ClassFileGenerator<DomainMeta> implements DomainGenerator {

    private static final String TEMPLATE_DOMAIN = "template.domain";

    public DomainGeneratorImpl(final Context context) {
        super(context);
    }

    @Override
    protected String getTemplateName(final DomainMeta domainMeta) {
        return getProperty(TEMPLATE_DOMAIN);
    }

    @Override
    protected Map<String, String> getAdditionalParams(final DomainMeta domainMeta) {
        return null;
    }

    @Override
    protected Collection<FieldMeta> getFieldsMeta(final DomainMeta domainMeta) {
        final EntityMeta entityMeta = domainMeta.getEntityMeta();
        final Collection<FieldMeta> fieldMetas = new LinkedHashSet<>(entityMeta.getTable().getFields().size());
        int i = 0;
        for (final FieldMeta fieldMeta : entityMeta.getTable().getFields()) {
            fieldMetas.add(new FieldMetaImpl(fieldMeta.getName(), fieldMeta.getType(), null, fieldMeta.isPrimaryKey(), fieldMeta.isNullable(), fieldMeta.isForeignKey()));
        }
        return fieldMetas;
    }
}
