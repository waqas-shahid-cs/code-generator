package com.cjs.jworks.generator.dto.impl;

import com.cjs.jworks.generator.dto.base.FieldMeta;
import com.cjs.jworks.generator.dto.base.TableMeta;

public class TableMetaImpl implements TableMeta {
    private final String name;
    private final FieldMeta[] fields;

    public TableMetaImpl(final String name, final FieldMeta[] fields) {
        this.name = name;
        this.fields = fields;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public FieldMeta[] getFields() {
        return fields;
    }

    @Override
    public FieldMeta getPrimaryField() {
        if (getFields() != null) {
            for (final FieldMeta fieldMeta : getFields()) {
                if (fieldMeta.isPrimaryKey()) {
                    return fieldMeta;
                }
            }
        }
        return null;
    }
}
