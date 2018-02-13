package com.cjs.jworks.generator.dto.impl;

import com.cjs.jworks.generator.dto.base.ClassMeta;

public class ClassMetaImpl extends CodeFileMetaImpl implements ClassMeta {
    private final String packageName;

    public ClassMetaImpl(final String name, final String path, final String packageName) {
        super(name, path);
        this.packageName = packageName;
    }

    @Override
    public String getPackage() {
        return packageName;
    }
}
