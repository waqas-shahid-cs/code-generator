package com.cjs.jworks.generator.dto.impl;

import com.cjs.jworks.generator.dto.base.CodeTableJSMeta;
import com.cjs.jworks.generator.dto.base.CodeTableMeta;

public class CodeTableJSMetaImpl extends JSFileMetaImpl implements CodeTableJSMeta {
    private final CodeTableMeta codeTableMeta;
    private final boolean tabbed;

    public CodeTableJSMetaImpl(final CodeTableMeta codeTableMeta, final boolean tabbed) {
        super(codeTableMeta.getSqlFileMeta().getName(), codeTableMeta.getSqlFileMeta().getPath());
        this.codeTableMeta = codeTableMeta;
        this.tabbed = tabbed;
    }

    @Override
    public CodeTableMeta getCodeTableMeta() {
        return codeTableMeta;
    }

    @Override
    public boolean isTabbed() {
        return tabbed;
    }
}
