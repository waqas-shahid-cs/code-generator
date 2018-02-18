package com.cjs.jworks.generator.generator.base;

import com.cjs.jworks.generator.context.Context;
import com.cjs.jworks.generator.dto.base.CodeTableMeta;
import com.cjs.jworks.generator.dto.base.EntityMeta;

public abstract class GeneratorFactory {
    private final Context context;

    public GeneratorFactory(final Context context) {
        this.context = context;
    }

    protected Context getContext() {
        return context;
    }

    public abstract <P extends EntityMeta> EntityGenerator<P> getEntityGenerator();

    public abstract DomainGenerator getDomainGenerator();

    public abstract FileGenerator getFileGenerator();

    public abstract FieldGenerator getFieldGenerator();

    public abstract GetterGenerator getGetterGenerator();

    public abstract SetterGenerator getSetterGenerator();

    public abstract RepositoryGenerator getRepositoryGenerator();

    public abstract ServiceGenerator getServiceGenerator();

    public abstract ControllerGenerator getControllerGenerator();

    public abstract EntityGenerator<CodeTableMeta> getCodeTableEntityGenerator();

    public abstract CodeTableFeatureGenerator getCodeTableFeatureGenerator();

    public abstract CodeTableSqlGenerator getCodeTableSqlGenerator();

    public abstract CodeTableJSFileGenerator getCodeTableJSGenerator();

}
