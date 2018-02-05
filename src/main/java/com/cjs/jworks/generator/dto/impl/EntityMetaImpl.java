package com.cjs.jworks.generator.dto.impl;

import com.cjs.jworks.generator.dto.base.EntityMeta;
import com.cjs.jworks.generator.dto.base.FieldMeta;

public class EntityMetaImpl extends ClassMetaImpl implements EntityMeta {
    private final String table;
    private FieldMeta[] fieldsMeta;

    public EntityMetaImpl(final String name, final String table, final String packageName) {
        super(name, packageName);
        this.table = table;
    }

    @Override
    public String getTable() {
        return table;
    }

    @Override
    public FieldMeta[] getFieldsMeta() {
        return fieldsMeta;
    }

    public void setFieldsMeta(FieldMeta[] fieldsMeta) {
        this.fieldsMeta = fieldsMeta;
    }
}
