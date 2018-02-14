package com.cjs.jworks.generator.dto.base;

public interface ControllerMeta extends ClassMeta {
    ServiceMeta getServiceMeta();

    String getEndpoint();
}
