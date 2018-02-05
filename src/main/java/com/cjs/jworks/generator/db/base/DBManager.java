package com.cjs.jworks.generator.db.base;

import com.cjs.jworks.generator.context.Context;
import com.cjs.jworks.generator.dto.base.FieldMeta;

import java.sql.SQLException;

public abstract class DBManager {
    private final Context context;

    public DBManager(final Context context) {
        this.context = context;
    }

    protected Context getContext() {
        return context;
    }

    protected String getProperty(final String key, final String defaultValue) {
        return context.getProperties().getProperty(key, defaultValue);
    }

    public abstract FieldMeta[] getTableFields(final String tableName) throws SQLException;

    public abstract boolean execute(final String sql) throws SQLException;
}
