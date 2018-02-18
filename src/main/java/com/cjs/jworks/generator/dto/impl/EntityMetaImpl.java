package com.cjs.jworks.generator.dto.impl;

import com.cjs.jworks.generator.dto.base.EntityMeta;
import com.cjs.jworks.generator.dto.base.TableMeta;

public class EntityMetaImpl extends ClassMetaImpl implements EntityMeta {
    private final TableMeta table;

    public EntityMetaImpl(final String name, final TableMeta table, final String path, final String packageName) {
        super(name, path, packageName);
        this.table = table;
    }

    @Override
    public TableMeta getTable() {
        return table;
    }

}
