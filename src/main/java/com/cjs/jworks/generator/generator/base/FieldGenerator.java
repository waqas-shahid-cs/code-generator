package com.cjs.jworks.generator.generator.base;

import com.cjs.jworks.generator.context.Context;
import com.cjs.jworks.generator.dto.base.FieldMeta;

public abstract class FieldGenerator extends ContextGenerator<FieldMeta, String> {
    public FieldGenerator(final Context context) {
        super(context);
    }
}
