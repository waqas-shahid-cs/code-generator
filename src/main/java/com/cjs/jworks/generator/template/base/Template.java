package com.cjs.jworks.generator.template.base;

import java.util.Map;

public interface Template {
    String getName();

    String getContent();

    String resolve(Map<String, String> params);
}
