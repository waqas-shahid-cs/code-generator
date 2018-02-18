package com.cjs.jworks.generator.dto.base;

public interface ServiceMeta {
    DomainMeta getDomainMeta();

    RepositoryMeta getRepositoryMeta();

    ClassMeta getBaseServiceMeta();

    ClassMeta getServiceImplMeta();
}
