package com.cjs.jworks.generator.generator.base;

import com.cjs.jworks.generator.context.Context;
import com.cjs.jworks.generator.dto.base.ServiceMeta;

import java.io.File;

public abstract class ServiceGenerator extends ContextGenerator<ServiceMeta, File[]> {
    public ServiceGenerator(final Context context) {
        super(context);
    }
}
