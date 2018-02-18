package com.cjs.jworks.generator.dto.impl;

import com.cjs.jworks.generator.dto.base.CodeTableMeta;
import com.cjs.jworks.generator.dto.base.CodeTableSqlMeta;

public class CodeTableSqlMetaImpl extends CodeFileMetaImpl implements CodeTableSqlMeta {
    private final CodeTableMeta codeTableMeta;

    public CodeTableSqlMetaImpl(final String name, final String path, final CodeTableMeta codeTableMeta) {
        super(name, path);
        this.codeTableMeta = codeTableMeta;
    }

    @Override
    public CodeTableMeta getCodeTableMeta() {
        return codeTableMeta;
    }
}
