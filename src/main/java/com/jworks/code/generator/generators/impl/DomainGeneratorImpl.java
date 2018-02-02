package com.jworks.code.generator.generators.impl;

import com.jworks.code.generator.Configuration;
import com.jworks.code.generator.dto.base.DomainMeta;
import com.jworks.code.generator.generators.base.DomainGenerator;

import java.io.File;

public class DomainGeneratorImpl extends DomainGenerator {
    public DomainGeneratorImpl(final Configuration configuration) {
        super(configuration);
    }

    @Override
    public File generate(final DomainMeta args) {
        return null;
    }
}
