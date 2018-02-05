package com.cjs.jworks.generator.dto.impl;

import com.cjs.jworks.generator.dto.base.EntityMeta;
import com.cjs.jworks.generator.dto.base.RepositoryMeta;

public class RepositoryMetaImpl extends ClassMetaImpl implements RepositoryMeta {
    private final EntityMeta entityMeta;

    public RepositoryMetaImpl(final String name, final String packageName, final EntityMeta entityMeta) {
        super(name, packageName);
        this.entityMeta = entityMeta;
    }

    @Override
    public EntityMeta getEntityMeta() {
        return entityMeta;
    }
}
