package com.cjs.jworks.generator.dto.base;

import java.util.Collection;

public interface TableMeta {
    String getName();

    Collection<FieldMeta> getFields();

    FieldMeta getPrimaryField();

    void addField(FieldMeta fieldMeta);
}
