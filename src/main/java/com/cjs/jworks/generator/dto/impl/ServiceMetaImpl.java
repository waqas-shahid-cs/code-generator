package com.cjs.jworks.generator.dto.impl;

import com.cjs.jworks.generator.dto.base.DomainMeta;
import com.cjs.jworks.generator.dto.base.EntityMeta;
import com.cjs.jworks.generator.dto.base.RepositoryMeta;
import com.cjs.jworks.generator.dto.base.ServiceMeta;

public class ServiceMetaImpl implements ServiceMeta {
    private final EntityMeta entityMeta;
    private final DomainMeta domainMeta;
    private final RepositoryMeta repositoryMeta;

    public ServiceMetaImpl(final EntityMeta entityMeta, final DomainMeta domainMeta, final RepositoryMeta repositoryMeta) {
        this.entityMeta = entityMeta;
        this.domainMeta = domainMeta;
        this.repositoryMeta = repositoryMeta;
    }

    @Override
    public EntityMeta getEntityMeta() {
        return entityMeta;
    }

    @Override
    public DomainMeta getDomainMeta() {
        return domainMeta;
    }

    @Override
    public RepositoryMeta getRepositoryMeta() {
        return repositoryMeta;
    }
}
