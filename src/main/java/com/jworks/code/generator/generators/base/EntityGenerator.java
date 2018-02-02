package com.jworks.code.generator.generators.base;

import com.jworks.code.generator.Configuration;
import com.jworks.code.generator.dto.base.EntityMeta;

import java.io.File;

public abstract class EntityGenerator extends Generator<EntityMeta, File> {
    public EntityGenerator(final Configuration configuration) {
        super(configuration);
    }
}
