package com.jworks.code.generator.generators.impl;

import com.jworks.code.generator.Configuration;
import com.jworks.code.generator.dto.base.EntityMeta;
import com.jworks.code.generator.generators.base.EntityGenerator;

import java.io.File;

public class EntityGeneratorImpl extends EntityGenerator {

    public EntityGeneratorImpl(final Configuration configuration) {
        super(configuration);
    }

    @Override
    public File generate(final EntityMeta args) {
        return null;
    }
}
