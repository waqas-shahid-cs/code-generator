package com.cjs.jworks.generator.generator.impl;

import com.cjs.jworks.generator.context.Context;
import com.cjs.jworks.generator.dto.base.CodeTableMeta;
import com.cjs.jworks.generator.dto.base.CodeTableSqlMeta;
import com.cjs.jworks.generator.dto.impl.CodeTableSqlMetaImpl;
import com.cjs.jworks.generator.generator.base.CodeTableFeatureGenerator;

import java.io.File;

public class CodeTableFeatureGeneratorImpl extends CodeTableFeatureGenerator {

    public CodeTableFeatureGeneratorImpl(final Context context) {
        super(context);
    }

    @Override
    public File generate(final CodeTableMeta codeTableMeta) throws Exception {
        final File entityFile = getFactory().getCodeTableEntityGenerator().generate(codeTableMeta);
        if (codeTableMeta.getSqlFileMeta() != null) {
            final CodeTableSqlMeta codeTableSqlMeta = new CodeTableSqlMetaImpl(codeTableMeta);
            getFactory().getCodeTableSqlGenerator().generate(codeTableSqlMeta);
        }
        return entityFile;
    }
}