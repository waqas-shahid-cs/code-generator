package com.cjs.jworks.generator.dto.impl;

import com.cjs.jworks.generator.dto.base.ControllerMeta;
import com.cjs.jworks.generator.dto.base.ServiceMeta;

public class ControllerMetaImpl extends ClassMetaImpl implements ControllerMeta {
    private final ServiceMeta serviceMeta;
    private final String endpoint;

    public ControllerMetaImpl(final String name, final String path, final String packageName, final String endpoint, final ServiceMeta serviceMeta) {
        super(name, path, packageName);
        this.endpoint = endpoint;
        this.serviceMeta = serviceMeta;
    }

    @Override
    public ServiceMeta getServiceMeta() {
        return serviceMeta;
    }

    @Override
    public String getEndpoint() {
        return endpoint;
    }
}
