package com.cjs.jworks.generator.dto.impl;

import com.cjs.jworks.generator.dto.base.DomainMeta;
import com.cjs.jworks.generator.dto.base.EntityMeta;
import com.cjs.jworks.generator.dto.base.RepositoryMeta;
import com.cjs.jworks.generator.dto.base.ServiceMeta;

public class ServiceMetaImpl implements ServiceMeta {
    private final EntityMeta entityMeta;
    private final DomainMeta domainMeta;
    private final RepositoryMeta repositoryMeta;
    private final String baseInterfaceName;
    private final String implClassName;

    public ServiceMetaImpl(final String baseInterfaceName, final String implClassName, final EntityMeta entityMeta, final DomainMeta domainMeta, final RepositoryMeta repositoryMeta) {
        this.entityMeta = entityMeta;
        this.domainMeta = domainMeta;
        this.repositoryMeta = repositoryMeta;
        this.baseInterfaceName = baseInterfaceName;
        this.implClassName = implClassName;
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
    public String getBaseInterfaceName() {
        return baseInterfaceName;
    }

    @Override
    public String getImplClassName() {
        return implClassName;
    }
}
