package com.cjs.jworks.generator.generator.impl;

import com.cjs.jworks.generator.context.Context;
import com.cjs.jworks.generator.dto.base.ControllerMeta;
import com.cjs.jworks.generator.dto.base.FieldMeta;
import com.cjs.jworks.generator.generator.base.ClassFileGenerator;
import com.cjs.jworks.generator.generator.base.ControllerGenerator;

import java.util.HashMap;
import java.util.Map;

public class ControllerGeneratorImpl extends ClassFileGenerator<ControllerMeta> implements ControllerGenerator {

    private static final String TEMPLATE_CONTROLLER = "template.controller";

    public ControllerGeneratorImpl(final Context context) {
        super(context);
    }

    @Override
    protected String getTemplateName(final ControllerMeta controllerMeta) {
        return getProperty(TEMPLATE_CONTROLLER, "");
    }

    @Override
    protected Map<String, String> getAdditionalParams(final ControllerMeta controllerMeta) {
        return new HashMap<String, String>() {{
        }};
    }

    @Override
    protected FieldMeta[] getFieldsMeta(ControllerMeta classMeta) {
        return new FieldMeta[0];
    }
}
