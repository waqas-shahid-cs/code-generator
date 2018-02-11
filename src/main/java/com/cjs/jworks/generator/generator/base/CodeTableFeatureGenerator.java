package com.cjs.jworks.generator.generator.base;

import com.cjs.jworks.generator.context.Context;
import com.cjs.jworks.generator.dto.base.CodeTableMeta;

import java.io.File;

public abstract class CodeTableFeatureGenerator extends ContextGenerator<CodeTableMeta, File> {
    public CodeTableFeatureGenerator(final Context context) {
        super(context);
    }
}
