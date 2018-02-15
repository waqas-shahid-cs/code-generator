package com.cjs.jworks.generator.dto.impl;

import com.cjs.jworks.generator.dto.base.*;

public class ServiceMetaImpl implements ServiceMeta {
    private final EntityMeta entityMeta;
    private final DomainMeta domainMeta;
    private final RepositoryMeta repositoryMeta;
    private final ClassMeta baseServiceMeta;
    private final ClassMeta serviceImplMeta;

    public ServiceMetaImpl(final ClassMeta baseServiceMeta, final ClassMeta serviceImplMeta, final EntityMeta entityMeta, final DomainMeta domainMeta, final RepositoryMeta repositoryMeta) {
        this.entityMeta = entityMeta;
        this.domainMeta = domainMeta;
        this.repositoryMeta = repositoryMeta;
        this.baseServiceMeta = baseServiceMeta;
        this.serviceImplMeta = serviceImplMeta;
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

    @Override
    public ClassMeta getBaseServiceMeta() {
        return baseServiceMeta;
    }

    @Override
    public ClassMeta getServiceImplMeta() {
        return serviceImplMeta;
    }
}
