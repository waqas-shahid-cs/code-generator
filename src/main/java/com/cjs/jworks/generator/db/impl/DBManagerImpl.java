package com.cjs.jworks.generator.db.impl;

import com.cjs.jworks.generator.context.Context;
import com.cjs.jworks.generator.db.base.DBManager;
import com.cjs.jworks.generator.dto.base.FieldMeta;
import com.cjs.jworks.generator.dto.impl.FieldMetaImpl;
import org.apache.commons.lang.WordUtils;

import java.sql.*;
import java.util.Set;

import static java.sql.Types.*;

public class DBManagerImpl extends DBManager {

    public DBManagerImpl(final Context context) throws ClassNotFoundException {
        super(context);
        Class.forName(getProperty("genDB.driver", ""));
    }

    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection(getProperty("genDB.url", ""), getProperty("genDB.user", ""), getProperty("genDB.pass", ""));
    }

    @Override
    public FieldMeta[] getTableFields(final String tableName) throws SQLException {
        final Connection connection = createConnection();
        final PreparedStatement preparedStatement = connection.prepareStatement("select * from " + tableName);
        try {
            getPrimaryKeys(tableName, connection);
            getForeignKeys(tableName, connection);

            final ResultSet rs = preparedStatement.executeQuery();
            final ResultSetMetaData metaData = rs.getMetaData();
            final FieldMeta[] fieldMetas = new FieldMeta[metaData.getColumnCount()];
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                final FieldMeta fieldMeta = new FieldMetaImpl(getFieldName(metaData.getColumnName(i)), getColumnType(metaData.getColumnType(i)), metaData.getColumnName(i));
                fieldMeta.setNullable(metaData.isNullable(i) == 1);
                fieldMetas[i - 1] = fieldMeta;
            }
            return fieldMetas;
        } finally {
            preparedStatement.close();
            connection.close();
        }
    }

    public Set<String> getPrimaryKeys(final String tableName, final Connection connection) throws SQLException {
        final DatabaseMetaData databaseMetaData = connection.getMetaData();
        try (ResultSet tables = databaseMetaData.getTables(null, null, "%", new String[]{tableName})) {
            while (tables.next()) {
                String catalog = tables.getString("TABLE_CAT");
                String schema = tables.getString("TABLE_SCHEM");
                String table = tables.getString("TABLE_NAME");
                System.out.println("Table: " + table);
                try (ResultSet primaryKeys = databaseMetaData.getPrimaryKeys(catalog, schema, tableName)) {
                    while (primaryKeys.next()) {
                        System.out.println("Primary key: " + primaryKeys.getString("COLUMN_NAME"));
                    }
                }
                // similar for exportedKeys
            }
        }
        return null;
    }

    public Set<String> getForeignKeys(final String tableName, final Connection connection) throws SQLException {
        final DatabaseMetaData databaseMetaData = connection.getMetaData();
        try (ResultSet tables = databaseMetaData.getTables(null, null, "%", new String[]{tableName})) {
            while (tables.next()) {
                String catalog = tables.getString("TABLE_CAT");
                String schema = tables.getString("TABLE_SCHEM");
                String table = tables.getString("TABLE_NAME");
                System.out.println("Table: " + table);
                try (ResultSet primaryKeys = databaseMetaData.getExportedKeys(catalog, schema, tableName)) {
                    while (primaryKeys.next()) {
                        System.out.println("Primary key: " + primaryKeys.getString("PKCOLUMN_NAME"));
                    }
                }
            }
        }
        return null;
    }

    private String getColumnType(final int columnType) {
        switch (columnType) {
            case BIGINT:
                return Long.class.getSimpleName();
            case INTEGER:
                return Integer.class.getSimpleName();
            case TINYINT:
                return Short.class.getSimpleName();
            case VARCHAR:
            case LONGVARCHAR:
                return String.class.getSimpleName();
            case CHAR:
                return Character.class.getSimpleName();
            case BOOLEAN:
                return Boolean.class.getSimpleName();
            case BIT:
            case BINARY:
                return Byte.class.getSimpleName();
            case DATE:
                return Date.class.getSimpleName();
            case TIME:
                return Date.class.getSimpleName();
            case TIMESTAMP:
                return Timestamp.class.getSimpleName();
            case REAL:
            case FLOAT:
                return Float.class.getSimpleName();
            case DECIMAL:
                return Double.class.getSimpleName();
        }
        return "";
    }

    private String getFieldName(String columnName) {
        columnName = WordUtils.capitalize(columnName.replace('_', ' ').toLowerCase(), new char[]{' '}).replace(" ", "");
        return WordUtils.initials(columnName).toLowerCase() + columnName.substring(1);
    }

    @Override
    public boolean execute(final String sql) throws SQLException {
        final Connection connection = createConnection();
        final PreparedStatement ps = connection.prepareStatement(sql);
        try {
            boolean result = ps.execute();
            connection.commit();
            return result;
        } catch (Exception ex) {
            connection.rollback();
            return false;
        } finally {
            ps.close();
            connection.close();
        }
    }
}
