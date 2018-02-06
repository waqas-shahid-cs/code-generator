package com.cjs.jworks.generator.dto.base;

public interface EntityMeta extends ClassMeta {
    String getTable();

    boolean isCodeTable();

    boolean isSortedCodeTable();

    FieldMeta[] getFieldsMeta();
}
