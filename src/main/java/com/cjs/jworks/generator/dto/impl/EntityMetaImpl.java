package com.cjs.jworks.generator.dto.impl;

import com.cjs.jworks.generator.dto.base.EntityMeta;
import com.cjs.jworks.generator.dto.base.FieldMeta;

public class EntityMetaImpl extends ClassMetaImpl implements EntityMeta {
    private final String table;
    private boolean codeTable;
    private boolean sortedCodeTable;
    private FieldMeta[] fieldsMeta;

    public EntityMetaImpl(final String name, final String table, final String path, final String packageName) {
        super(name, path, packageName);
        this.table = table;
    }

    @Override
    public String getTable() {
        return table;
    }

    @Override
    public boolean isCodeTable() {
        return codeTable;
    }

    public void setCodeTable(boolean codeTable) {
        this.codeTable = codeTable;
    }

    @Override
    public boolean isSortedCodeTable() {
        return sortedCodeTable;
    }

    public void setSortedCodeTable(boolean sortedCodeTable) {
        this.sortedCodeTable = sortedCodeTable;
    }

    @Override
    public FieldMeta[] getFieldsMeta() {
        return fieldsMeta;
    }

    public void setFieldsMeta(FieldMeta[] fieldsMeta) {
        this.fieldsMeta = fieldsMeta;
    }
}
