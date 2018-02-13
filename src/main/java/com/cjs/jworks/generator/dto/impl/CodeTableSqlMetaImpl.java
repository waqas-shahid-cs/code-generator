package com.cjs.jworks.generator.dto.impl;

import com.cjs.jworks.generator.dto.base.CodeTableMeta;
import com.cjs.jworks.generator.dto.base.CodeTableSqlMeta;

public class CodeTableSqlMetaImpl extends CodeFileMetaImpl implements CodeTableSqlMeta {
    private final CodeTableMeta codeTableMeta;

    public CodeTableSqlMetaImpl(final CodeTableMeta codeTableMeta) {
        super(codeTableMeta.getSqlFileMeta().getName(), codeTableMeta.getSqlFileMeta().getPath());
        this.codeTableMeta = codeTableMeta;
    }

    @Override
    public CodeTableMeta getCodeTableMeta() {
        return codeTableMeta;
    }
}
