package com.cjs.jworks.generator.dto.base;

public interface ServiceMeta {
    EntityMeta getEntityMeta();

    DomainMeta getDomainMeta();

    RepositoryMeta getRepositoryMeta();

    String getBaseInterfaceName();

    String getImplClassName();
}
