package com.cjs.jworks.generator.dto.impl;

import com.cjs.jworks.generator.dto.base.CodeTableJSMeta;
import com.cjs.jworks.generator.dto.base.CodeTableMeta;

public class CodeTableJSMetaImpl extends JSFileMetaImpl implements CodeTableJSMeta {
    private final CodeTableMeta codeTableMeta;
    private boolean tabbed;

    public CodeTableJSMetaImpl(final String name, final String path, final CodeTableMeta codeTableMeta) {
        super(name, path);
        this.codeTableMeta = codeTableMeta;
    }

    @Override
    public CodeTableMeta getCodeTableMeta() {
        return codeTableMeta;
    }

    @Override
    public boolean isTabbed() {
        return tabbed;
    }

    public void setTabbed(boolean tabbed) {
        this.tabbed = tabbed;
    }
}
