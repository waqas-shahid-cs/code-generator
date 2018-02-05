package com.cjs.jworks.generator.dto.impl;

import com.cjs.jworks.generator.dto.base.FieldMeta;

public class FieldMetaImpl implements FieldMeta {

    private final String name;
    private final String type;
    private final String dbColumn;
    private boolean primaryKey;
    private boolean nullable;
    private boolean foreignKey;

    public FieldMetaImpl(String name, String type, String dbColumn) {
        this.name = name;
        this.type = type;
        this.dbColumn = dbColumn;
    }

    public FieldMetaImpl(final String name, final String type, final String dbColumn, final boolean primaryKey, final boolean nullable, final boolean foreignKey) {
        this.name = name;
        this.type = type;
        this.dbColumn = dbColumn;
        this.primaryKey = primaryKey;
        this.nullable = nullable;
        this.foreignKey = foreignKey;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getDbColumn() {
        return dbColumn;
    }

    @Override
    public boolean isPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(boolean primaryKey) {
        this.primaryKey = primaryKey;
    }

    @Override
    public boolean isNullable() {
        return nullable;
    }

    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }

    @Override
    public boolean isForeignKey() {
        return foreignKey;
    }

    public void setForeignKey(boolean foreignKey) {
        this.foreignKey = foreignKey;
    }
}
