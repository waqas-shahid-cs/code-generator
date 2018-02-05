package com.cjs.jworks.generator.dto.base;

public interface FieldMeta {
    String getName();

    String getType();

    String getDbColumn();

    boolean isPrimaryKey();

    void setPrimaryKey(boolean primaryKey);

    boolean isNullable();

    void setNullable(boolean nullable);

    boolean isForeignKey();

    void setForeignKey(boolean foreignKey);
}
