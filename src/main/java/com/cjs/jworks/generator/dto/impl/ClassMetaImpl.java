package com.cjs.jworks.generator.dto.impl;

import com.cjs.jworks.generator.dto.base.ClassMeta;

public class ClassMetaImpl implements ClassMeta {
    private final String name;
    private final String packageName;

    public ClassMetaImpl(final String name, final String packageName) {
        this.name = name;
        this.packageName = packageName;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPackage() {
        return packageName;
    }
}
