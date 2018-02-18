package com.cjs.jworks.generator.db.impl;

import com.cjs.jworks.generator.context.Context;
import com.cjs.jworks.generator.db.base.DBManager;
import com.cjs.jworks.generator.dto.base.FieldMeta;
import com.cjs.jworks.generator.dto.base.TableMeta;
import com.cjs.jworks.generator.dto.impl.FieldMetaImpl;
import com.cjs.jworks.generator.dto.impl.TableMetaImpl;
import com.cjs.jworks.generator.util.WordUtils;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

import static java.sql.Types.*;

public class DBManagerImpl extends DBManager {

    public DBManagerImpl(final Context context) throws ClassNotFoundException {
        super(context);
        Class.forName(getProperty("genDB.driver", ""));
    }

    private Connection createConnection() throws SQLException {
        final Connection connection = DriverManager.getConnection(getProperty("genDB.url", ""), getProperty("genDB.user", ""), getProperty("genDB.pass", ""));
        connection.setAutoCommit(false);
        return connection;
    }

    @Override
    public TableMeta getTableMeta(final String tableName) throws SQLException {
        final Connection connection = createConnection();
        final PreparedStatement preparedStatement = connection.prepareStatement("select * from " + getProperty("genDB.schema", "") + "." + tableName);
        try {
            final ResultSet rs = preparedStatement.executeQuery();
            final ResultSetMetaData metaData = rs.getMetaData();
            final FieldMeta[] fieldMetas = new FieldMeta[metaData.getColumnCount()];
            final String primaryKey = getPrimaryKey(tableName, connection);
            final Set<String> foreignKeys = getForeignKeys(tableName, connection);

            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                final FieldMeta fieldMeta = new FieldMetaImpl(getFieldName(metaData.getColumnName(i)), getColumnType(metaData.getColumnType(i)), metaData.getColumnName(i));
                fieldMeta.setNullable(metaData.isNullable(i) == 1);
                if (fieldMeta.getDbColumn().equals(primaryKey)) {
                    fieldMeta.setPrimaryKey(true);
                } else if (foreignKeys.contains(fieldMeta.getDbColumn())) {
                    fieldMeta.setForeignKey(true);
                }
                fieldMetas[i - 1] = fieldMeta;
            }
            return new TableMetaImpl(tableName, fieldMetas);
        } finally {
            preparedStatement.close();
            connection.close();
        }
    }

    private String getPrimaryKey(final String tableName, final Connection connection) throws SQLException {
        final DatabaseMetaData databaseMetaData = connection.getMetaData();
        try (final ResultSet resultSet = databaseMetaData.getPrimaryKeys(connection.getCatalog(), getProperty("genDB.schema", ""), tableName)) {
            while (resultSet.next()) {
                return resultSet.getString("COLUMN_NAME");
            }
        }
        return null;
    }

    private Set<String> getForeignKeys(final String tableName, final Connection connection) throws SQLException {
        final DatabaseMetaData databaseMetaData = connection.getMetaData();
        final Set<String> foreignKeys = new HashSet<>();
        try (final ResultSet resultSet = databaseMetaData.getImportedKeys(connection.getCatalog(), getProperty("genDB.schema", ""), tableName)) {
            while (resultSet.next()) {
                foreignKeys.add(resultSet.getString(8));
            }
        }
        return foreignKeys;
    }

    private String getColumnType(final int columnType) {
        switch (columnType) {
            case NUMERIC:
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
            ex.printStackTrace();
            connection.rollback();
            return false;
        } finally {
            ps.close();
            connection.close();
        }
    }
}
