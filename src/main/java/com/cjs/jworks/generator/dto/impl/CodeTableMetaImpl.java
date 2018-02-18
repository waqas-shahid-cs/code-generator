package com.cjs.jworks.generator.dto.impl;

import com.cjs.jworks.generator.dto.base.*;

public class CodeTableMetaImpl implements CodeTableMeta {
    private boolean sorted;
    private final EntityMeta entityMeta;
    private CodeTableSqlMeta sqlFileMeta;
    private CodeTableJSMeta jsFileMeta;

    public CodeTableMetaImpl(final EntityMeta entityMeta) {
        this.entityMeta = entityMeta;
    }

    @Override
    public String getName() {
        return entityMeta.getName();
    }

    @Override
    public TableMeta getTable() {
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
    public CodeTableSqlMeta getSqlFileMeta() {
        return sqlFileMeta;
    }

    public void setSqlFileMeta(CodeTableSqlMeta sqlFileMeta) {
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
    public CodeTableJSMeta getJSFileMeta() {
        return jsFileMeta;
    }

    public void setJSFileMeta(CodeTableJSMeta jsFileMeta) {
        this.jsFileMeta = jsFileMeta;
    }
}
