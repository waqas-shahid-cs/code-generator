package com.cjs.jworks.generator.dto.impl;

import com.cjs.jworks.generator.dto.base.DomainMeta;
import com.cjs.jworks.generator.dto.base.EntityMeta;

public class DomainMetaImpl extends ClassMetaImpl implements DomainMeta {
    private final EntityMeta entityMeta;

    public DomainMetaImpl(final String name, String path, final EntityMeta entityMeta, final String packageName) {
        super(name, path, packageName);
        this.entityMeta = entityMeta;
    }

    @Override
    public EntityMeta getEntityMeta() {
        return entityMeta;
    }
}
