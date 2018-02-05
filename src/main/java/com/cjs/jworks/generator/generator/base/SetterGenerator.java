package com.cjs.jworks.generator.generator.base;

import com.cjs.jworks.generator.context.Context;
import com.cjs.jworks.generator.dto.base.FieldMeta;

public abstract class SetterGenerator extends ContextGenerator<FieldMeta, String> {
    public SetterGenerator(final Context context) {
        super(context);
    }
}
