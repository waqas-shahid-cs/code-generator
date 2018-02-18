package com.cjs.jworks.generator.dto.impl;

import com.cjs.jworks.generator.dto.base.ClassMeta;
import com.cjs.jworks.generator.dto.base.DomainMeta;
import com.cjs.jworks.generator.dto.base.RepositoryMeta;
import com.cjs.jworks.generator.dto.base.ServiceMeta;

public class ServiceMetaImpl implements ServiceMeta {
    private final DomainMeta domainMeta;
    private final RepositoryMeta repositoryMeta;
    private final ClassMeta baseServiceMeta;
    private final ClassMeta serviceImplMeta;

    public ServiceMetaImpl(final ClassMeta baseServiceMeta, final ClassMeta serviceImplMeta, final DomainMeta domainMeta, final RepositoryMeta repositoryMeta) {
        this.domainMeta = domainMeta;
        this.repositoryMeta = repositoryMeta;
        this.baseServiceMeta = baseServiceMeta;
        this.serviceImplMeta = serviceImplMeta;
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
