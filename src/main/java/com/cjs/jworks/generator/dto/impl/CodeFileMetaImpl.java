package com.cjs.jworks.generator.dto.impl;

import com.cjs.jworks.generator.dto.base.CodeFileMeta;

public class CodeFileMetaImpl implements CodeFileMeta {
    private final String name;
    private final String path;

    public CodeFileMetaImpl(final String name, final String path) {
        this.name = name;
        this.path = path;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPath() {
        return path;
    }
}
