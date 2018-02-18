package com.cjs.jworks.generator.dto.base;

public interface TableMeta {
    String getName();

    FieldMeta[] getFields();

    FieldMeta getPrimaryField();
}
