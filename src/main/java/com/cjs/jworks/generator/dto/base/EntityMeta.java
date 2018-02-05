package com.cjs.jworks.generator.dto.base;

public interface EntityMeta extends ClassMeta {
    String getTable();

    FieldMeta[] getFieldsMeta();
}
