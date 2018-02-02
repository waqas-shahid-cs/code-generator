package com.jworks.code.generator.generators.base;

import com.jworks.code.generator.Configuration;
import com.jworks.code.generator.dto.base.DomainMeta;

import java.io.File;

public abstract class DomainGenerator extends Generator<DomainMeta, File> {
    public DomainGenerator(final Configuration configuration) {
        super(configuration);
    }
}
