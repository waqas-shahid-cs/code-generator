package com.cjs.jworks.generator.dto.base;

public interface CodeTableMeta extends EntityMeta {
    boolean isSorted();

    CodeTableSqlMeta getSqlFileMeta();

    CodeTableJSMeta getJSFileMeta();
}
