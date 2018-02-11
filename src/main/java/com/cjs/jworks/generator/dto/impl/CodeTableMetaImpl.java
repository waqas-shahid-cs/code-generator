package com.cjs.jworks.generator.dto.impl;

import com.cjs.jworks.generator.dto.base.CodeTableMeta;
import com.cjs.jworks.generator.dto.base.EntityMeta;
import com.cjs.jworks.generator.dto.base.FieldMeta;
import com.cjs.jworks.generator.dto.base.SqlFileMeta;

public class CodeTableMetaImpl implements CodeTableMeta {
    private boolean sorted;
    private final EntityMeta entityMeta;
    private SqlFileMeta sqlFileMeta;

    public CodeTableMetaImpl(final EntityMeta entityMeta) {
        this.entityMeta = entityMeta;
    }

    @Override
    public String getName() {
        return entityMeta.getName();
    }

    @Override
    public String getTable() {
        return entityMeta.getTable();
    }

    @Override
    public String getPackage() {
        return entityMeta.getPackage();
    }

    @Override
    public String getPath() {
        return entityMeta.getPath();
    }

    @Override
    public SqlFileMeta getSqlFileMeta() {
        return sqlFileMeta;
    }

    public void setSqlFileMeta(SqlFileMeta sqlFileMeta) {
        this.sqlFileMeta = sqlFileMeta;
    }

    @Override
    public boolean isSorted() {
        return sorted;
    }

    public void setSorted(boolean sorted) {
        this.sorted = sorted;
    }

    @Override
    public FieldMeta[] getFieldsMeta() {
        return entityMeta.getFieldsMeta();
    }

}
